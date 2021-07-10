package introduction

import scala.annotation.tailrec

class ListUtil {
  def findFirst[A](numbers: List[A], toFind: A): Int = {

    @tailrec
    def loop(index: Int): Int = {
      if ( index >= numbers.length) -1
      else if(numbers(index) == toFind) index
      else loop(index + 1)
    }

    loop(0)
  }
}
