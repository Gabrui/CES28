package view;

import java.text.DecimalFormat;

// Responsabilidades enumeradas no pdf correspondem ao código:
//    RESPONSABILITY: LEITURA DO NOME DO METODO DE INTERPOLACAO
// 1. RESPONSABILITY: DEFINIR PONTO DE INTERPOLACAO (LEITURA ENTRADA DE USUARIO HUMANO) 
// 2. RESPONSABILITY: DEFINIR QUAL EH O ARQUIVO COM DADOS DE PONTOS DA FUNCAO (LEITURA ENTRADA DE USUARIO HUMANO)
// 4. RESPONSABILITY: IMPRIMIR RESULTADOS no console (Saida para usuário humano)

public class ConsoleView {

    // ENTRADA DE USUARIO HUMANO: ESCOLHA DO METODO DE INTERPOLACAO   
    // RESPONSABILITY: LEITURA DO NOME DO METODO DE INTERPOLACAO
	// ENTRADA DE USUARIO HUMANO: PONTO DE INTERPOLACAO E NOME DO ARQUIVO DE DADOS.   
	// RESPONSABILITY: DEFINIR PONTO DE INTERPOLACAO (LEITURA ENTRADA DE USUARIO HUMANO) 
	// RESPONSABILITY: DEFINIR QUAL EH O ARQUIVO COM DADOS DE PONTOS DA FUNCAO (LEITURA ENTRADA DE USUARIO HUMANO)
	

    private double _value;
    private DecimalFormat formatResult = new DecimalFormat("####.######");
	
    
	 // RESPONSABILITY: IMPRIMIR RESULTADOS
    public void printResult(double result) {
    	System.out.println("***********************");
    	System.out.println("DataFile: " + getDataFile());
    	System.out.println("Interp at " + formatResult.format(_value) + " ; result = " + formatResult.format(result));
	}
    

	private String getDataFile() {
		// TODO Auto-generated method stub
		return null;
	}
}
