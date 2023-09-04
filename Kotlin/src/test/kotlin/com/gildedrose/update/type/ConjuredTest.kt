package com.gildedrose.update.type

import com.gildedrose.model.Item
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ConjuredTest {

    @Test
    fun `quality degrades twice as fast`() {
        val item = Item("foo", 5, 5)
        val conjured = Conjured()
        conjured.update(item)

        Assertions.assertEquals(3, item.quality)
    }
}