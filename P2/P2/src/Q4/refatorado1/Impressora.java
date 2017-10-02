package Q4.refatorado1;

public class Impressora implements Imprime {
	
	public void imprimir(String conteudo) {
		if (conteudo==null) {
			throw new IllegalArgumentException("conteudo nulo");
		}
		else 
			System.out.println(conteudo);
	}
	
}
