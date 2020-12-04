package pl.mprzymus.catalog.main_list

import pl.mprzymus.catalog.R
import pl.mprzymus.catalog.model.Record

class Bootstrap {

    private val description = "Some information about meme, I don't know"

    fun initializeData(): MutableList<Record> {
        val data = ArrayList<Record>()
        data.add(Record("Pepe", listOf("Classic"),  R.drawable.pepefroggie, description))
        data.add(Record("Nosacz", listOf("Polish", "Testo"), R.drawable.nosacz, description))
        data.add(Record("Arch linux", listOf("Linux", "Arch"), R.drawable.arch, description))
        data.add(Record("Anime", listOf("Chinese"), R.drawable.anime, description))
        data.add(Record("Pepe2", listOf("Classic"), R.drawable.pepefroggie, description))
        data.add(Record("Nosacz2", listOf("Polish", "Testo"), R.drawable.nosacz, description))
        data.add(Record("Arch linux2", listOf("Linux", "Arch"), R.drawable.arch, description))
        data.add(Record("Anime2", listOf("Chinese"), R.drawable.anime, description))
        return data
    }

    fun initializeTestData(): MutableList<Record> {
        val data = ArrayList<Record>()
        data.add(Record("Pepe", listOf("Classic"), 0, description))
        data.add(Record("Nosacz", listOf("Polish", "Testo"), 0, description))
        data.add(Record("Arch linux", listOf("Linux", "Arch"), 0, description))
        data.add(Record("Anime", listOf("Chinese"), 0, description))
        data.add(Record("Pepe2", listOf("Classic"), 0, description))
        data.add(Record("Nosacz2", listOf("Polish", "Testo"), 0, description))
        data.add(Record("Arch linux2", listOf("Linux", "Arch"), 0, description))
        data.add(Record("Anime2", listOf("Chinese"), 0, description))
        return data
    }
}