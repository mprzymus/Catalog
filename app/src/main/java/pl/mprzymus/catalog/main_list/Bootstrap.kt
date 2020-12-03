package pl.mprzymus.catalog.main_list

import pl.mprzymus.catalog.R
import pl.mprzymus.catalog.model.Record

class Bootstrap {


    fun initializeData(): MutableList<Record> {
        val data = ArrayList<Record>()
        data.add(Record("Pepe", listOf("Classic"), R.drawable.pepefroggie))
        data.add(Record("Nosacz", listOf("Polish", "Testo"), R.drawable.nosacz))
        data.add(Record("Arch linux", listOf("Linux", "Arch"), R.drawable.arch))
        data.add(Record("Anime", listOf("Chinese"), R.drawable.anime))
        data.add(Record("Pepe2", listOf("Classic"), R.drawable.pepefroggie))
        data.add(Record("Nosacz2", listOf("Polish", "Testo"), R.drawable.nosacz))
        data.add(Record("Arch linux2", listOf("Linux", "Arch"), R.drawable.arch))
        data.add(Record("Anime2", listOf("Chinese"), R.drawable.anime))
        return data
    }
}