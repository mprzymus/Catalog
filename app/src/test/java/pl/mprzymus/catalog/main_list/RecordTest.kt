package pl.mprzymus.catalog.main_list

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import pl.mprzymus.catalog.model.Record

class RecordTest : FunSpec({
    val record = Record("tested", listOf("category1", "category2"), 1, "")
    test("Category format") {
        record.getCategories() shouldBe "category1, category2"
    }
})
