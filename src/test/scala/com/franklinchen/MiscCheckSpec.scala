package com.franklinchen

import org.specs2._
import org.scalacheck._
import Gen._
import Arbitrary.arbitrary
import org.scalacheck.Prop._

class MiscCheckSpec extends Specification with ScalaCheck { def is =
  "3 integers, unconstrained, transitive under <" ! e1^
  "3 integers, custom generated, transitive under <" ! e2^
  end

  def e1 = prop {
    (x: Int, y: Int, z: Int) =>
    (x < y && y < z) ==> x < z
  }

  val orderedTriples = for {
    x <- arbitrary[Int]
    y <- Gen.choose(x + 1, Int.MaxValue)
    z <- Gen.choose(y + 1, Int.MaxValue)
  } yield (x, y, z)

  def e2 = forAll(orderedTriples) {
    case (x, y, z) =>
    (x < y && y < z) ==> x < z
  }
}
