package generics;

import generics.Geometry;
import generics.ShapeType;

interface Shape extends Geometry
{
	ShapeType Type();
}