package hookMethod;

/*
Método Hook é baseado na sobreescrita de métodos que são chamados dentro de 
um método que é um template, ou seja, possui códigos em comum com a lógica
das suas classes filhas, porém uma parte dentro desse método é variável dependendo da classe filha.
Estrutura é um método template da classe pai que possui código em comum com 
as filhas e no meio desse método possui uma parte que varia dependendo da classe
 filha, e é essa parte que é colocado dentro de um método hook que é sobrescrito
  pelas classes filhas, e que é chamado no método template da classe pai.
Nome alternativo template method definido como um comportamento de design pattern
 que define o esqueleto de uma algoritmo de deixa algumas partes para as subclasses
  definirem por sobreescrita sem alterar a estrutura geral do algoritmo.
*/

public class Impressora {
	
	public void metodoPrincipal() {
		System.out.println("Executando impressão");
		this.logicaInterna();
	}
	
	protected void logicaInterna() {
		System.out.println("Impressão configurada genericamente");
	}

}
