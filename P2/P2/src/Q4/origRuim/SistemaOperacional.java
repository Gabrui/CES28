package Q4.origRuim;

public class SistemaOperacional {
	public Impressora getDriverImpressao() {
		return new Impressora();
	}
	
	// A responsabilidade é redirecionada pelo sistema operacional
	public void imprimir(String conteudo) {
		this.getDriverImpressao().imprimir(conteudo);
	}
}
