// functions with call by name parameters

//(x:Int, y: Int) => x + y

def multiply(x: Int, y: Int): Int = {
  println("multiplying...")
  x * y
}

def add(x: Int, y: => Int): Int = {
  x + y
}

add(2, multiply(2, 2))

def doWhile(condition: => Boolean)(body: => Unit): Unit = {
  if(condition){
    body
    doWhile(condition)(body)
  }
}

var i = 0;

doWhile(i < 10){
  println(i)
  i += 1
}


def recursiveList(list: List[Int]): List[Int] = list match {
  case Nil => Nil
  case head :: tail => recursiveList(tail) ::: List(head)
}

println(recursiveList(List(1,2,3)))
case class Email(userName: String, domain: String)
object Email { // companion object
  def apply(userName: String, domain: String): String = s"$userName@d$domain"

  def unapply(emailString: String) = {
    val parts = emailString.split("@")
    if(parts.length ==2) Some((parts(0), parts(1))) else None
  }
}
val rajeshEmailS = "rajesh@typedlambda.dev"

val rajeshEmail = Email("rajesh", "typedlambda.dev")

rajeshEmailS match {
  case Email(userName, domain) => println("matched");println(s"$userName@d$domain")
}
