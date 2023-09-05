package com.gildedrose.model.type

import com.gildedrose.config.QualityRequirements
import com.gildedrose.model.BaseItem

class Sulfuras(name: String, sellIn: Int, quality: Int) : BaseItem(name, sellIn, quality) {
    override fun getMaxQuality(): Int {
        return QualityRequirements.MAX_QUALITY_SULFURAS
    }

    override fun updateQuality() {
        //Do nothing as Sulfuras is a legendary item that cannot be decreased in quality
    }

    override fun updateSellIn() {
        //Do nothing as Sulfuras is a legendary item that cannot be sold
    }
}