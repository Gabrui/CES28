package presenter;

import java.io.File;

import model.CubicSpline;
import model.DataPoints;
import model.InterpolationMethod;
import model.Lagrange;

public class Presenter {

    private final String CS_METHOD = "Cubic Spline";
    private final String L_METHOD = "Lagrange";
    private final String DEFAULT_METHOD = CS_METHOD;
    private InterpolationMethod interpolationModel;
    private IView view;
    private DataPoints model;
    
    public Presenter() {
    	bind();
    }

    // RESPONSABILITY: ESCOLHER O METODO DE INTERPOLACAO DESEJADO E CRIAR O OBJETO CORRESPONDENTE
    public void bind() { interpolationModel = (InterpolationMethod) getMethod(DEFAULT_METHOD);}
    public InterpolationMethod getMethod() { return interpolationModel; }
    public InterpolationMethod getMethod(String method) {
        switch (method) {
            case L_METHOD:
                interpolationModel = new Lagrange();
                break;
            case CS_METHOD:
                interpolationModel = new CubicSpline();
                break;
            default:
            	System.out.println("Unknown method " + method);
        }

        return interpolationModel;
    }

    
    // RESPONSABILITY: DADO O VALOR DE X, EFETIVAMENTE LER O ARQUIVO E CHAMAR O CALCULO. 
    public void calculateResult(float value, File file) {
        model.buildDataPoints(file);
        if(getMethod() != null) {
            double result = getMethod().calculateResult(value, model.getX(), model.getY());
            view.printResult(result);
        } else {
            System.out.println("It is not defined an interpolation method.");
        }
    }
}
