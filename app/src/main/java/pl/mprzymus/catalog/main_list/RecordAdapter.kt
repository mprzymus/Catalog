package pl.mprzymus.catalog.main_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import pl.mprzymus.catalog.CatalogViewModel
import pl.mprzymus.catalog.R
import pl.mprzymus.catalog.model.Record

class RecordAdapter(private val dataSet: MutableList<Record>) :
    RecyclerView.Adapter<RecordAdapter.RecordViewHolder>() {
    class RecordViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val tittle: TextView = itemView.findViewById(R.id.itemName)
        val image: ImageView = itemView.findViewById(R.id.recordImage)
        val category: TextView = itemView.findViewById(R.id.category)
        val button: ImageButton = itemView.findViewById(R.id.button)
    }

    private val clickListener: RecordClickListener = RecordClickListener()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecordViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_layout, parent, false)

        return RecordViewHolder(textView)
    }

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        holder.tittle.text = dataSet[position].name
        holder.image.setImageResource(dataSet[position].imageId)
        holder.category.text = dataSet[position].getCategories()
        holder.button.setImageResource(LikeButtonProvider.getImage(dataSet[position].isFavourite))
        holder.button.setOnClickListener { clickListener.onLikeClick(dataSet[position], holder.button) }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun deleteItem(position: Int) {
        dataSet.removeAt(position)
        notifyItemRemoved(position)
    }
}