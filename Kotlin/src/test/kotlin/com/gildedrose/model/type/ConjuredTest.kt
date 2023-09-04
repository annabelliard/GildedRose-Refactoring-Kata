package com.gildedrose.model.type

import com.gildedrose.GildedRoseRefactored
import com.gildedrose.model.Item
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ConjuredTest {

    @Test
    fun `quality degrades twice as fast`() {
        val items = listOf( Item("Conjured", 5, 5))
        val gildedRose = GildedRoseRefactored()
        val updatedList = gildedRose.updateQuality(items)
        Assertions.assertEquals(3, updatedList[0].quality)
    }
}