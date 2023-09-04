package com.gildedrose.update

import com.gildedrose.model.Item
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BaseItemTest {

    @ParameterizedTest
    @ValueSource(ints = [-1, 0])
    fun `quality degrades twice as fast after sell date`(days: Int) {
        val item = Item("foo", days, 5)
        val baseItem = BaseItem()
        baseItem.update(item)

        Assertions.assertEquals(3, item.quality)
    }

    @Test
    fun `quality degrades normally before sell date`() {
        val item = Item("foo", 3, 5)
        val baseItem = BaseItem()
        baseItem.update(item)

        Assertions.assertEquals(4, item.quality)
    }

    @Test
    fun `quality of an item is never negative`() {
        val items = Item("foo", 3, 0)
        val baseItem = BaseItem()
        baseItem.update(items)

        Assertions.assertEquals(0, items.quality)
    }
}