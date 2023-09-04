package com.gildedrose

import com.gildedrose.model.Item
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
class IntegrationTest {

    @Test
    fun `happy flow test`(){
        val items = prepareData()
        val gildedRoseRefactored = GildedRoseRefactored()
        val items1 = gildedRoseRefactored.updateQuality(items)
        val items2 =gildedRoseRefactored.updateQuality(items1)
        Assertions.assertEquals("Aged Brie", items2[1].name)
        Assertions.assertEquals(2, items2[1].quality)
        Assertions.assertEquals(0, items2[1].sellIn)
        Assertions.assertEquals("Elixir of the Mongoose", items2[2].name)
        Assertions.assertEquals(5, items2[2].quality)
        Assertions.assertEquals(3, items2[2].sellIn)

    }


    fun prepareData(): List<Item> {
        return listOf(
            Item("+5 Dexterity Vest", 10, 20), //
            Item("Aged Brie", 2, 0), //
            Item("Elixir of the Mongoose", 5, 7), //
            Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            Item("Sulfuras, Hand of Ragnaros", -1, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            Item("Conjured Mana Cake", 3, 6)
        )
    }
}