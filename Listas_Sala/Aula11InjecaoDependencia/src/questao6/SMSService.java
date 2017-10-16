package questao6;

public class SMSService implements MessageService {

	@Override
	public void sendEmail(String message, String receiver) {
		System.out.println("SMS sent to "+ receiver);
		System.out.println("----------------------------------");
		System.out.println("Message: " + message);
	}

}
