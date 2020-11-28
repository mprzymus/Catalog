package pl.mprzymus.catalog.main_list

class Record(val name: String, private val category: List<String>, val imageId: Int) {
    fun getCategories() : String {
        return category.joinToString { it }
    }
}