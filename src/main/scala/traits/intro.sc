// trait -> combination of abstract class and interface wrto java
// java interface Single Abstract Methods
// trait -> declare(abstract) and define methods
// abstract class
// Cycles

//trait vs abstract
//trait BiCycle(color: String) until 2.x but in Scala 3.0 (Category theory)
// Function[Int, Int]

/*
abstract class BiCycle(color: String) {

  def describe = s"a $color BiCycle"

}
*/
//cake pattern -> compile time dependency injection
// in java extends and implements -> extends Atlas is a Cycle implements acts like bike
// domain -> BiCycle
trait BiCycle {
  def color: String
  def gear: String
  def handleBar: String
  def tireSize: String
  def describe = s"$color color with $gear gear and $handleBar bar"
}
trait Gear

// MTB(flat bars, 2.2), RoadBikes(dropbars, tires 1.9), hybrid, GravelBike, CycloCross, CrossCountry
// Gears, handlebars
trait MountainBike[<] extends BiCycle{
  def color: String = "grey"
  def gear: String = "3 X 7"
  def handleBar: String = "Flat"
  def tireSize: String = "2.2"

  override def describe = s"a mountain bike with ${super.describe}"
}
trait RoadBike extends BiCycle{
  def color: String = "grey"
  def gear: String = "2 X 9"
  def handleBar: String = "drop"
  def tireSize: String = "1.9"

  override def describe = s"a road bike with ${super.describe}"
}

// trait linerization
/*trait HybridBike extends MountainBike with BiCycle with RoadBike {
  override def color: String = "black"
  override def gear: String = "2 X 9"
  override def handleBar: String = "rised"
  override def tireSize: String = "1.9"
}*/

//val trekHybrid = new HybridBike {
//  override def color: String = "hybrid black"
//}

//class TrekHybridBike extends MountainBike with BiCycle with RoadBike




//trekHybrid.describe

//a road bike with a mountain bike with black color with 2 X 9 gear and rised bar



