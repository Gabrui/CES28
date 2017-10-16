package questao12;

public class SOSistemaCliente {
	
	UI_TelaConversa tela1;
	UI_TelaConversa tela2;
	RN_Usuario regrasDeNegocio;
	
	public SOSistemaCliente() {
		regrasDeNegocio = new RN_Usuario();
		tela1 = new UI_TelaConversa(regrasDeNegocio, "Obs1");
		tela2 = new UI_TelaConversa(regrasDeNegocio, "Obs2");
		
	}
	
	public static void main(String[] s) {
		SOSistemaCliente local = new SOSistemaCliente();
		local.fazerQuestao11();
	}
	
	public void fazerQuestao11() {
		System.out.println("Gerar primeiro evento\n" + 
				"---------------------");
		regrasDeNegocio.setEstado("Olá, como vai?");
		
		regrasDeNegocio.deleteObserver(tela1);
		
		System.out.println("\nGerar segundo evento\n" + 
				"---------------------");
		regrasDeNegocio.setEstado("Por aqui vai tudo bem!");
	}
}
