package filesystem;

import filesystem.FSObject;

public interface Dir extends FSObject<?>
{
	public FSObject[] content();
}