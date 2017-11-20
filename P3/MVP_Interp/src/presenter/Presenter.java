package presenter;

import java.util.Observable;

import model.DataPoints;
import model.InterpolationMethod;

public class Presenter extends Observable {

    private final String DEFAULT_METHOD = InterpolationFactory.CS_METHOD;
    private InterpolationMethod interpolationModel;
    private DataPoints model;
    private InterpolationFactory fabrica;
    private boolean valido;
    private double resultado;
    
    public Presenter() {
    	fabrica = InterpolationFactory.getInstance();
    	bind();
    }

    // RESPONSABILITY: ESCOLHER O METODO DE INTERPOLACAO DESEJADO E CRIAR O OBJETO CORRESPONDENTE
    public void bind() { 
    	interpolationModel = fabrica.getMethod(DEFAULT_METHOD);
    }
	public void setMetodoInterpolacao(String interpolacao) {
		this.interpolationModel = fabrica.getMethod(interpolacao);
	}
	
    // RESPONSABILITY: DADO O VALOR DE X, EFETIVAMENTE LER O ARQUIVO E CHAMAR O CALCULO. 
	public void calculaInterpolacao(double valor) {
        if(interpolationModel != null && model!=null) {
            resultado = interpolationModel.calculateResult(valor, model.getX(), model.getY());
            valido = true;
        } else {
        	valido = false;
        }
		this.setChanged();
		this.notifyObservers(resultado);
	}

	public void setArquivoDados(String arquivoDados) {
		this.model = new DataPoints(arquivoDados);
	}
	
	public double getUltimoResultado() {
		return resultado;
	}

	public boolean isResultadoValido() {
		return valido;
	}
}
