package pl.mprzymus.catalog.main_list

import android.widget.ImageButton
import pl.mprzymus.catalog.model.Record

class RecordClickListener {

    fun onLikeClick(record: Record, button: ImageButton) {
        record.isFavourite = !record.isFavourite
        button.setImageResource(LikeButtonProvider.getImage(record.isFavourite))
    }
}