package pl.mprzymus.catalog.model

class Category private constructor(val name: String) {
    override fun hashCode(): Int {
        return name.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Category

        if (name != other.name) return false

        return true
    }

    companion object CategoryFactory {
        private val categories = HashMap<String, Category>()

        fun getCategory(category: String) : Category {
            return categories[category]?:createNewCategory(category)
        }

        private fun createNewCategory(category: String): Category {
            val newCategory = Category(category)
            categories[category] = newCategory
            return newCategory
        }
    }
}