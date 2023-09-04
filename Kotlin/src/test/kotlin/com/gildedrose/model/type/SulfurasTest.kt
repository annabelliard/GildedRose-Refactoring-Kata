package com.gildedrose.model.type

import com.gildedrose.GildedRoseRefactored
import com.gildedrose.model.Item
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SulfurasTest {
    @Test
    fun `Sulfuras never decreases in quality and is never sold`() {
        val items = listOf( Item("Sulfuras, Hand of Ragnaros", 3, 47))
        val gildedRose = GildedRoseRefactored()
        val updatedList = gildedRose.updateQuality(items)
        Assertions.assertEquals(3, updatedList[0].sellIn)
        Assertions.assertEquals(47, updatedList[0].quality)
    }
}