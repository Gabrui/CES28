package nullObject;
/*
 * Null Object é uma classe que possui todos os métodos em geral não implementados.
 *  Dessa forma, ele não faz nada.
Ele serve para começar a implementação de uma classe da forma mais simples possível.
 E comparado ao valor especial “null”, o Null Object pode implementar interfaces para não fazer nada. 
 Assim, o Null Object pode ser substituído por objetos reais.
Null Object é chamado de Special Case por Martin Fowler.
Estrutura é que o Null Object é filho de uma classe abstrata.

 */
public class AplicacaoDepois {
	
	public AplicacaoDepois() {
		Customer depois = new RealCustomer("ola");
		Customer depois2 = new NullCustomer();
		
		depois.getName();
		depois2.getName();
	}
}
