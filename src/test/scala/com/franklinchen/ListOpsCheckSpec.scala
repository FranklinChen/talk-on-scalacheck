package com.franklinchen

import org.specs2._

class ListOpsCheckSpec extends Specification with ScalaCheck { def is = s2"""
  List operations
    length of appended lists is sum of lengths $e1
  """

  def e1 = prop {
    (xs: List[Int], ys: List[Int]) =>
    ListOps.append(xs, ys).length must_== xs.length + ys.length
  }
}
