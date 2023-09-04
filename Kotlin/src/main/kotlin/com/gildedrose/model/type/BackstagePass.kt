package com.gildedrose.model.type

import com.gildedrose.model.BaseItem

class BackstagePass(name: String, sellIn: Int, quality: Int): BaseItem(name, sellIn, quality) {
    override fun updateQuality () {
        with(this) {
            when {
                sellIn in 1..5 -> quality = quality.plus(3)
                sellIn in 6..10 -> quality = quality.plus(2)
                sellIn <= 0 -> quality = 0
                else -> quality++
            }
        }
    }
}