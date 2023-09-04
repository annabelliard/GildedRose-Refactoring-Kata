package com.gildedrose.update.type

import com.gildedrose.model.Item
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AgedBrieTest {
    @Test
    fun `Aged Brie increases in quality the older it gets`() {
        val brie = Item("Aged Brie", 3, 5)
        val updateStrategy = AgedBrie()
        updateStrategy.update(brie)

        Assertions.assertEquals(6, brie.quality)
    }
    @Test
    fun `The quality of an item is never more than 50`() {
        val brie = Item("Aged Brie", 3, 50)
        val updateStrategy = AgedBrie()
        updateStrategy.update(brie)

        Assertions.assertEquals(50, brie.quality)
    }
}