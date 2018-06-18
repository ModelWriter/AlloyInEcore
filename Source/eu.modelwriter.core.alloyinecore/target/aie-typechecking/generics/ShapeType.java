package generics;


enum ShapeType
{
	Arc(0),
	Oval(1),
	Rectangle(2);

	private int value;
	ShapeType(int value) { this.value = value; }
	ShapeType(){}
}