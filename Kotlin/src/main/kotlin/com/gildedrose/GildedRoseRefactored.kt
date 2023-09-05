package com.gildedrose

import com.gildedrose.assignment.ItemAssignment
import com.gildedrose.assignment.impl.ItemAssignmentFactoryImpl
import com.gildedrose.model.BaseItem
import com.gildedrose.model.Item

class GildedRoseRefactored(items: List<Item>) {

    val specifiedItems: List<BaseItem>
    val itemAssignment: ItemAssignment = ItemAssignmentFactoryImpl().createItemAssignment()

    init {
        this.specifiedItems = items.map { itemAssignment.assignItem(it) }
    }

    fun updateQuality(){
        return specifiedItems.forEach { it.update() }
    }
}