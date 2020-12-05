package pl.mprzymus.catalog.main_list

import pl.mprzymus.catalog.R
import pl.mprzymus.catalog.model.Record

class Bootstrap {

    private val description = "Some information about meme, I don't know. BTW, I know anime is not chinese"
    private val links = listOf("https://en.wikipedia.org/wiki/Pepe_the_Frog", "https://www.adl.org/education/references/hate-symbols/pepe-the-frog", "https://knowyourmeme.com/memes/kekistan")
    private val veryLongList: List<String>
    private val graphic: List<Int>

    init {
        veryLongList = (1..50).map { i -> i.toString() }.toList()
        graphic = listOf(R.drawable.anime, R.drawable.arch, R.drawable.pepefroggie, R.drawable.kekistan)
    }

    fun initializeData(): MutableList<Record> {
        val data = ArrayList<Record>()
        data.add(Record("Pepe", listOf("Classic"),  R.drawable.pepefroggie, description, links, graphic))
        data.add(Record("Nosacz", listOf("Polish", "Testo"), R.drawable.nosacz, description, veryLongList, graphic))
        data.add(Record("Arch linux", listOf("Linux", "Arch"), R.drawable.arch, description, veryLongList, graphic))
        data.add(Record("Anime", listOf("Chinese"), R.drawable.anime, description, links, graphic))
        data.add(Record("Pepe2", listOf("Classic"), R.drawable.pepefroggie, description, links, graphic))
        data.add(Record("Nosacz2", listOf("Polish", "Testo"), R.drawable.nosacz, description, links, graphic))
        data.add(Record("Arch linux2", listOf("Linux", "Arch"), R.drawable.arch, description, links, graphic))
        data.add(Record("Anime2", listOf("Chinese"), R.drawable.anime, description, links, graphic))
        return data
    }

    fun initializeTestData(): MutableList<Record> {
        val data = ArrayList<Record>()
        data.add(Record("Pepe", listOf("Classic"), 0, description, veryLongList, graphic))
        data.add(Record("Nosacz", listOf("Polish", "Testo"), 0, description, veryLongList, graphic))
        data.add(Record("Arch linux", listOf("Linux", "Arch"), 0, description, veryLongList, graphic))
        data.add(Record("Anime", listOf("Chinese"), 0, description, veryLongList, graphic))
        data.add(Record("Pepe2", listOf("Classic"), 0, description, veryLongList, graphic))
        data.add(Record("Nosacz2", listOf("Polish", "Testo"), 0, description, links, graphic))
        data.add(Record("Arch linux2", listOf("Linux", "Arch"), 0, description, links, graphic))
        data.add(Record("Anime2", listOf("Chinese"), 0, description, links, graphic))
        return data
    }
}