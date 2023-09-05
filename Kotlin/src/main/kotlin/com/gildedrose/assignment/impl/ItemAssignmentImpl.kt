package com.gildedrose.assignment.impl

import com.gildedrose.assignment.ItemAssignment
import com.gildedrose.model.BaseItem
import com.gildedrose.model.Item
import com.gildedrose.model.type.AgedBrie
import com.gildedrose.model.type.BackstagePass
import com.gildedrose.model.type.Conjured
import com.gildedrose.model.type.Sulfuras

class ItemAssignmentImpl: ItemAssignment {
    override fun assignItem(item: Item): BaseItem {
        with(item) {
            return when {
                name.contains("Aged Brie") -> AgedBrie(name, sellIn, quality)
                name.contains("Sulfuras") -> Sulfuras(name, sellIn, quality)
                name.contains("Backstage") -> BackstagePass(name, sellIn, quality)
                name.contains("Conjured") -> Conjured(name, sellIn, quality)
                else -> BaseItem(name, sellIn, quality)
            }
        }
    }
}