package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match

    case Rectangle(length,width) =>
      Location(0, 0, Rectangle(length, width))

    case Ellipse(width, height) =>
      Location(-width, -height, Rectangle(width*2, height*2))

    case Location(x, y, shape) =>
      val Location(innerX, innerY, Rectangle(innerWidth, innerHeight)) = boundingBox(shape)
      Location(x + innerX, y + innerY, Rectangle(innerWidth, innerHeight))

    case Group(shapes*) =>
      if shapes.isEmpty then
        Location(0, 0, Rectangle(0, 0))
      else
        val boundingBoxes = shapes.map(boundingBox.apply)
        val minX = boundingBoxes.map(_.x).min
        val minY = boundingBoxes.map(_.y).min
        val maxX = boundingBoxes.map(bb => bb.x + bb.shape.asInstanceOf[Rectangle].width).max
        val maxY = boundingBoxes.map(bb => bb.y + bb.shape.asInstanceOf[Rectangle].height).max
        Location(minX, minY, Rectangle(maxX - minX, maxY - minY))

    case _ => Location(0, 0, Rectangle(0, 0))


end boundingBox
