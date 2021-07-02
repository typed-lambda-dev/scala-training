//type parameters or generics
abstract class Animal {
  val name: String
}
// ? extend A == +A
trait WildCat extends Animal
case class Lion(name: String) extends WildCat
case class Tiger(name: String) extends WildCat

val simba = Lion("Simba")
val tiger = Tiger("Sherkhan")
// <: upper bound
//A <: Animal ==> A should be subtype of Animal
//+ -> Co-variant
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

//lets put them in cage

//contra-variance
trait Cage[-T] {
  def caged(animal: T): String
}
object LionCage extends Cage[Lion] {
  override def caged(animal: Lion) = s"zzZZZ ${animal.name} is zzleeping"
}

def putLionInCage(cage: Cage[Lion]): String = {
  cage.caged(Lion("Simba"))
}

putLionInCage(LionCage)

object TigerCage extends Cage[Tiger] {
  override def caged(animal: Tiger) = s"zzZZZ ${animal.name} is zzleeping"
}

def putTigerInCage(cage: Cage[Tiger]): String = {
  cage.caged(Tiger("Sherkhan"))
}

putTigerInCage(TigerCage)

object PrideRockCage extends Cage[WildCat] {
  override def caged(animal: WildCat) = s"zzZZZ ${animal.name} is zzleeping"
}

putLionInCage(PrideRockCage)
putTigerInCage(PrideRockCage)


case class Forest[+WC <: WildCat](wc1: WC, wc2: WC) {
  override def toString: String = s"${wc1.name} is friends with ${wc2.name} here."
}

//compiles but it is not worrect since allow is not re-using the type parameter
//allow(anotherWildCat: WildCat) should be allow(anotherWildCat: WC)
case class Grasslands[+WC <: WildCat](wildCat: WC) {
  override def toString: String = s"${wildCat.name} lives here"
  def allow(anotherWildCat: WildCat) = Forest[WildCat](wildCat, anotherWildCat)
}

//still does not compile because type of anotherWildCat is Covariant. it should contravariant
// cannot use +/- in method definitions
//case class Grasslands[+WC <: WildCat](wildCat: WC) {
//  override def toString: String = s"${wildCat.name} lives here"
//  def allow(anotherWildCat: WC) = Forest[WC](wildCat, anotherWildCat)
//}

//so we have to use lower bound
//>: lower bound
//case class Grasslands[+WC <: WildCat](wildCat: WC) {
//  override def toString: String = s"${wildCat.name} lives here"
//  def allow[WC2 >: WC <: WildCat](otherWildCat: WC2) = Forest[WC2](wildCat, otherWildCat)
//}
Grasslands(simba).allow(tiger)









/*
abstract class Cervidae extends Animal
case class Deer(name: String) extends Cervidae
case class Sambar(name: String) extends Cervidae
*/



