package questao6;

public class EmailService implements MessageService {

	public void sendEmail(String message, String receiver){
        // Logic to send email
		System.out.println("Email sent to "+ receiver);
		System.out.println("----------------------------------");
		System.out.println("Message: " + message);
	}
	
}
