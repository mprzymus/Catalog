package pl.mprzymus.catalog.main_list

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import pl.mprzymus.catalog.R
import pl.mprzymus.catalog.model.Record

class RecordAdapter(private val dataSet: MutableList<Record>) :
    RecyclerView.Adapter<RecordAdapter.RecordViewHolder>(), Filterable {
    class RecordViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val tittle: TextView = itemView.findViewById(R.id.itemName)
        val image: ImageView = itemView.findViewById(R.id.recordImage)
        val category: TextView = itemView.findViewById(R.id.category)
        val button: ImageButton = itemView.findViewById(R.id.button)
    }

    private val clickListener: RecordClickListener = RecordClickListener()
    private var filterList: List<Record> = dataSet

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecordViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_layout, parent, false)

        return RecordViewHolder(textView)
    }

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        holder.tittle.text = filterList[position].name
        holder.image.setImageResource(filterList[position].imageId)
        holder.category.text = filterList[position].getCategories()
        holder.button.setImageResource(LikeButtonProvider.getImage(filterList[position].isFavourite))
        holder.button.setOnClickListener { clickListener.onLikeClick(filterList[position], holder.button) }
    }

    override fun getItemCount(): Int {
        return filterList.size
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
                filterResults.values = filter.performFiltering(dataSet)
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                Log.d("Search view", "filtering performed")
                val list = results?.values
                if (list is List<*>) {
                    filterList = list as List<Record>
                }
                else {
                    Log.e("Casting error", list?.javaClass.toString())
                }
                notifyDataSetChanged()
            }
        }
    }
}