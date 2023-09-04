package com.gildedrose.update.type

import com.gildedrose.config.QualityRequirements
import com.gildedrose.model.Item
import com.gildedrose.update.BaseItem

class Sulfuras: BaseItem() {

    override val maxQuality = QualityRequirements.MAX_QUALITY_SULFURAS

    override fun updateQuality(item: Item){
        //Do nothing as Sulfuras is a legendary item that cannot be decreased in quality
    }

    override fun updateSellIn(item: Item){
        //Do nothing as Sulfuras is a legendary item that cannot be sold
    }
}