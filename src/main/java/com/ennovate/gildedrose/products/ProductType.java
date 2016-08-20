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
        public Strategy updateStrategy(Item item) {

            return new Strategy(item, new QualityIncreasesStrategy(), new SellInDecreasesStrategy());
        }
    },

    BACKSTAGE_PASSES {
        @Override
        public Strategy updateStrategy(Item item) {
            return new Strategy(item, new QualityIncreasesWithSellInStrategy(), new SellInDecreasesStrategy());
        }
    },

    SULFURAS {
        @Override
        public Strategy updateStrategy(Item item) {
            return new Strategy(item, new QualityLegendaryStrategy(), new SellInNoChangeStrategy());
        }
    },

    CONJURED {
        @Override
        public Strategy updateStrategy(Item item) {
            return new Strategy(item, new QualityDecreasesStrategy(4,2), new SellInDecreasesStrategy());
        }
    },

    NORMAL {
        @Override
        public Strategy updateStrategy(Item item) {
            return new Strategy(item, new QualityDecreasesStrategy(), new SellInDecreasesStrategy());
        }
    };

    public abstract Strategy updateStrategy(Item item);

}
