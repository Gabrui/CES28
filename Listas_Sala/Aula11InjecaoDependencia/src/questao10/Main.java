package questao10;


public class Main {

	public static void main(String[] args) {
		Consumer aplicativo;
		
		aplicativo = new SMSServiceInjector().getConsumer();
		aplicativo.processMessages("mensagem", "destinat�rio");
		

		aplicativo = new EmailServiceInjector().getConsumer();
		aplicativo.processMessages("mensagem", "destinat�rio");
	}

}
