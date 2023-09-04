package com.gildedrose.model.type

import com.gildedrose.GildedRoseRefactored
import com.gildedrose.model.Item
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BackstagePassTest {

    @ParameterizedTest
    @ValueSource(ints = [10, 7, 6])
    fun `Backstage passes - Quality increases by 2 when there are 10 days or less`(days: Int) {

        val items = listOf( Item("Backstage passes to a TAFKAL80ETC concert", days, 40))
        val gildedRose = GildedRoseRefactored()
        val updatedList = gildedRose.updateQuality(items)
        Assertions.assertEquals(42, updatedList[0].quality)
    }

    @ParameterizedTest
    @ValueSource(ints = [5, 1])
    fun `Backstage passes - Quality increases by 3 when there are 5 days or less`(days: Int) {
        val items = listOf( Item("Backstage passes to a TAFKAL80ETC concert", days, 40))
        val gildedRose = GildedRoseRefactored()
        val updatedList = gildedRose.updateQuality(items)
        Assertions.assertEquals(43, updatedList[0].quality)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0])
    fun `Backstage passes - Quality decreases to 0 after the concert`(days: Int) {
        val items = listOf( Item("Backstage passes to a TAFKAL80ETC concert", days, 40))
        val gildedRose = GildedRoseRefactored()
        val updatedList = gildedRose.updateQuality(items)
        Assertions.assertEquals(0, updatedList[0].quality)
    }

    @Test
    fun `Backstage passes - Quality does not exceed 50`() {
        val items = listOf( Item("Backstage passes to a TAFKAL80ETC concert", 5, 50))
        val gildedRose = GildedRoseRefactored()
        val updatedList = gildedRose.updateQuality(items)
        Assertions.assertEquals(50, updatedList[0].quality)
    }
}