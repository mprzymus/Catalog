package pl.mprzymus.catalog

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.mprzymus.catalog.main_list.Bootstrap
import pl.mprzymus.catalog.model.Record

class CatalogViewModel : ViewModel() {
    val records = Bootstrap().initializeData()

    private val _favourites = MutableLiveData(false)
    val favourites: LiveData<Boolean>
        get() = _favourites

    private val _toShow = MutableLiveData<Record>()
    val toShow: LiveData<Record>
            get() = _toShow

    init {
        Log.d("View model", "Catalog view model created")
    }

    fun setToShow(newValue: Record) {
        _toShow.value = newValue
    }


    fun switchFavourites() {
        val newValue: Boolean = !_favourites.value!!
        _favourites.value = newValue
    }
}