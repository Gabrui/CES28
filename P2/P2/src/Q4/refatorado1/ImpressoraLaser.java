package Q4.refatorado1;

public class ImpressoraLaser implements Imprime {
	
	public void imprimir(String conteudo) {
		if (conteudo==null) {
			throw new IllegalArgumentException("conteudo nulo");
		}
		else 
			System.out.println("EM LASER!\n"+conteudo);
	}
	
}
