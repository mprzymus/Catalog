package pl.mprzymus.catalog.record_details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import pl.mprzymus.catalog.R

class GalleryRecycleAdapter(private val dataSet: List<Int>) :
    RecyclerView.Adapter<GalleryRecycleAdapter.GalleryViewHolder>() {
    class GalleryViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val image: ImageView = itemView.findViewById(R.id.galleryImage)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GalleryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.image_element, parent, false)
        return GalleryViewHolder(view)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.image.setImageResource(dataSet[position])
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}