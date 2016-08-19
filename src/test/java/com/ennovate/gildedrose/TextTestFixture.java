package com.ennovate.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TextTestFixture {


    public String oldOutput() {
        StringBuilder sb = new StringBuilder();
        sb.append("OMGHAI!");

        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 0, 28), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
              };

        GildedRoseOld app = new GildedRoseOld(items);

        int days = 2;

        for (int i = 0; i < days; i++) {
            sb.append("-------- day ").append(i).append(" --------");
            sb.append("name, sellIn, quality");
            for (Item item : items) {
                sb.append(item);
            }
            sb.append("");
            app.updateQuality();
        }

        return sb.toString();
    }

    public String newOutPut() {
        StringBuilder sb = new StringBuilder();
        sb.append("OMGHAI!");

        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 0, 28), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
               };

        GildedRose app = new GildedRose(items);

        int days = 2;

        for (int i = 0; i < days; i++) {
            sb.append("-------- day ").append(i).append(" --------");
            sb.append("name, sellIn, quality");
            for (Item item : items) {
                sb.append(item);
            }
            sb.append("");
            app.updateQuality();
        }

        return sb.toString();
    }

    @Test
    public void verifyRefactoredCode() throws Exception {

        assertThat(oldOutput()).isEqualTo(newOutPut());

    }
}
