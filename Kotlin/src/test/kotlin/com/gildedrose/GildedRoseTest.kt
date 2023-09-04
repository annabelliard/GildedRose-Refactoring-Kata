package com.gildedrose

import com.gildedrose.model.Item
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class GildedRoseTest {

    @Test
    fun foo() {
        val items = listOf(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0])
    fun `quality degrades twice as fast after sell date`(days: Int) {
        val items = listOf(Item("foo", days, 20))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(18, app.items[0].quality)
    }

    @Test
    fun `quality degrades normally before sell date`() {
        val items = listOf(Item("foo", 2, 20))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(19, app.items[0].quality)
    }

    @Test
    fun `quality of an item is never negative`() {
        val items = listOf(Item("foo", 3, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun `Aged Brie increases in quality the older it gets`() {
        val items = listOf(Item("Aged Brie", 3, 5))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(6, app.items[0].quality)
    }

    @Test
    fun `The quality of an item is never more than 50`() {
        val items = listOf(Item("Aged Brie", 3, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun `Sulfuras never decreases in quality and is never sold`() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 3, 47))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(3, app.items[0].sellIn)
        assertEquals(47, app.items[0].quality)
    }

    @ParameterizedTest
    @ValueSource(ints = [10, 7, 6])
    fun `Backstage passes - Quality increases by 2 when there are 10 days or less`(days: Int) {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", days, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(42, app.items[0].quality)
    }

    @ParameterizedTest
    @ValueSource(ints = [5, 1])
    fun `Backstage passes - Quality increases by 3 when there are 5 days or less`(days: Int) {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", days, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(43, app.items[0].quality)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0])
    fun `Backstage passes - Quality decreases to 0 after the concert`(days: Int) {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", days, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }
}
