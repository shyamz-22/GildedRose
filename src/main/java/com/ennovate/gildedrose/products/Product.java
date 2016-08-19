package com.ennovate.gildedrose.products;

import com.ennovate.gildedrose.Item;
import com.ennovate.gildedrose.products.quality.QualityStrategy;
import com.ennovate.gildedrose.products.sellIn.SellInStrategy;

public class Product {
    protected final QualityStrategy qualityStrategy;
    protected final SellInStrategy sellInStrategy;
    protected Item item;

    public Product(Item item, QualityStrategy qualityStrategy, SellInStrategy sellInStrategy) {
        this.sellInStrategy = sellInStrategy;
        this.item = item;
        this.qualityStrategy = qualityStrategy;
    }

    public void update() {
        item.setSellIn(sellInStrategy.applyAndReturn(item));
        item.setQuality(qualityStrategy.applyAndReturn(item));
    }
}
