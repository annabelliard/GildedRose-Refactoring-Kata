package com.gildedrose

import com.gildedrose.model.Item
import com.gildedrose.update.BaseItem
import com.gildedrose.update.type.AgedBrie
import com.gildedrose.update.type.BackstagePass
import com.gildedrose.update.type.Conjured
import com.gildedrose.update.type.Sulfuras

class GildedRoseRefactored(var items: List<Item>) {

    private val regularItem = BaseItem()
    private val agedBrie = AgedBrie()
    private val sulfuras = Sulfuras()
    private val backstagePass = BackstagePass()
    private val conjured = Conjured()

    fun updateQuality() {
        items.forEach {
            updateItem(it)
        }
    }

    private fun updateItem(item: Item){
        with(item.name){
            when {
                contains("Aged Brie") -> agedBrie.update(item)
                contains("Sulfuras")-> sulfuras.update(item)
                contains("Backstage")-> backstagePass.update(item)
                contains("Conjured")-> conjured.update(item)
                else -> regularItem.update(item)
            }
        }
    }
}