package staticFactory;

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