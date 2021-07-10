import scala.util.Try

//
//FP principles, functions should be total and deterministic -> Referential Transparent
//util
def average(numbers: List[Int]) : Either [Throwable, Int] = {
/*
  if (numbers.isEmpty) Left("empty list")
  else {
    Right(numbers.sum / numbers.length)
  }
*/
  Try{
    numbers.sum / numbers.length
  }.toEither
}


//list of salaries from db Repo
val salaries = Nil //List(1,2,3,4,5)
average(salaries)
/*average(salaries) match {
  case Left(x) => println(x)
  case Right(x) => println(x)
}*/

println("got herw")

//StatisticsService

//TypeParameters
//Cake pattern

// Animal
// habitats --> animals
//[lion, tiger, [polar bear], bear, koalas, ]

//arctic --> Polar Bear
//sea --> fishes
//

//Type level programming
//TypeDriven programming
