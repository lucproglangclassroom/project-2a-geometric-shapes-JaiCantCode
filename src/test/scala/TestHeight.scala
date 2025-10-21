package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*

class TestHeight extends AnyFunSuite:

  def testHeight(description: String, shape: Shape, expectedHeight: Int): Unit =
    test(description):
      val result = height(shape)
      assert(result == expectedHeight)
  
  testHeight("simple ellipse", simpleEllipse, 1)
  testHeight("simple rectangle", simpleRectangle, 1)
  testHeight("simple location", simpleLocation, 2)
  testHeight("basic group", basicGroup, 2)
  testHeight("simple group", simpleGroup, 3)
  testHeight("complex group", complexGroup, 6)

end TestHeight