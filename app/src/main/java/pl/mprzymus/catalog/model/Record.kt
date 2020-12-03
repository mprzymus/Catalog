package pl.mprzymus.catalog.model

class Record(val name: String, val imageId: Int, private val categories: MutableList<Category>, var isFavourite: Boolean = false) {
    constructor(name: String, category: List<String>, imageId: Int, isFavourite: Boolean = false) : this(
        name, imageId,
        ArrayList(category.map { categoryName -> Category.getCategory(categoryName) }),
        isFavourite
    )

    fun getCategories(): String {
        return categories.joinToString { it.name }
    }

    fun addCategory(category: String) {
        categories.add(Category.getCategory(category))
    }

    fun addCategory(category: Category) {
        categories.add(category)
    }
}