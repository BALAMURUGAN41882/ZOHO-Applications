// Passenger class to hold passengers data

public class Passenger{
	int age;
	String name;
	char destination;
	public Passenger(int age, String name, char destination)//CONSTRUCTOR TO SAVE THE OBJECTS
	{
		super();
		this.age = age;
		this.name = name;
		this.destination = destination;
	}
	public String toString() {
		return name+" "+age;
	}
}