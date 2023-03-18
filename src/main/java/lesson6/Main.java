package lesson6;

public class Main{
	public static void main(String[] args){
		Persister persister = new Persister();
		User user = new User("Bob");
		user.report();
		persister.save(user);
	}
}