package com.ennovate.gildedrose.products.quality;

import com.ennovate.gildedrose.Item;

public class QualityLegendaryStrategy implements QualityStrategy {
    @Override
    public int applyAndReturn(Item item) {
        return LEGENDARY_QUALITY_CONSTANT;
    }
}
