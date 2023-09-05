package com.gildedrose.model.type

import com.gildedrose.model.Item
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import com.gildedrose.GildedRoseRefactored

class AgedBrieTest {
    @Test
    fun `Aged Brie increases in quality the older it gets`() {
        val items = listOf( Item("Aged Brie", 3, 5))
        val gildedRose = GildedRoseRefactored(items)
        gildedRose.updateQuality()
        Assertions.assertEquals(6, gildedRose.specifiedItems[0].quality)
    }
    @Test
    fun `The quality of an item is never more than 50`() {
        val items = listOf( Item("Aged Brie", 3, 50))
        val gildedRose = GildedRoseRefactored(items)
        gildedRose.updateQuality()
        Assertions.assertEquals(50, gildedRose.specifiedItems[0].quality)
    }
}