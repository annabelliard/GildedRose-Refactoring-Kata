package com.gildedrose.update.type

import com.gildedrose.model.Item
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SulfurasTest {
    @Test
    fun `Sulfuras never decreases in quality and is never sold`() {
        val item = Item("Sulfuras, Hand of Ragnaros", 3, 47)

        val sulfuras = Sulfuras()
        sulfuras.update(item)

        Assertions.assertEquals(3, item.sellIn)
        Assertions.assertEquals(47, item.quality)
    }
}