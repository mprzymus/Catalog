package pl.mprzymus.catalog.main_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.mprzymus.catalog.R

class RecordAdapter(private val dataSet: ArrayList<Record>) :
    RecyclerView.Adapter<RecordAdapter.RecordViewHolder>() {
    class RecordViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val number: TextView = itemView.findViewById(R.id.history_number)
        val textView: TextView = itemView.findViewById(R.id.itemDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecordViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_layout, parent, false)

        return RecordViewHolder(textView)
    }

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        holder.number.text = position.toString()
        holder.textView.text = position.toString()
    }

    override fun getItemCount() = dataSet.size
}