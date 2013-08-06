package com.franklinchen

import org.specs2._
import org.scalacheck._
import Gen._
import org.scalacheck.Prop._

class IntOpsCheckSpec extends Specification with ScalaCheck { def is = s2"""
  Integer operations

    multiplying and dividing same integer gives back original?         $e1
    multiplying and dividing same nonzero integer gives back original? $e2
    multiplying and dividing same nonzero BigInt gives back original   $e3
    small multiplying and dividing same nonzero integer gives back original $e4
  """

  def e1 = prop {
    (x: Int, y: Int) =>
    (x * y) / y must_== x
  }

  def e2 = prop {
    x: Int =>
    forAll {
      y: Int =>
      (y != 0) ==> { (x * y) / y must_== x }
    }
  }

  def e3 = prop {
    x: BigInt =>
    forAll {
      y: BigInt =>
      (y != 0) ==> { (x * y) / y must_== x }
    }
  }

  def e4 = forAll(Gen.choose(0, 10000), Gen.choose(1, 10000)) {
    (x: Int, y: Int) => { (x * y) / y must_== x }
  }
}
