package com.ennovate.gildedrose.products.quality;

import com.ennovate.gildedrose.Item;

import static com.ennovate.gildedrose.products.quality.QualityScaleDeterminer.*;

public class QualityDecreasesStrategy implements QualityStrategy {

    private int mediumScale;
    private int normalScale;

    public QualityDecreasesStrategy() {
        this.mediumScale = MEDIUM_SCALE;
        this.normalScale = NORMAL_SCALE;
    }

    public QualityDecreasesStrategy(int mediumScale, int normalScale) {
        this.mediumScale = mediumScale;
        this.normalScale = normalScale;
    }

    @Override
    public int applyAndReturn(Item item) {
        if (item.getQuality() > 0) {
            final int scale = determine(item.isSellInPassed(), mediumScale, normalScale);
            final int calculated = item.getQuality() - scale;
            return calculated > 0 ? calculated : 0;
        }
        return item.getQuality();
    }

}
