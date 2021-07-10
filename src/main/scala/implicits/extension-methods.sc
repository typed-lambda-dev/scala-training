//3.times{"hi"} monkey patching/pimp my library
//extension methods
//3.times{"hi"} "hi hi hi"

/*
class IntTimesString(n: Int) {
  def times(string: String) = {
    var finalString = ""
    (1 to n).foreach{_ => finalString+= string}
    finalString
  }
}

new IntTimesString(3).times(" Rajesh")

implicit def intTimesString(n: Int) = new IntTimesString(3)

3.times{" hi "}
*/

case class Person(name: String, age: Int)
val rajesh = Person("Rajesh", 41)
class Greeter(person: Person) {
  private val timeOfDay = "morning"
  def greet(anotherName: Person): String = {
    if (timeOfDay == "morning") {
      s"${person.name} says Good morning to ${anotherName.name}"
    } else if (timeOfDay == "afternoon") {
      s"${person.name} says Good afternoon to ${anotherName.name}"
    } else {
      s"${person.name} says Good afternoon to ${anotherName.name}"
    }
  }
}

class AgeGroup(person: Person) {
  def ageGroup: String = {
    if (person.age < 18) "minor"
    else if (person.age >= 18 && person.age <= 59) "major"
    else "senior citizen"
  }
}


implicit def greetPerson(person: Person) = new Greeter(person)
implicit def personAgeGroup(person: Person): AgeGroup = new AgeGroup(person)
rajesh.greet(Person("Arun", 43))
rajesh.ageGroup

