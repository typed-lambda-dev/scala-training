package kata
// Open(for extension) / Closed(for modification) principle
sealed abstract class Item(val name: String, val sellIn: Int, val quality: Int)
//trait UpdateableItem[+T] { def update: T}
case class AgedBrie(override val name: String, override val sellIn: Int, override val quality: Int)
  extends Item(name, sellIn, quality) /*with UpdateableItem*/{
  def update: AgedBrie = {
    this.copy(sellIn = sellIn - 1, quality = if (quality < 50) quality + 1 else quality)
  }
}

case class BackStagePass(override val name: String, override val sellIn: Int, override val quality: Int)
  extends Item(name, sellIn, quality){
  def update: BackStagePass = {
    if (sellIn < 11) {
      this.copy(quality = quality + 1, sellIn = sellIn - 1)
    }
    if (sellIn < 6) {
      this.copy(quality = quality + 1, sellIn = sellIn - 1)
    }
    this.copy(quality = quality + 1, sellIn = sellIn - 1)

  }
}

case class Sulfuras(override val name: String, override val sellIn: Int, override val quality: Int)
  extends Item(name, sellIn, quality) {
  def update: Sulfuras = this
}

/*case class Conjured(override val name: String, override val sellIn: Int, override val quality: Int)
  extends Item(name, sellIn, quality) {
  def update: Conjured = this
}*/

case class Standard(override val name: String, override val sellIn: Int, override val quality: Int)
  extends Item(name, sellIn, quality) {
  def update: Standard = {
    this.copy(
      quality = if (quality > 0) quality - 1 else quality,
      sellIn = sellIn - 1
    )
  }
}
