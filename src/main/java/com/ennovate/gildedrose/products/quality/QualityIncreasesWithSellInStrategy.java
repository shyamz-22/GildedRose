package com.ennovate.gildedrose.products.quality;

import com.ennovate.gildedrose.Item;

import static com.ennovate.gildedrose.products.quality.QualityScaleDeterminer.*;

public class QualityIncreasesWithSellInStrategy implements QualityStrategy {

    @Override
    public int applyAndReturn(Item item) {
        final int scale = determine(item.isSellInPassed(), item.getSellIn());
        return calculateQuality(item, scale);
    }

    private int calculateQuality(Item item, int scale) {
        if ( scale > 0) {
            int calculated = item.getQuality() + scale;
            scale = compareWithMaxQuality(calculated);
        }
        return scale;
    }

    private int compareWithMaxQuality(int calculated) {
        if (calculated > MAX_QUALITY_THRESHOLD) {
            return MAX_QUALITY_THRESHOLD;
        } else {
            return calculated;
        }
    }
}
