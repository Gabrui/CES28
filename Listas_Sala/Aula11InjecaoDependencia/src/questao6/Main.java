package questao6;

public class Main {

	public static void main(String[] args) {
		MessageService servico = new EmailService();
		new MyApplication(servico).processMessages("mensagem", "destinatário");

		System.out.println("\n\n");
		servico = new SMSService();
		new MyApplication(servico).processMessages("mensagem", "destinatário");
	}

}
