
sealed interface Animal permits Dog, Cat, Fish {

}

final class Dog implements Animal {
}

sealed class Cat implements Animal {
}

final class Tabby extends Cat {
	
}

non-sealed class Fish implements Animal {

}

class Salmon extends Fish {
	
}

class Parrot {
	
}

public class SealedInterfaceDemo {
	
	public static void main(String[] args) {
		
		speak(new Dog());
		speak(new Cat());
		speak(new Tabby());
		speak(new Salmon());
		speak(new Fish());
		speak(new Parrot()); // java.lang.IllegalArgumentException: Not permitted animal
	}
	
	public static void speak(Object animal) {
		// Case for object of child class must precede case for object of parent class
		switch (animal) {
			case Dog d -> System.out.println("Woof");
			case Tabby t -> System.out.println("Meow!");
			case Cat c -> System.out.println("Meow");
			case Salmon s -> System.out.println("I do not speak"); 
			case Fish f -> System.out.println("I cannot speak");
			default -> throw new IllegalArgumentException("Not permitted animal");
		}
	}
}