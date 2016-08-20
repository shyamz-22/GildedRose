package com.ennovate.gildedrose.products;

import com.ennovate.gildedrose.Item;
import com.ennovate.gildedrose.products.quality.QualityStrategy;
import com.ennovate.gildedrose.products.sellIn.SellInStrategy;

public class Strategy {
    protected final QualityStrategy qualityStrategy;
    protected final SellInStrategy sellInStrategy;
    protected Item item;

    public Strategy(Item item, QualityStrategy qualityStrategy, SellInStrategy sellInStrategy) {
        this.item = item;
        this.sellInStrategy = sellInStrategy;
        this.qualityStrategy = qualityStrategy;
    }

    public void update() {
        item.setSellIn(sellInStrategy.applyAndReturn(item));
        item.setQuality(qualityStrategy.applyAndReturn(item));
    }
}
