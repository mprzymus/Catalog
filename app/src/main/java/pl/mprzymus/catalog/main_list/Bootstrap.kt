package pl.mprzymus.catalog.main_list

import pl.mprzymus.catalog.R

class Bootstrap {
    val data = ArrayList<Record>()

    init {
        data.add(Record("Pepe", listOf("Classic"), R.drawable.pepefroggie))
        data.add(Record("Nosacz", listOf("Polish", "Testo"), R.drawable.nosacz))
        data.add(Record("Arch linux", listOf("Linux", "Arch"), R.drawable.arch))

        //data.add(Record())
        //data.add(Record())
    }
}