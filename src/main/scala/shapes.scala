package edu.luc.cs.laufer.cs371.shapes

/** data Shape = Rectangle(w, h) | Location(x, y, Shape) */
enum Shape derives CanEqual:
  // TODO add missing cases (see test fixtures)
  case Rectangle(width: Int, height: Int)
  case Location(x: Int, y: Int, shape: Shape)
  case Group(shapes: Shape*)
  case Ellipse(width: Int, height: Int)
  
