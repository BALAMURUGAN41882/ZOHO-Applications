# ZOHO-Applications
ZOHO Application development (Hyper loop passenger booking system)

![]("Title")

```java
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
```

### Compiling Source Code
```console
foo@abc-$ javac Main.java Passenger.java Graph.java
```

### Executing files
```console
foo@abc-$ java Main
```
