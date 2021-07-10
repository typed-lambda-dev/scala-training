import java.net.InterfaceAddress
//Implicitly ::: Explicitly

def calcTax(price: Double, taxRate: Double): Double = {
  price * (taxRate / 100)
}



calcTax(25.50, 2.5)
calcTax(50, 2.5)


def calcTax2(price: Double)(implicit taxRate: Double): Double = {
  price * (taxRate / 100)
}



class BillTaxRate1 {
  implicit val taxRate = 1.5
  def useTaxCal1 : Double = {
    implicit val taxRate = 2.5
    calcTax2(24)
  }
}

// SOLID principles
// DRY -> Dont Repeat Yourself (avoid duplication)
// KISS -> Keep it simple & stupid
// YAGNI -> You Aint Gonna Need It

