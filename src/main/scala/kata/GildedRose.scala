package kata

class GildedRose(val items: Array[Item]) {
  def updateQuality(): Array[Item] = {
    items.map { item => updateItem(item) }
  }

  // Strategy design pattern
  private def updateItem(item: Item): Item = item match {
    case agedBrie: AgedBrie => agedBrie.update
    case backStagePass: BackStagePass => backStagePass.update
    case sulfuras: Sulfuras => sulfuras.update
    case standard: Standard => standard.update
  }
}


// at the end of session
// remove duplicate code === DRY
// pattern matching instead of if /else
// using String object so that we can reuse values to avoid mistakes
// complete FP -> Immutable objects with pure functions
// lambda calculus λx.x -> x
// 1 + 1 = 2
