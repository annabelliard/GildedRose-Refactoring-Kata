package com.gildedrose.assignment

import com.gildedrose.model.BaseItem
import com.gildedrose.model.Item

interface ItemAssignment {
    fun assignItem(item: Item): BaseItem
}