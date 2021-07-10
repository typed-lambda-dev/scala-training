package introduction

object Maths {
  def factorial(i: Int): Int = {
    if (i <= 0) 0
    else if(i == 1) 1
    else {
      i * factorial(i - 1)
    }
  }
}
