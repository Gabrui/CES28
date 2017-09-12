package staticFactory;

// estende-se o gerador de Tipoeiro do item b) 
//para suportar Tipoeiro, Double, Long e String. 
//Mostrar uma implementação com static factory methods que resolva essa situação
public class RandomGenerator<Tipo> {
	final Tipo minimo;
	final Tipo maximo;
	
	private RandomGenerator(Tipo minimo, Tipo maximo) {
		this.minimo = minimo;
		this.maximo = maximo;
		// TODO
	}
	
	  public static RandomGenerator<Object> entre(Object max, Object min) {
	    return new RandomGenerator<Object>(min, max);
	  }

	  public static RandomGenerator<Object> maiorQue(Object min) {
		    return new RandomGenerator<Object>(min, resolveMaximo(min));
	  }

	  public static RandomGenerator<Object> menorQue(Object max) {
		    return new RandomGenerator<Object>(resolveMinimo(max), max);
	  }
	  
	  private static Object resolveMinimo(Object max) {
		  // TODO
		  return null;
	  }
	  
	  private static Object resolveMaximo(Object min) {
		  // TODO
		  return null;
	  }
}
