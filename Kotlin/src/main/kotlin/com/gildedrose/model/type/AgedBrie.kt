package com.gildedrose.model.type

import com.gildedrose.model.BaseItem

class AgedBrie(name: String, sellIn: Int, quality: Int): BaseItem(name, sellIn, quality) {
    override fun updateQuality(){
        this.quality ++
    }
}