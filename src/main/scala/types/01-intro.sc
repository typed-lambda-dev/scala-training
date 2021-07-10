//type parameters or generics
abstract class Animal {
  val name: String
}
trait WildCat extends Animal
case class Lion(name: String) extends WildCat
case class Tiger(name: String) extends WildCat

val simba = Lion("Simba")
val tiger = Tiger("Sherkhan")

case class AnimalPark[A](animal: A) {
  override def toString: String = s"${animal} lives here"
  def whoisthere: A = animal
}

val lionPark: AnimalPark[Lion] = AnimalPark(simba)
lionPark.whoisthere

val tigerPark: AnimalPark[Tiger] = AnimalPark(tiger)
tigerPark.whoisthere





