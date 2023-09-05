package com.gildedrose

import com.gildedrose.model.Item
import com.gildedrose.model.BaseItem
import com.gildedrose.model.type.AgedBrie
import com.gildedrose.model.type.BackstagePass
import com.gildedrose.model.type.Conjured
import com.gildedrose.model.type.Sulfuras

class GildedRoseRefactored(items: List<Item>) {

    val specifiedItems: List<BaseItem>

    init {
        this.specifiedItems = items.map { assignItem(it) }
    }

    fun updateQuality(){
        return specifiedItems.forEach { it.update() }
    }

    private fun assignItem(item: Item): BaseItem {
        with(item.name) {
            return when {
                contains("Aged Brie") -> AgedBrie(item.name, item.sellIn, item.quality)
                contains("Sulfuras") -> Sulfuras(item.name, item.sellIn, item.quality)
                contains("Backstage") -> BackstagePass(item.name, item.sellIn, item.quality)
                contains("Conjured") -> Conjured(item.name, item.sellIn, item.quality)
                else -> BaseItem(item.name, item.sellIn, item.quality)
            }
        }
    }
}