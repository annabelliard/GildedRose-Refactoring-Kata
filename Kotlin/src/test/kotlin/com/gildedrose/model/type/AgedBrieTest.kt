package com.gildedrose.model.type

import com.gildedrose.GildedRoseRefactored
import com.gildedrose.model.Item
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AgedBrieTest {
    @Test
    fun `Aged Brie increases in quality the older it gets`() {
        val items = listOf( Item("Aged Brie", 3, 5))
        val gildedRose = GildedRoseRefactored()
        val updatedList = gildedRose.updateQuality(items)
        Assertions.assertEquals(6, updatedList[0].quality)
    }
    @Test
    fun `The quality of an item is never more than 50`() {
        val items = listOf( Item("Aged Brie", 3, 50))
        val gildedRose = GildedRoseRefactored()
        val updatedList = gildedRose.updateQuality(items)
        Assertions.assertEquals(50, updatedList[0].quality)
    }
}