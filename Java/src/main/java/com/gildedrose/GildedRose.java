package com.gildedrose;

/*
- Once the sell by date has passed, Quality degrades twice as fast
        - The Quality of an item is never negative
        - "Aged Brie" actually increases in Quality the older it gets
        - The Quality of an item is never more than 50
        - "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
        - "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
        Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        Quality drops to 0 after the concert
*/

class GildedRose {
  public static final String AGED_BRIE = "Aged Brie";
  public static final String CONCERT_PASS = "Backstage passes to a TAFKAL80ETC concert";
  public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (int i = 0; i < items.length; i++) {
      if (items[i].name.equals(AGED_BRIE) || items[i].name.equals(CONCERT_PASS)) {
        if (items[i].quality < 50) {
          items[i].quality = items[i].quality + 1;

          if (items[i].name.equals(CONCERT_PASS)) {
            if (items[i].sellIn < 11) {
              if (items[i].quality < 50) {
                items[i].quality = items[i].quality + 1;
              }
            }

            if (items[i].sellIn < 6) {
              if (items[i].quality < 50) {
                items[i].quality = items[i].quality + 1;
              }
            }
          }
        }
      } else {
        if (items[i].quality > 0) {
          if (items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
          } else {
            items[i].quality = items[i].quality - 1;
          }
        }
      }

      if (items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
      } else {
        items[i].sellIn = items[i].sellIn - 1;
      }

      if (items[i].sellIn < 0) {
        if (items[i].name.equals(AGED_BRIE)) {
          if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;
          }
        } else {
          if (items[i].name.equals(CONCERT_PASS)) {
            items[i].quality = 0;
          } else {
            if (items[i].quality > 0) {
              if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                items[i].quality = items[i].quality - 1;
              }
            }
          }
        }
      }
    }
  }
}