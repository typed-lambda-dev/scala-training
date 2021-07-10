package object Days {
  sealed trait Day // sealed abstract class Day
  case object Monday extends Day
  case object Tuesday extends Day
  case object Wednesday extends Day
  case object Thursday extends Day
  case object Friday extends Day
  case object Saturday extends Day
  case object Sunday extends Day
}

