abstract class Animal {
  val name: String
}
trait WildCat extends Animal
case class Lion(name: String) extends WildCat
case class Tiger(name: String) extends WildCat

val simba = Lion("Simba")
val tiger = Tiger("Sherkhan")


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
