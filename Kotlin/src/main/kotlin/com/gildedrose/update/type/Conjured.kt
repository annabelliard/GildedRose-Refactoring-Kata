package com.gildedrose.update.type

import com.gildedrose.model.Item
import com.gildedrose.update.BaseItem

class Conjured: BaseItem() {
    override fun updateQuality(item: Item){
        item.quality = item.quality.minus(2)
    }
}