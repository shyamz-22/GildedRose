package com.ennovate.gildedrose.products.quality;

import com.ennovate.gildedrose.Item;

import static com.ennovate.gildedrose.products.quality.QualityScaleDeterminer.*;

public class QualityIncreasesStrategy implements QualityStrategy {

    @Override
    public int applyAndReturn(Item item) {
        if (item.notMaximumQuality()) {
            final int scale = determine(item.isSellInPassed());
            return (item.getQuality() + scale);
        }
        return item.getQuality();
    }

}