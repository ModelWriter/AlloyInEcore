package RequirementsMetamodel;


enum Status
{
	proposed(0),
	analyzed(1),
	accepted(2),
	rejected(3),
	replaced(4);

	private int value;
	Status(int value) { this.value = value; }
	Status(){}
}