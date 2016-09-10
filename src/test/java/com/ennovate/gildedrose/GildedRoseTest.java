package com.ennovate.gildedrose;


import org.junit.Test;

import static com.ennovate.gildedrose.GildedRose.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GildedRoseTest {

    private static final String NORMAL_PRODUCT = "Normal product";

    Item[] items;

    GildedRose subject;
    

    @Test
    public void shouldThrowAssertionErrorForNullItems() throws Exception {

        assertThatThrownBy(() -> new GildedRose(null).updateQuality())
                .isInstanceOf(AssertionError.class);
    }

    @Test
    public void shouldNotUpdateForSulfuras() throws Exception {

        createSulfuras(1, 80);

        subject.updateQuality();

        assertThat(items[0].getSellIn()).isEqualTo(1);
        assertThat(items[0].getQuality()).isEqualTo(80);

    }

    @Test
    public void shouldReduceSellInAndQualityForNormalItem() throws Exception {

        createNormalItem(10, 10);

        subject.updateQuality();

        assertThat(items[0].getSellIn()).isEqualTo(9);
        assertThat(items[0].getQuality()).isEqualTo(9);

    }

    @Test
    public void shouldReducesQualityByTwoWhenSellInDaysPassedForNormalItem() throws Exception {

        createNormalItem(0, 10);

        subject.updateQuality();

        assertThat(items[0].getSellIn()).isEqualTo(-1);
        assertThat(items[0].getQuality()).isEqualTo(8);

    }

    @Test
    public void shouldNotDecreaseQualityWhenValueReachesZero() throws Exception {

        createNormalItem(1, 0);

        subject.updateQuality();

        assertThat(items[0].getSellIn()).isEqualTo(0);
        assertThat(items[0].getQuality()).isEqualTo(0);

    }

    @Test
    public void shouldIncreaseQualityOfAgedBrie() throws Exception {
        createAgedBrie(2, 8);

        subject.updateQuality();

        assertThat(items[0].getSellIn()).isEqualTo(1);
        assertThat(items[0].getQuality()).isEqualTo(9);

    }

    @Test
    public void shouldIncreaseQualityTwiceAfterSellInDayForAgedBrie() throws Exception {
        createAgedBrie(0, 8);

        subject.updateQuality();

        assertThat(items[0].getSellIn()).isEqualTo(-1);
        assertThat(items[0].getQuality()).isEqualTo(10);

    }


    @Test
    public void shouldNotIncreaseQualityOfAgedBrieIf50() throws Exception {

        createAgedBrie(1, 50);

        subject.updateQuality();

        assertThat(items[0].getQuality()).isEqualTo(50);

    }

    @Test
    public void shouldNotIncreaseQualityOfBackStageIf50() throws Exception {

        createBackStage(10, 49);

        subject.updateQuality();

        assertThat(items[0].getQuality()).isEqualTo(50);

    }

    @Test
    public void shouldIncreaseQualityForBackStage() throws Exception {
        createBackStage(18, 20);

        subject.updateQuality();

        assertThat(items[0].getSellIn()).isEqualTo(17);
        assertThat(items[0].getQuality()).isEqualTo(21);

    }

    @Test
    public void shouldIncreaseQualityByTwoWhenBackStageNeedsToBeSoldInTenDaysOrLess() throws Exception {

        createBackStage(10, 20);

        subject.updateQuality();


        assertThat(items[0].getSellIn()).isEqualTo(9);
        assertThat(items[0].getQuality()).isEqualTo(22);

    }

    @Test
    public void shouldIncreaseQualityByThreeWhenBackStageNeedsToBeSoldIn5DaysOrLess() throws Exception {

        createBackStage(6, 30);

        subject.updateQuality();

        assertThat(items[0].getSellIn()).isEqualTo(5);
        assertThat(items[0].getQuality()).isEqualTo(33);

    }

    @Test
    public void shouldUpdateQualityTo0ForBackStageWhenSellInDayIsPassed() throws Exception {

        createBackStage(0, 45);

        subject.updateQuality();

        assertThat(items[0].getSellIn()).isEqualTo(-1);
        assertThat(items[0].getQuality()).isEqualTo(0);

    }

    @Test
    public void shouldNeverMakeQualityNegativeForNormal() throws Exception {

        createNormalItem(-1, 1);

        subject.updateQuality();

        assertThat(items[0].getQuality()).isEqualTo(0);
        assertThat(items[0].getSellIn()).isEqualTo(-2);

    }

    @Test
    public void conjuredShouldDegradeTwiceMoreThanNormalItem() throws Exception {

        createConjured(10, 8);

        subject.updateQuality();

        assertThat(items[0].getQuality()).isEqualTo(6);
        assertThat(items[0].getSellIn()).isEqualTo(9);

    }

    @Test
    public void conjuredShouldDegradeFourTimesPastSellIn() throws Exception {

        createConjured(-1, 8);

        subject.updateQuality();

        assertThat(items[0].getQuality()).isEqualTo(4);
        assertThat(items[0].getSellIn()).isEqualTo(-2);

    }

    @Test
    public void shouldNeverMakeQualityNegativeForConjured() throws Exception {

        createConjured(-1, 4);

        subject.updateQuality();

        assertThat(items[0].getQuality()).isEqualTo(0);
        assertThat(items[0].getSellIn()).isEqualTo(-2);

    }


    private void createBackStage(int sellIn, int quality) {
        createProduct(BACKSTAGE_PASSES, sellIn, quality);
    }

    private void createConjured(int sellIn, int quality) {
        createProduct(CONJURED, sellIn, quality);
    }

    private void createSulfuras(int sellIn, int quality) {
        createProduct(SULFURAS, sellIn, quality);
    }

    private void createAgedBrie(int sellIn, int quality) {
        createProduct(AGED_BRIE, sellIn, quality);
    }

    private void createNormalItem(int sellIn, int quality) {
        createProduct(NORMAL_PRODUCT, sellIn, quality);
    }

    private void createProduct(String product, int sellIn, int quality) {
        items = new Item[1];
        items[0] = new Item(product, sellIn, quality);
        subject = new GildedRose(items);
    }


}
