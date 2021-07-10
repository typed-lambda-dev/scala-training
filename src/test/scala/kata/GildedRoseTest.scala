/*
package kata

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class GildedRoseTest extends AnyFlatSpec with Matchers {
  it should "decrease the value of SellIn and Quality  for +5 Dexterity Vest" in {
    val app = new GildedRose(Array[Item](Standard("+5 Dexterity Vest", 10, 20)))
    val updatedItems = app.updateQuality()
    updatedItems(0).name should equal("+5 Dexterity Vest")
    updatedItems(0).sellIn should equal(9)
    updatedItems(0).quality should equal(19)
  }
  it should "decrease the SellIn value by 1 and increase quality by 1  for Aged Brie" in {
    val app = new GildedRose(Array[Item](AgedBrie("Aged Brie", 2, 0)))
    val updatedItems = app.updateQuality()
    updatedItems(0).name should equal("Aged Brie")
    updatedItems(0).sellIn should equal(1)
    updatedItems(0).quality should equal(1)
  }
  it should "decrease the value of SellIn and Quality  for Elixir of the Mongoose" in {
    val app = new GildedRose(Array[Item](Standard("Elixir of the Mongoose", 5, 7)))
    val updatedItems = app.updateQuality()
    updatedItems(0).name should equal("Elixir of the Mongoose")
    updatedItems(0).sellIn should equal(4)
    updatedItems(0).quality should equal(6)
  }
  it should " SellIn and Quality remains as is for Sulfuras, Hand of Ragnaros" in {
    val app = new GildedRose(Array[Item](Sulfuras("Hand of Ragnaros", -1, 80)))
    val updatedItems = app.updateQuality()
    updatedItems(0).name should equal("Sulfuras, Hand of Ragnaros")
    updatedItems(0).sellIn should equal(-1)
    updatedItems(0).quality should equal(80)
  }

  it should "decrease the value of SellIn but Quality remains as is for Backstage passes to a TAFKAL80ETC concert" in {
    val app = new GildedRose(Array[Item](BackStagePass("Backstage passes to a TAFKAL80ETC concert", 15, 20)))
    val items = app.updateQuality()
    items(0).name should equal("Backstage passes to a TAFKAL80ETC concert")
    items(0).sellIn should equal(14)
    items(0).quality should equal(21)
  }
}
*/
