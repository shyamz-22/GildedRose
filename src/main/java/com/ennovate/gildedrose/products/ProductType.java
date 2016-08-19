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
        public Product updateStrategy(Item item) {

            return new Product(item, new QualityIncreasesStrategy(), new SellInDecreasesStrategy());
        }
    },

    BACKSTAGE_PASSES {
        @Override
        public Product updateStrategy(Item item) {
            return new Product(item, new QualityIncreasesWithSellInStrategy(), new SellInDecreasesStrategy());
        }
    },

    SULFURAS {
        @Override
        public Product updateStrategy(Item item) {
            return new Product(item, new QualityLegendaryStrategy(), new SellInNoChangeStrategy());
        }
    },

    CONJURED {
        @Override
        public Product updateStrategy(Item item) {
            return new Product(item, new QualityDecreasesStrategy(4,2), new SellInDecreasesStrategy());
        }
    },

    NORMAL {
        @Override
        public Product updateStrategy(Item item) {
            return new Product(item, new QualityDecreasesStrategy(), new SellInDecreasesStrategy());
        }
    };

    public abstract Product updateStrategy(Item item);

}
