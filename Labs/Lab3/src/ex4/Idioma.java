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
	
	protected Idioma _despedida;
	protected Idioma _vocativo;
	protected Idioma _pronome;
	protected Idioma _data;
	protected Idioma _end;
	protected Idioma _fone;
	/*
	protected FormatoVocativo _vocativo = this;
	protected FormatoPronome _pronome;
	protected FormatoData _data;
	protected FormatoEndereco _end;
	protected FormatoFone _fone;
	*/
	
	protected Idioma() { // Construtor padrão
		
		_despedida = this;
		_vocativo = this;
		_pronome = this;
		_data = this;
		_end = this;
		_fone = this;
	}
	
	protected Idioma(Builder b) {
		// TODO
		_despedida = b._despedida;
		_vocativo = b._vocativo;
		_pronome = b._pronome;
		_data = b._data;
		_end = b._end;
		_fone = b._fone;
	}
	
	protected abstract String despedidaFormato();
	
	public final String despedida() {
		return _despedida.despedidaFormato();
	}
	protected abstract String vocativoFormato();
	
	
	public  String vocativo() {
		return _vocativo.vocativoFormato();
	}
	
	protected abstract String pronomeFormato();
	
	public  String pronome() {
		return _pronome.pronomeFormato();
	}
	
	protected abstract String dataFormato(String dia,String mes,String ano);
	
	public String data(String dia, String mes, String ano) {
		return _data.dataFormato(dia,mes,ano);
	}
	
	protected abstract String enderecoFormato(String rua, String cidade, String estado,String pais);
	
	public String endereco(String rua, String cidade, String estado, String pais) {
		return _end.enderecoFormato(rua,cidade, estado,pais);
	}
	
	protected abstract String foneFormato(String DDI,String cc,String lc,String tel);
	public String fone(String DDI,String cc,String lc,String tel) {
		return _fone.foneFormato(DDI, cc,lc,tel);
	}
	protected abstract static class Builder {
		private Idioma _despedida;
		private Idioma _vocativo;
		private Idioma _pronome;
		private Idioma _data;
		private Idioma _end;
		private Idioma _fone;
		private Idioma _principal;
		
		public Builder(Idioma idioma) {
			_principal = idioma;
			_despedida = idioma;
			_pronome = idioma;
			_data = idioma;
			_end = idioma;
			_fone = idioma;
			// TODO
		}
		
		public Builder despedida(Idioma despedida) {
			this._despedida = despedida;
			return this;
		}
		public Builder vocativo(Idioma vocativo) {
			_vocativo = vocativo;
			return this;
		}
		public Idioma build() {
			return _principal;
		}
	}
}
