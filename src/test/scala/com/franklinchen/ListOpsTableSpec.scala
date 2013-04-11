package com.franklinchen

import org.specs2._
import org.specs2.matcher._

class ListOpsTableSpec extends Specification with DataTables { def is =
  "Test list append with hand-crafted table of examples" ! e1^
  end

  def e1 = 
    "xs"       | "ys"       |
    List(3)    ! List(7, 2) |
    List(3, 4) ! List(7, 2) |> {
      (xs, ys) =>
      ListOps.append(xs, ys).length must_== xs.length + ys.length
    }
}
