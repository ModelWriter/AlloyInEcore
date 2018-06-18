package generics;

import generics.Geometry;
import generics.Car;
import generics.ArrayList;

interface Owner<K, V extends Geometry & Car> 
{
	public ArrayList<Car> cars();
	K owner();
}