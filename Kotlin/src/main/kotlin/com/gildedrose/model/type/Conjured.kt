package com.gildedrose.model.type

import com.gildedrose.model.BaseItem

class Conjured(name: String, sellIn: Int, quality: Int): BaseItem(name, sellIn, quality) {
    override fun updateQuality() {
        this.quality = this.quality.minus(2)
    }
}