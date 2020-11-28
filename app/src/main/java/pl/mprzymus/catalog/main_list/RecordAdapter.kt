package pl.mprzymus.catalog.main_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.mprzymus.catalog.R

class RecordAdapter(private val dataSet: List<Record>) :
    RecyclerView.Adapter<RecordAdapter.RecordViewHolder>() {
    class RecordViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val tittle: TextView = itemView.findViewById(R.id.itemName)
        val image: ImageView = itemView.findViewById(R.id.recordImage)
        val category: TextView = itemView.findViewById(R.id.category)
    }

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
    }

    override fun getItemCount() = dataSet.size
}