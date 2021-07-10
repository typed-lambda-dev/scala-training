abstract class Animal {
  val name: String
}
// ? extend A == +A
trait WildCat extends Animal
case class Lion(name: String) extends WildCat
case class Tiger(name: String) extends WildCat

val simba = Lion("Simba")
val tiger = Tiger("Sherkhan")

// + is used for co-variance
// if WildCat is subtype of Animal then AnimalPark[Wildcat] is subtype of AnimalPark[Animal]
case class AnimalPark[+A <: Animal](animal: A) {
  override def toString: String = s"${animal.name} lives here"
  def whoisthere: A = animal
}

val lionPark: AnimalPark[Lion] = AnimalPark(simba)
lionPark.whoisthere

val tigerPark: AnimalPark[Tiger] = AnimalPark(tiger)
tigerPark.whoisthere

def showWildCats(catsPark: AnimalPark[WildCat]) = {
  s"${catsPark.animal.name} roar!!!"
}

showWildCats(lionPark)
