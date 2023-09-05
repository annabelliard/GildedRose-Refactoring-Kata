package com.gildedrose.model

import com.gildedrose.config.QualityRequirements

open class BaseItem(name: String, sellIn: Int, quality: Int): Item(name, sellIn, quality) {

    fun update() {
        updateQuality()
        checkMinMaxQuality()
        updateSellIn()
    }

    open fun getMaxQuality(): Int {
        return QualityRequirements.MAX_QUALITY
    }

    open fun getMinQuality(): Int {
        return QualityRequirements.MIN_QUALITY
    }

    fun checkMinMaxQuality() {
        with(this){
             if(quality > getMaxQuality()) { quality = getMaxQuality()}
             if(quality < getMinQuality()) { quality = getMinQuality()}
        }
    }

    open fun updateQuality(){
        if(this.sellIn <= 0 ){
            this.quality = this.quality.minus(2)
        }
        else {
            this.quality --
        }
    }

    open fun updateSellIn(){
        this.sellIn --
    }
}