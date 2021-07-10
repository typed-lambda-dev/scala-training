import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.util.{Failure, Success}

//non-blocking
val nameFuture = Future {
  Thread.sleep(2000); "Rajesh"
}
//future.isCompleted
//
//val str: String = Await.result(future, 10.seconds)
val greetFuture = Future{
  "hi"
}

//val fMap: Future[String] = nameFuture.flatMap{ x => greetFuture(x)}

/*for {
  name <- nameFuture
  greetings <- greetFuture
} yield {
  greetings
}*/
//val futures: List[Future[String]] = List(nameFuture, greetFuture)
//Future[List[String]]
//val ff: Future[List[String]] = Future.sequence(futures)


/*ff.onComplete {
  case Success(value) => println(value)
  case Failure(exception) => println("no hi for you")
}*/

val failedArgument = Future("hello")

val frec = failedArgument.recoverWith {
  case _ =>
    Future {
      "hi there"
    }
}

Await.result(frec, 2.seconds)
//playframework == Spring boot
// database




















