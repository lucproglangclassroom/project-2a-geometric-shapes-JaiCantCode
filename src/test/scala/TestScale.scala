package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*
import Shape.*

class TestScale extends AnyFunSuite:
  def testScale(description: String, shape: Shape, factor: Double, expectedShape: Shape): Unit =
    test(description):
      val result = scale(shape, factor)
      assert(result == expectedShape)

  testScale("simple ellipse by 2", simpleEllipse, 2.0, Ellipse(100, 60))
  testScale("simple rectangle by 2", simpleRectangle, 2.0, Rectangle(160, 240))
  testScale("simple location by 2", simpleLocation, 2.0, Location(140, 60, Rectangle(160, 240)))
  testScale("basic group by 2", basicGroup, 2.0, Group(Ellipse(100, 60), Rectangle(40, 80)))
  testScale("simple group by 2", simpleGroup, 2.0,
    Group(
      Location(400, 200, Ellipse(100, 60)),
      Location(800, 600, Rectangle(200, 100))
    ))
  testScale("complex group by 2", complexGroup, 2.0,
    Location(100, 200,
      Group(
        Ellipse(40, 80),
        Location(300, 100,
          Group(
            Rectangle(100, 60),
            Rectangle(600, 120),
            Location(200, 400,
              Ellipse(100, 60)
            )
          )
        ),
        Rectangle(200, 400)
      )
    ))

end TestScale