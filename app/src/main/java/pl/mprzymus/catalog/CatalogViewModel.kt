package pl.mprzymus.catalog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.mprzymus.catalog.main_list.Bootstrap
import pl.mprzymus.catalog.model.Record

class CatalogViewModel : ViewModel() {
    fun switchLike(index: Int) {
        val recordsList = _records.value
        if (recordsList != null) {
            recordsList[index].isFavourite = !recordsList[index].isFavourite
            _records.value = _records.value
        }
    }

    private val _records = MutableLiveData<MutableList<Record>>()
    val records: LiveData<MutableList<Record>>
        get() = _records

    init {
        val bootstrap = Bootstrap()
        _records.value = bootstrap.initializeData()
    }
}