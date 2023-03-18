package lesson6;

public class Persister{

	public Persister(){

	}
	
	public void save(User user){
		System.out.println("Save user: " + user.name());
	}
}