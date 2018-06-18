package theoryoflists;

import theoryoflists.Vehicle;
import theoryoflists.List;

interface Memory
{
	Vehicle[] vehicles();
	List<?>[] lists();
	List<? extends Vehicle>[] heads();
}