package com.gildedrose.update

import com.gildedrose.config.QualityRequirements
import com.gildedrose.model.Item

open class BaseItem {

    open val maxQuality = QualityRequirements.MAX_QUALITY
    open val minQuality = QualityRequirements.MIN_QUALITY

    fun update(item: Item) {
        updateQuality(item)
        checkMinMaxQuality(item)
        updateSellIn(item)
    }

    fun checkMinMaxQuality(item: Item) {
        if(item.quality > maxQuality){
            item.quality = maxQuality
        }
        if(item.quality < minQuality){
            item.quality = minQuality
        }
    }

    open fun updateQuality(item: Item){
        if(item.sellIn <= 0 ){
            item.quality = item.quality - 2
        }
        else {
            item.quality --
        }
    }

    open fun updateSellIn(item: Item){
        item.sellIn --
    }
}