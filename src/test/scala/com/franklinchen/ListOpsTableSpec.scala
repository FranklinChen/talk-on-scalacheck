package com.franklinchen

import org.specs2._
import org.specs2.matcher._

class ListOpsTableSpec extends Specification with DataTables { def is = s2"""
  Test list append with hand-crafted table of examples

    Table $e1
  """

  def e1 = 
    "xs"       | "ys"       |
    List(3)    ! List(7, 2) |
    List(3, 4) ! List(7, 2) |> {
      (xs, ys) =>
      ListOps.append(xs, ys).length must_== xs.length + ys.length
    }
}
