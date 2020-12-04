package pl.mprzymus.catalog.main_list

import android.util.Log
import android.widget.ImageButton
import pl.mprzymus.catalog.CatalogViewModel
import pl.mprzymus.catalog.model.Record

class RecordClickListener(private val viewModel: CatalogViewModel) {

    init {
        Log.wtf("Lifecycle", "created recordClickListener")
    }

    fun onLikeClick(record: Record, button: ImageButton) {
        record.isFavourite = !record.isFavourite
        button.setImageResource(LikeButtonProvider.getImage(record.isFavourite))
    }

    fun onRecordClick(record: Record) {
        Log.d("Click", "Record \'${record.name}\' was clicker")
        viewModel.setToShow(record)
    }
}