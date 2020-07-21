package tp13;

public class NotPasswordException extends Exception{
	public NotPasswordException() {
		super("No good password");
	}
}
