package com.franklinchen

import org.specs2._

class ListOpsSpec extends Specification { def is =
  "Test list append with hand-crafted individual examples" ^
                                                           p^
  "append lists of lengths 1 and 2"                        ! e1^ 
  "append lists of lengths 2 and 2"                        ! e2^ 
                                                           end

  def e1 =
    ListOps.append(List(3), List(7, 2)).length must_==
      List(3).length + List(7, 2).length

  def e2 =
    ListOps.append(List(3, 4), List(7, 2)).length must_==
      List(3, 4).length + List(7, 2).length
}
