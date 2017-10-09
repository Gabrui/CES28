/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criacao: 07/10/2017
 */
package ex4;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criacao: 07/10/2017
 * Representacao  da traducao de alguns parametros da Carta.
 */
public abstract class Idioma {
	
	protected FormatoDespedida _despedida;
	protected FormatoVocativo _vocativo;
	protected FormatoPronome _pronome;
	protected FormatoData _data;
	protected FormatoEndereco _end;
	protected FormatoFone _fone;
	
	public  String despedida() {
		return _despedida.despedida();
	}
	public String despedida(FormatoDespedida format){
		_despedida = format;
		return despedida();
	}	
	public  String vocativo() {
		return _vocativo.vocativo();
	}
	public String vocativo(FormatoVocativo format) {
		_vocativo = format;
		return vocativo();
	}
	public  String pronome() {
		return _pronome.pronome();
	}
	public String pronome(FormatoPronome format) {
		_pronome = format;
		return pronome();
	}
	public String data(Data data) {
		return _data.data(data.getDia(),data.getMes(),data.getAno());
	}
	public String data(Data data,FormatoData format) {
		_data = format;
		return data(data);
	}
	public String endereco(Endereco end) {
		return _end.endereco(end.getRua(),end.getCidade(), end.getEstado(), end.getPais());
	}
	public String endereco(Endereco end,FormatoEndereco format) {
		_end = format;
		return endereco(end);
	}
	public String fone(Telefone fone) {
		return _fone.fone(fone.DDI(), fone.cc(),fone.lc(),fone.tel());
	}
	public String fone(Telefone fone,FormatoFone format) {
		_fone = format;
		return fone(fone);
	}
}
