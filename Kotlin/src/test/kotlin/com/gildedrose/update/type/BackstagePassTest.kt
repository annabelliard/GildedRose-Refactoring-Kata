package com.gildedrose.update.type

import com.gildedrose.model.Item
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BackstagePassTest {

    @ParameterizedTest
    @ValueSource(ints = [10, 7, 6])
    fun `Backstage passes - Quality increases by 2 when there are 10 days or less`(days: Int) {
        val backstagePass = Item("Backstage passes to a TAFKAL80ETC concert", days, 40)
        val backstagePassStrategy = BackstagePass()
        backstagePassStrategy.update(backstagePass)

        Assertions.assertEquals(42, backstagePass.quality)
    }

    @ParameterizedTest
    @ValueSource(ints = [5, 1])
    fun `Backstage passes - Quality increases by 3 when there are 5 days or less`(days: Int) {
        val backstagePass = Item("Backstage passes to a TAFKAL80ETC concert", days, 40)
        val backstagePassStrategy = BackstagePass()
        backstagePassStrategy.update(backstagePass)
        Assertions.assertEquals(43, backstagePass.quality)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0])
    fun `Backstage passes - Quality decreases to 0 after the concert`(days: Int) {
        val backstagePass = Item("Backstage passes to a TAFKAL80ETC concert", days, 40)
        val backstagePassStrategy = BackstagePass()
        backstagePassStrategy.update(backstagePass)
        Assertions.assertEquals(0, backstagePass.quality)
    }

    @Test
    fun `Backstage passes - Quality does not exceed 50`() {
        val backstagePass = Item("Backstage passes to a TAFKAL80ETC concert", 5, 500)
        val backstagePassStrategy = BackstagePass()
        backstagePassStrategy.update(backstagePass)
        Assertions.assertEquals(50, backstagePass.quality)
    }
}