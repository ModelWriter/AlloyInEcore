package generics;

import generics.List;
import generics.Shape;
import generics.Canvas;
import ecore.EBoolean;
import generics.ArrayList;
import generics.Car;

interface Canvas<V> 
{
	List<?> ref();
	boolean draw(List<? extends Shape> shapes);
	<V> EBoolean create(Canvas<?> name);
	void create(ArrayList<? extends Car> arg);
}