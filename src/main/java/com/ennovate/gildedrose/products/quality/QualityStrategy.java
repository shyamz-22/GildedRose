package com.ennovate.gildedrose.products.quality;

import com.ennovate.gildedrose.Item;

public interface QualityStrategy {
    int MAX_QUALITY_THRESHOLD = 50;
    int LEGENDARY_QUALITY_CONSTANT = 80;

    int applyAndReturn(Item item);
}
