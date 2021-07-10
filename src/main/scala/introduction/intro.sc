 import scala.util.matching.Regex
// Pattern matching list and options
// case classes pattern matching

// handling null in Scala using options

//algebraic data types using case classes
//Sum and Products
//Product -> has a relationship
//sum -> is a relationship

// object --> factory class with static methods & companion object
//        modules -> collect/keep related classes together
//traits --> used modules, like interface, abstract class with methods defined
// Typeclass pattern
//Uniform access principle
//class and companion objects

//traits in detail -> Type parametrization -> Typeclass pattern {Generics}
// --> Polymorphism --> Implicits(thursday)
class Money(val amount: Int) {

  override def equals(otherMoney: Any): Boolean = {
    otherMoney match {
      case m: Money => this.amount == m.amount
      case _ => false
    }
  }
}
class Person
//controller
val m100 = new Money(100)
val m200 = new Money(100)
val p = new Person

m100 == p


val phoneNumber: Regex = "^\\+\\d{12}".r

phoneNumber.findFirstMatchIn("+9112345678") match {
  case Some(_) => println("valid phone number")
  case None => println("invalid phone number")
}


val list = List(1,2,3,4)

 list.par.map(x => x + 1)










