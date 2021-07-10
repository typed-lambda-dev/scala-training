abstract class Animal extends Product with java.io.Serializable {
  val name: String
}
trait WildCat extends Animal
case class Lion(name: String) extends WildCat
case class Tiger(name: String) extends WildCat

val simba = Lion("Simba")
val tiger = Tiger("Sherkhan")

case class AnimalPark[+A <: Animal](animal: A) {
  override def toString: String = s"${animal.name} lives here"
  def whoisthere: A = animal
}

case class Forest[+WC <: Animal](wc1: WC, wc2: WC) {
  override def toString: String = s"${wc1.name} and ${wc2.name} are friends."
}

case class Grasslands[+WC1 <: WildCat](wildCat: WC1) {
  override def toString: String = s"${wildCat.name} lives here"
  def allow[WC2 >: WC1 <: WildCat](anotherWildCat: WC2): Forest[WC2] = Forest[WC2](wildCat, anotherWildCat)
}

Grasslands(simba).allow(tiger)
// Exercise 1: declare another type of animal Deer(SpotterDeer, SambarDeer)
// Grassland(lion).allow(SpottedDeer)

//Fruit <- Apple | Bowl[Fruit] <- Bowl[Apple]
//AppleBowl contaning apples
//OrangeBowl containing oranges
//FruitBowl[Apple].add(orange)-> MixedFruitBowl contain apples + oranges


