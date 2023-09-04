package com.gildedrose.model

import com.gildedrose.GildedRoseRefactored
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BaseItemTest {

    @ParameterizedTest
    @ValueSource(ints = [-1, 0])
    fun `quality degrades twice as fast after sell date`(days: Int) {
        val items = listOf( Item("foo", days, 5))
        val gildedRose = GildedRoseRefactored()
        val updatedList = gildedRose.updateQuality(items)
        Assertions.assertEquals(3, updatedList[0].quality)
    }

    @Test
    fun `quality degrades normally before sell date`() {
        val items = listOf( Item("foo", 3, 5))
        val gildedRose = GildedRoseRefactored()
        val updatedList = gildedRose.updateQuality(items)
        Assertions.assertEquals(4, updatedList[0].quality)
    }

    @Test
    fun `quality of an item is never negative`() {
        val items = listOf( Item("foo", 3, 0))
        val gildedRose = GildedRoseRefactored()
        val updatedList = gildedRose.updateQuality(items)
        Assertions.assertEquals(0, updatedList[0].quality)
    }
}