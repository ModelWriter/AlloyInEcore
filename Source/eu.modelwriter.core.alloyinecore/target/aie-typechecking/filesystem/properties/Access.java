package filesystem.properties;


enum Access
{
	Readonly(0),
	None(0),
	ReadAndWriter(0);

	private int value;
	Access(int value) { this.value = value; }
	Access(){}
}