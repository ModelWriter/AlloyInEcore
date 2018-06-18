package filesystem;

import filesystem.FSObject;

public interface Link extends FSObject<?>
{
	public FSObject link();
}