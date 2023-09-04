package com.gildedrose.model

import com.gildedrose.config.QualityRequirements

open class BaseItem(name: String, sellIn: Int, quality: Int): Item(name, sellIn, quality) {

    open val maxQuality = QualityRequirements.MAX_QUALITY
    open val minQuality = QualityRequirements.MIN_QUALITY

    fun update() {
        updateQuality()
        checkMinMaxQuality()
        updateSellIn()
    }

    fun checkMinMaxQuality() {
        if(this.quality > maxQuality){
            this.quality = maxQuality
        }
        if(this.quality < minQuality){
            this.quality = minQuality
        }
    }

    open fun updateQuality(){
        if(this.sellIn <= 0 ){
            this.quality = this.quality - 2
        }
        else {
            this.quality --
        }
    }

    open fun updateSellIn(){
        this.sellIn --
    }
}