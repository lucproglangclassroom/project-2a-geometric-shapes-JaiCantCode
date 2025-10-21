package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*


class TestSize extends AnyFunSuite:

  def testSize(description: String, shape: Shape, expectedSize: Int): Unit =
    test(description):
      val result = size(shape)
      assert(result == expectedSize)

  // Test cases using fixtures from TestFixtures
  testSize("simple ellipse", simpleEllipse, 1)
  testSize("simple rectangle", simpleRectangle, 1)
  testSize("simple location", simpleLocation, 1)
  testSize("basic group", basicGroup, 2)
  testSize("simple group", simpleGroup, 2)
  testSize("complex group", complexGroup, 5)

end TestSize