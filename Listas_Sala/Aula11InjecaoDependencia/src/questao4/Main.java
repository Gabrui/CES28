package questao4;

public class Main {

	public static void main(String[] args) {
		EmailService email = new EmailService();
		new MyApplication(email).processMessages("mensagem", "destinatário");
	}

}
