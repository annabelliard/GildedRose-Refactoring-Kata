package com.gildedrose.update.type

import com.gildedrose.model.Item
import com.gildedrose.update.BaseItem

class BackstagePass : BaseItem() {
    override fun updateQuality(item: Item) {
        with(item) {
            when {
                sellIn in 1..5 -> quality = quality.plus(3)
                sellIn in 6..10 -> quality = quality.plus(2)
                sellIn <= 0 -> quality = 0
                else -> quality++
            }
        }
    }
}