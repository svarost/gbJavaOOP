package lesson6;

public record User(String name) implements Reportable {

	public void report() {
		System.out.println("Report for user: " + name);
	}
}