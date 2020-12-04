package pl.mprzymus.catalog.main_list

import pl.mprzymus.catalog.model.Record
import java.util.*

class FilteringAlgorithm(charSearch: String) {
    private val charSearch = charSearch.toLowerCase(Locale.ROOT)
    fun performFiltering(dataSet: List<Record>): List<Record> {
        return if (charSearch.isEmpty()) {
            dataSet
        } else {
            dataSet.fold(listOf(), { acc, element -> filter(acc, element) })
        }
    }

    private fun filter(list: List<Record>, element: Record): List<Record> {
        return if (element.getCategories().toLowerCase(Locale.ROOT).contains(charSearch)) {
            list + element
        } else {
            list
        }
    }
}