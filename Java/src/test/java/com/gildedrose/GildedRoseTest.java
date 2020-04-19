package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.GildedRose.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

  @Test
  void updateQuality_AgedBrieBeforeExpiry_QualityIncreaseNormal() {
    String name = AGED_BRIE;
    int sellIn = 1;
    int quality = 0;
    Item[] items = new Item[]{new Item(name, sellIn, quality)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(AGED_BRIE, app.items[0].name, "Name");
    assertEquals(sellIn - 1, app.items[0].sellIn, "Sell in");
    assertEquals(1, app.items[0].quality, "Quality");
  }

  @Test
  void updateQuality_AgedBrieAfterExpiry_QualityIncreaseDouble() {
    String name = AGED_BRIE;
    int sellIn = 0;
    int quality = 0;
    Item[] items = new Item[]{new Item(name, sellIn, quality)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(AGED_BRIE, app.items[0].name, "Name");
    assertEquals(sellIn - 1, app.items[0].sellIn, "Sell in");
    assertEquals(2, app.items[0].quality, "Quality");
  }

  @Test
  void updateQuality_AgedBrieBeforeExpiry_QualityNotAboveFifty() {
    String name = AGED_BRIE;
    int sellIn = 1;
    int quality = 49;
    Item[] items = new Item[]{new Item(name, sellIn, quality)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(AGED_BRIE, app.items[0].name, "Name");
    assertEquals(sellIn - 1, app.items[0].sellIn, "Sell in");
    assertEquals(50, app.items[0].quality, "Quality");
  }

  @Test
  void updateQuality_AgedBrieAfterExpiry_QualityNotAboveFifty() {
    String name = AGED_BRIE;
    int sellIn = 0;
    int quality = 49;
    Item[] items = new Item[]{new Item(name, sellIn, quality)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(AGED_BRIE, app.items[0].name, "Name");
    assertEquals(sellIn - 1, app.items[0].sellIn, "Sell in");
    assertEquals(50, app.items[0].quality, "Quality");
  }

  @Test
  void updateQuality_SulfurasBeforeExpiry_QualityNoChange() {
    String name = SULFURAS_HAND_OF_RAGNAROS;
    int sellIn = 1;
    int quality = 80;
    Item[] items = new Item[]{new Item(name, sellIn, quality)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(name, app.items[0].name, "Name");
    assertEquals(1, app.items[0].sellIn, "Sell in");
    assertEquals(80, app.items[0].quality, "Quality");
  }

  @Test
  void updateQuality_SulfurasAfterExpiry__QualityNoChange() {
    String name = SULFURAS_HAND_OF_RAGNAROS;
    int sellIn = 0;
    int quality = 80;
    Item[] items = new Item[]{new Item(name, sellIn, quality)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(name, app.items[0].name, "Name");
    assertEquals(0, app.items[0].sellIn, "Sell in");
    assertEquals(80, app.items[0].quality, "Quality");
  }

  @Test
  void updateQuality_ConcertMoreThanTenSellIn_QualityIncreaseNormal() {
    String name = CONCERT_PASS;
    int sellIn = 20;
    int quality = 49;
    Item[] items = new Item[]{new Item(name, sellIn, quality)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(name, app.items[0].name, "Name");
    assertEquals(sellIn - 1, app.items[0].sellIn, "Sell in");
    assertEquals(50, app.items[0].quality, "Quality");
  }

  @Test
  void updateQuality_ConcertFiveToTenSellIn_QualityIncreaseDouble() {
    String name = CONCERT_PASS;
    int sellIn = 7;
    int quality = 40;
    Item[] items = new Item[]{new Item(name, sellIn, quality)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(name, app.items[0].name, "Name");
    assertEquals(sellIn - 1, app.items[0].sellIn, "Sell in");
    assertEquals(42, app.items[0].quality, "Quality");
  }

  @Test
  void updateQuality_ConcertFiveSellIn_QualityIncreaseTriple() {
    String name = CONCERT_PASS;
    int sellIn = 5;
    int quality = 40;
    Item[] items = new Item[]{new Item(name, sellIn, quality)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(name, app.items[0].name, "Name");
    assertEquals(sellIn - 1, app.items[0].sellIn, "Sell in");
    assertEquals(43, app.items[0].quality, "Quality");
  }

  @Test
  void updateQuality_ConcerSellInZero_QualityZero() {
    String name = CONCERT_PASS;
    int sellIn = 0;
    int quality = 40;
    Item[] items = new Item[]{new Item(name, sellIn, quality)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(name, app.items[0].name, "Name");
    assertEquals(sellIn - 1, app.items[0].sellIn, "Sell in");
    assertEquals(0, app.items[0].quality, "Quality");
  }

}
