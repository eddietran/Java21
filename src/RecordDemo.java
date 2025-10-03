import java.util.Objects;

record Person(int id, String firstName) {

	public Person(int id, String firstName) {
		this.id = id;
		this.firstName = firstName;
	}
	
	// A non-canonical constructor must start with an explicit invocation to a constructor (using this())
	public Person(String firstName) {
		this(0, firstName);
	}
	
	public Person(int id) {
		this(id, null);
	}
	
	public Person() {
		this(0, null);
	}
	
	public Person(String firstName, int id) {
		this(id, firstName);
	}
}

public class RecordDemo {
	
	public static void main(String[] args) {
		Person p1 = new Person(1, "Dave");
		Person p2 = new Person(1, "Dave");
		
		System.out.println("p1.id() == p2.id(): " + (p1.id() == p2.id()));
		System.out.println("p1.firstName().equals(p2.firstName())): " + (p1.firstName().equals(p2.firstName())));
		System.out.println("p1.equals(p2): " + p1.equals(p2));
		System.out.println("p1.hashCode() == p2.hashCode(): " + (p1.hashCode() == p2.hashCode()));
	}
}