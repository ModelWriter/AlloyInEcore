package theoryoflists;

import theoryoflists.Object;
import theoryoflists.List;

public interface List<E>  extends Object
{
	E car();
	List<E> cdr();
	List<E>[] eq();
}