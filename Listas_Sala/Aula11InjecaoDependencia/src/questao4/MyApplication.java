package questao4;


public class MyApplication {

	private EmailService _email;
	
	public MyApplication(EmailService email) {
		this._email = email;
	}
	
	public void processMessages(String message, String receiver) {
		// Do some msg validation, manipulation logic etc.
		_email.sendEmail(message, receiver);
	}
	
}
