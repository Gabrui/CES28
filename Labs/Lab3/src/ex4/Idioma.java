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
	
	protected static Idioma instance;
	
	protected Idioma _despedida = this;
	/*
	protected FormatoVocativo _vocativo = this;
	protected FormatoPronome _pronome;
	protected FormatoData _data;
	protected FormatoEndereco _end;
	protected FormatoFone _fone;
	*/
	
	protected Idioma() { // Construtor padrão
	}
	
	protected Idioma(Builder b) {
		// TODO
	}
	
	static public Idioma getInstance() {
		return instance;
	}
	
	public abstract String despedidaFormato();
	
	public final String despedida() {
		return _despedida.despedida();
	}
	/*
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
		return _fone.fone(fone.getDDI(), fone.getCC(),fone.getLC(),fone.getTel());
	}
	public String fone(Telefone fone,FormatoFone format) {
		_fone = format;
		return fone(fone);
	}
	*/
	protected abstract static class Builder {
		protected Idioma principal;
		protected Idioma despedida;
		
		public Builder(Idioma idioma) {
			principal = idioma;
			despedida = idioma;
			// TODO
		}
		
		public Builder despedida(Idioma depedida) {
			this.despedida = despedida;
			return this;
		}
		
		public Idioma build() {
			return principal;
		}
	}
}
