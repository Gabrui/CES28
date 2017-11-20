package view;

import java.text.DecimalFormat;
import java.util.Observable;

import presenter.Presenter;

// Responsabilidades enumeradas no pdf correspondem ao código:
//    RESPONSABILITY: LEITURA DO NOME DO METODO DE INTERPOLACAO
// 1. RESPONSABILITY: DEFINIR PONTO DE INTERPOLACAO (LEITURA ENTRADA DE USUARIO HUMANO) 
// 2. RESPONSABILITY: DEFINIR QUAL EH O ARQUIVO COM DADOS DE PONTOS DA FUNCAO (LEITURA ENTRADA DE USUARIO HUMANO)
// 4. RESPONSABILITY: IMPRIMIR RESULTADOS no console (Saida para usuário humano)

public class ConsoleView implements IView {
	
	private String interpolacao;
	private String arquivoDados;
	private Presenter presenter;
    private double _value;
    private DecimalFormat formatResult = new DecimalFormat("####.######");
    
    public void init(Presenter presenter) {
    	this.presenter = presenter;
    	presenter.addObserver(this);
    }
    
    // ENTRADA DE USUARIO HUMANO: ESCOLHA DO METODO DE INTERPOLACAO
    // RESPONSABILITY: LEITURA DO NOME DO METODO DE INTERPOLACAO
	public void setMetodoInterpolacao(String interpolacao) {
		this.interpolacao = interpolacao;
		presenter.setMetodoInterpolacao(interpolacao);
	}
	// ENTRADA DE USUARIO HUMANO: PONTO DE INTERPOLACAO E NOME DO ARQUIVO DE DADOS.   
	// RESPONSABILITY: DEFINIR PONTO DE INTERPOLACAO (LEITURA ENTRADA DE USUARIO HUMANO) 
	public void setPontoInterpolacao(double valor) {
		this._value = valor;
		presenter.calculaInterpolacao(valor);
	}
	// RESPONSABILITY: DEFINIR QUAL EH O ARQUIVO COM DADOS DE PONTOS DA FUNCAO (LEITURA ENTRADA DE USUARIO HUMANO)
	public void setArquivoDados(String arquivoDados) {
		this.arquivoDados = arquivoDados;
		presenter.setArquivoDados(arquivoDados);
	}
	
	 // RESPONSABILITY: IMPRIMIR RESULTADOS
    public void printResult(double result) {
    	System.out.println("***********************\nMétodo: "+interpolacao);
    	System.out.println("DataFile: " + arquivoDados);
    	System.out.println("Interp at " + formatResult.format(_value) + " ; result = " + formatResult.format(result));
	}
    
	@Override
	public void update(Observable arg0, Object arg1) {
		if (presenter.isResultadoValido())
			printResult((Double) arg1);
		else
            System.out.println("It is not defined an interpolation method.");
	}
}
