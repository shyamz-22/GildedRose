package com.ennovate.gildedrose;

import com.ennovate.gildedrose.products.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GildedRose {

    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured Mana Cake";

    Map<String, ProductType> map = new HashMap<String,ProductType>(){{
        put(BACKSTAGE_PASSES, ProductType.BACKSTAGE_PASSES);
        put(AGED_BRIE, ProductType.AGEDBRIE);
        put(SULFURAS, ProductType.SULFURAS);
        put(CONJURED, ProductType.CONJURED);
    }};

    private List<Item> items;

    public GildedRose(Item[] items) {
        assert items != null;
        this.items = Arrays.asList(items);
    }

    public void updateQuality() {
        items.stream().forEach(item -> type(item.getName())
                .updateStrategy(item)
                .update());
    }

    private ProductType type(String itemName){
        return map.get(itemName) != null ? map.get(itemName) : ProductType.NORMAL;
    }
}
