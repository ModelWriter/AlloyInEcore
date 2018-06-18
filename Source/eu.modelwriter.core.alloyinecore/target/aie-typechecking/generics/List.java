package generics;

import generics.Iterator;

public interface List<E> 
{
	E[] content();
	Iterator<E> iterator();
	void add(E element);
}