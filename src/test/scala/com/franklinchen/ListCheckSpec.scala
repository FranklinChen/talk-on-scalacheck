package com.franklinchen

import org.specs2._
import org.scalacheck._
import Gen._
import Arbitrary.arbitrary
import org.scalacheck.Prop._

class ListCheckSpec extends Specification with ScalaCheck { def is =
  "unconstrained insertion into sorted list is sorted" ! e1^
  "constrained insertion into sorted list is sorted" ! e2^
  "constrained insertion into sorted list is sorted, with classifiers" ! e3^
  end

  def e1 = prop {
    (x: Int, xs: List[Int]) =>
    isSorted(xs) ==> isSorted(insert(x, xs))
  }

  /**
    @return whether a list is sorted
    */
  def isSorted(xs: List[Int]): Boolean = xs match {
    case Nil   => true
    case _::ys => xs.view.zip(ys).forall { case (x, y) => x <= y }
  }

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case Nil   => List(x)
    case y::ys => if (x <= y) x::xs else y::insert(x, ys)
  }

  /**
    Illustrate custom generator.
   */
  def e2 = forAll(someSortedLists) {
    xs: List[Int] => prop {
      x: Int =>
      isSorted(xs) ==> isSorted(insert(x, xs))
    }
  }

  /**
    Sample generator of sorted integer lists no larger than 10000.
   */
  val someSortedLists = for {
    size <- Gen.choose(0, 1000)
    x <- arbitrary[Int]
    xs <- sortedListsFromAtLeast(size, x)
  } yield xs

  /**
    @return generator of a sorted list of length size
            with first element >= x
    
    Warning: this naive recursion may overflow stack;
    could write differently to avoid this problem.
   */
  def sortedListsFromAtLeast(size: Int, x: Int):
      Gen[List[Int]] = {
    if (size == 0) {
      Nil
    }
    else {
      for {
        y <- Gen.choose(x, x+100)
        ys <- sortedListsFromAtLeast(size-1, y)
      } yield y::ys
    }
  }

  /**
    Illustrate classifiers.
   */
  def e3 = forAll(someSortedLists) {
    xs: List[Int] => classify(xs.length < 300, "length 0-299") {
      classify(xs.length >= 300 && xs.length < 800, "length 300-799") {
        classify(xs.length >= 800, "length 800+") {
          prop {
            x: Int =>
            isSorted(xs) ==> isSorted(insert(x, xs))
          }
        }
      }
    }
  }
}
