package com.ennovate.gildedrose.products;

import com.ennovate.gildedrose.Item;
import com.ennovate.gildedrose.products.quality.QualityDecreasesStrategy;
import com.ennovate.gildedrose.products.quality.QualityIncreasesStrategy;
import com.ennovate.gildedrose.products.quality.QualityIncreasesWithSellInStrategy;
import com.ennovate.gildedrose.products.quality.QualityLegendaryStrategy;
import com.ennovate.gildedrose.products.sellIn.SellInDecreasesStrategy;
import com.ennovate.gildedrose.products.sellIn.SellInNoChangeStrategy;

public enum ProductType {

    AGEDBRIE {
        @Override
        public void update(Item item) {

            new Strategy(item, new QualityIncreasesStrategy(), new SellInDecreasesStrategy()).update();
        }
    },

    BACKSTAGE_PASSES {
        @Override
        public void update(Item item) {
            new Strategy(item,
                    new QualityIncreasesWithSellInStrategy(),
                    new SellInDecreasesStrategy()).update();
        }
    },

    SULFURAS {
        @Override
        public void update(Item item) {
            new Strategy(item, new QualityLegendaryStrategy(), new SellInNoChangeStrategy()).update();
        }
    },

    CONJURED {
        @Override
        public void update(Item item) {
            new Strategy(item, new QualityDecreasesStrategy(4,2), new SellInDecreasesStrategy()).update();
        }
    },

    NORMAL {
        @Override
        public void update(Item item) {
            new Strategy(item, new QualityDecreasesStrategy(), new SellInDecreasesStrategy()).update();
        }
    };

    public abstract void update(Item item);

}
