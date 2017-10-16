package questao4;

public class MyApplication {
	public void processMessages(EmailService email, String message, String receiver) {
		// Do some msg validation, manipulation logic etc.
		email.sendEmail(message, receiver);
	}
}
