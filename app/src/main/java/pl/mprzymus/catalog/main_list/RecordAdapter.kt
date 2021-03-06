package pl.mprzymus.catalog.main_list

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import pl.mprzymus.catalog.R
import pl.mprzymus.catalog.model.Record

class RecordAdapter(
    private val dataSet: MutableList<Record>,
    private val clickListener: RecordClickListener,
    private val secondaryColor: Int
) :
    RecyclerView.Adapter<RecordAdapter.RecordViewHolder>(), Filterable {
    class RecordViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val tittle: TextView = itemView.findViewById(R.id.itemName)
        val image: ImageView = itemView.findViewById(R.id.recordImage)
        val category: TextView = itemView.findViewById(R.id.category)
        val button: ImageButton = itemView.findViewById(R.id.button)
    }

    private var showedList: List<Record>
    private var showOnlyFavourites = false

    init {
        showedList = dataSet
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecordViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_layout, parent, false)

        return RecordViewHolder(textView)
    }

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        holder.itemView.setOnClickListener { clickListener.onRecordClick(showedList[position]) }
        holder.tittle.text = showedList[position].name
        holder.image.setImageResource(showedList[position].imageId)
        holder.category.text = showedList[position].getCategories()
        holder.button.setImageResource(LikeButtonProvider.getImage(showedList[position].isFavourite))
        holder.button.setOnClickListener {
            clickListener.onLikeClick(
                showedList[position],
                holder.button
            )
        }
        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(secondaryColor)
        }
    }

    override fun getItemCount(): Int {
        return showedList.size
    }

    fun deleteItem(position: Int) {
        dataSet.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                val filter = FilteringAlgorithm(charSearch)
                val filterResults = FilterResults()
                val toShow = filter.performFiltering(dataSet)
                Log.d("Show", "$showOnlyFavourites")
                showedList = if (showOnlyFavourites) {
                    removeNotFavourites(toShow)
                } else {
                    toShow
                }
                filterResults.values = showedList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                Log.d("Search view", "filtering performed")
                val list = results?.values
                if (list is List<*>) {
                    showedList = list as List<Record>
                } else {
                    Log.e("Casting error", list?.javaClass.toString())
                }
                notifyDataSetChanged()
            }
        }
    }

    fun switchFavouriteShow(shouldShowOnlyFavourites: Boolean, currentConstraint: String) {
        Log.d("Favourite", "Favourite toggled to: $shouldShowOnlyFavourites")
        this.showOnlyFavourites = shouldShowOnlyFavourites
        showedList = if (shouldShowOnlyFavourites) {
            removeNotFavourites()
        } else {
            FilteringAlgorithm(currentConstraint).performFiltering(dataSet)
        }
        notifyDataSetChanged()
    }

    private fun removeNotFavourites(toRemove: List<Record> = showedList): List<Record> {
        return toRemove.filter { element -> element.isFavourite }
    }
}