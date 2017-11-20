package presenter;

import java.util.HashMap;

import model.CubicSpline;
import model.InterpolationMethod;
import model.Lagrange;

/**
 *     3. [2 pt] SUBQUESTÃO [IMPLEMENTAÇÃO]: 
 *     Padrão de Abstract Factory
 *     Seja possível implementar e escolher outros algoritmos 
 *     de interpolação, sem precisar mudar nada no código além 
 *     de uma chamada de método para registrar o novo algoritmo. 
 *     As camadas superiores apenas precisam escolher uma String 
 *     correspondendo ao nome do método de interpolação desejado. 
 * @author gabriel
 *
 */
public class InterpolationFactory {

    public static final String CS_METHOD = "Cubic Spline";
    public static final String L_METHOD = "Lagrange";
    
	private HashMap<String, InterpolationMethod> metodos;
	private static InterpolationFactory INSTANCE;
	
	public static InterpolationFactory getInstance() {
		if (INSTANCE == null)
			INSTANCE = new InterpolationFactory();
		return INSTANCE;
	}
	
	private InterpolationFactory() {
		metodos = new HashMap<>();
		addInterpolationMethod(CS_METHOD, new CubicSpline());
		addInterpolationMethod(L_METHOD, new Lagrange());
	}
	
	protected void addInterpolationMethod(String nome, InterpolationMethod metodo) {
		metodos.put(nome, metodo);
	}

    // RESPONSABILITY: ESCOLHER O METODO DE INTERPOLACAO DESEJADO E CRIAR O OBJETO CORRESPONDENTE
    public InterpolationMethod getMethod(String method) {
    	return metodos.get(method);
    }
}
