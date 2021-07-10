// type variance. how to declare type parameter
// invariant, upper bounds(type constraints), contravariance,
// lower bound
// type members

abstract class Animal {
  val name: String
}
trait WildCat extends Animal
case class Lion(name: String) extends WildCat
case class Tiger(name: String) extends WildCat

val simba = Lion("Simba")
val tiger = Tiger("Sherkhan")

/*
case class AnimalPark[+A <: Animal](animal: A) {
  override def toString: String = s"${animal.name} lives here"
  def whoisthere: A = animal
}

val lionPark: AnimalPark[Lion] = AnimalPark(simba)
lionPark.whoisthere
*/

abstract class AnimalParkTM {
  type AnimalType <: Animal
  val animal: AnimalType
  override def toString: String = s"${animal.name} lives here"
  def whoisthere: AnimalType = animal
}

class AnimalPark(val animal: WildCat) extends AnimalParkTM {
  type AnimalType = WildCat
}

val lionPark = new AnimalPark(simba)
//

val whoisthere1 : lionPark.AnimalType = lionPark.whoisthere
val whoisthere2 : AnimalPark#AnimalType = lionPark.whoisthere


//AnimalPark#AnimalType -> path dependent types
// Existential Types, Recursive Types, Structural Types(duck type)



