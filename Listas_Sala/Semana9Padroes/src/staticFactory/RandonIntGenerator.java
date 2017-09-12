package staticFactory;
/**
 * Método para adequar o nome do construtor da classe.
Serve para quem facilitar a criação de objetos específicos daquela classe para o usuário.
A estrutura do Static Factory Method é a chamada do construtor da classe passando os parâmetros corretos de acordo com o nome do método.
 */
public class RandonIntGenerator {
	  private final int minimo;
	  private final int maximo;

	  private RandonIntGenerator(int min, int max) {
	    this.minimo = min;
	    this.maximo = max;
	  }
	  
	  /*
	   * ISSO ERA PROBLEMA
	  public RandonIntGenerator(int min) {
	    this.min = min;
	    this.max = Integer.MAX_VALUE;
	  }

	  public RandonIntGenerator(int max) {
	    this.min = Integer.MIN_VALUE;
	    this.max = max;
	  }

	   */

	  // Resolvemos esse problema com o padrão static factory
	  public static RandonIntGenerator entre(int max, int min) {
	    return new RandonIntGenerator(min, max);
	  }

	  public static RandonIntGenerator maiorQue(int min) {
	    return new RandonIntGenerator(min, Integer.MAX_VALUE);
	  }

	  public static RandonIntGenerator menorQue(int max) {
	    return new RandonIntGenerator(Integer.MIN_VALUE, max);
	  }

	  public int next() {
		  return 0;
	  }
	}