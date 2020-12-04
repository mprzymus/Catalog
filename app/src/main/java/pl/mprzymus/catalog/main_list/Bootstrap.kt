package pl.mprzymus.catalog.main_list

import pl.mprzymus.catalog.R
import pl.mprzymus.catalog.model.Record

class Bootstrap {

    private val description = "Some information about meme, I don't know"
    private val links = listOf("https://en.wikipedia.org/wiki/Pepe_the_Frog", "https://www.adl.org/education/references/hate-symbols/pepe-the-frog", "https://knowyourmeme.com/memes/kekistan")
    private val veryLongList: List<String>

    init {
        veryLongList = (1..50).map { i -> i.toString() }.toList()
    }

    fun initializeData(): MutableList<Record> {
        val data = ArrayList<Record>()
        data.add(Record("Pepe", listOf("Classic"),  R.drawable.pepefroggie, description, links))
        data.add(Record("Nosacz", listOf("Polish", "Testo"), R.drawable.nosacz, description, veryLongList))
        data.add(Record("Arch linux", listOf("Linux", "Arch"), R.drawable.arch, description, veryLongList))
        data.add(Record("Anime", listOf("Chinese"), R.drawable.anime, description, links))
        data.add(Record("Pepe2", listOf("Classic"), R.drawable.pepefroggie, description, links))
        data.add(Record("Nosacz2", listOf("Polish", "Testo"), R.drawable.nosacz, description, links))
        data.add(Record("Arch linux2", listOf("Linux", "Arch"), R.drawable.arch, description, links))
        data.add(Record("Anime2", listOf("Chinese"), R.drawable.anime, description, links))
        return data
    }

    fun initializeTestData(): MutableList<Record> {
        val data = ArrayList<Record>()
        data.add(Record("Pepe", listOf("Classic"), 0, description, veryLongList))
        data.add(Record("Nosacz", listOf("Polish", "Testo"), 0, description, veryLongList))
        data.add(Record("Arch linux", listOf("Linux", "Arch"), 0, description, veryLongList))
        data.add(Record("Anime", listOf("Chinese"), 0, description, veryLongList))
        data.add(Record("Pepe2", listOf("Classic"), 0, description, veryLongList))
        data.add(Record("Nosacz2", listOf("Polish", "Testo"), 0, description, links))
        data.add(Record("Arch linux2", listOf("Linux", "Arch"), 0, description, links))
        data.add(Record("Anime2", listOf("Chinese"), 0, description, links))
        return data
    }
}