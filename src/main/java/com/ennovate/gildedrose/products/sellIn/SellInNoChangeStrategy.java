package com.ennovate.gildedrose.products.sellIn;

import com.ennovate.gildedrose.Item;

public class SellInNoChangeStrategy implements SellInStrategy {

    @Override
    public int applyAndReturn(Item item) {
        return item.getSellIn();
    }
}
