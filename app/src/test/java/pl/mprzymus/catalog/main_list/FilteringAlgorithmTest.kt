package pl.mprzymus.catalog.main_list

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import pl.mprzymus.catalog.model.Record

class FilteringAlgorithmTest : FunSpec({
    val filter = FilteringAlgorithm("linux")
    test("performFiltering") {
        val dataSet = Bootstrap().initializeTestData()
        filter.performFiltering(dataSet).size shouldBe 2
    }
})
