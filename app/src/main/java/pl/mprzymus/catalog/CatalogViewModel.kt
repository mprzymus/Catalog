package pl.mprzymus.catalog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.mprzymus.catalog.main_list.Bootstrap
import pl.mprzymus.catalog.model.Record

class CatalogViewModel : ViewModel() {
    fun switchFavourites() {
        val newValue: Boolean = !_favourites.value!!
        _favourites.value = newValue
    }

    private val _records = MutableLiveData<MutableList<Record>>()
    val records: LiveData<MutableList<Record>>
        get() = _records

    private val _favourites = MutableLiveData(false)
    val favourites: LiveData<Boolean>
        get() = _favourites

    init {
        val bootstrap = Bootstrap()
        _records.value = bootstrap.initializeData()
    }
}