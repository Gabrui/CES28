package ex2;
/**
 * Data da criacao: 29/09/2017
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Classe para armazenar datas e suas possiveis formatacoes.
 */
public class Data {

	
	private final String _dia;
	private final String _mes;
	private final String _ano;
	public Data(String dia,String mes,String ano) {
		_dia = dia;
		_mes = mes;
		_ano = ano;
	}
	public String getDia() {
		return _dia;
	}
	public String getMes() {
		return _mes;
	}
	public String getAno() {
		return _ano;
	}
	
}
