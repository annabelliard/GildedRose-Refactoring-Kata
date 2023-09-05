package com.gildedrose.assignment.impl

import com.gildedrose.assignment.ItemAssignment
import com.gildedrose.assignment.ItemAssignmentFactory

class ItemAssignmentFactoryImpl: ItemAssignmentFactory {
    override fun createItemAssignment(): ItemAssignment {
        return ItemAssignmentImpl()
    }
}