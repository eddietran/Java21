
public class SingletonDemo {
	
	public static void main(String[] args) {
		Singleton instance = Singleton.INSTANCE;
		Singleton s = Singleton.INSTANCE;
		
		System.out.println("Only one singleton instance: " + (instance == s));
	}
	
	public enum Singleton {
		INSTANCE;
	}
}
