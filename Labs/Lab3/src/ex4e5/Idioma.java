/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criacao: 07/10/2017
 */
package ex4e5;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criacao: 07/10/2017
 * Representacao  da traducao de alguns parametros da Carta.
 * 
 * 
 * COMENTÁRIO:
 * 
 * Essa classe é responsável pela formação de cada campo da carta.
 * 
 * É extremamente fácil de ser extendida, bastando o programador criar
 * uma nova classe que a extenda ou uma de suas subclasses, sem a necessidade
 * de se alterar nenhuma outra classe.
 * 
 * Ou seja, o código está aberto para extensão mas fechado para modificação, 
 * digamos, se fosse necessário alterar o código interno de alguma classe concreta
 * já existente.
 * 
 * Uma atenção especial foi dada também ao fato de não existirem classes anêmicas, 
 * com apenas um método, o que é um mal-cheiro, dessa forma as traduções dos campos
 * foram agrupados nessa classe idioma, em vez de existirem várias classes pequenas
 * para cada campo.
 * 
 * Para que seja possível o uso de subpartes dinâmicas, utilizou-se o padrão 
 * Fluent Builder para a construção de novos Idiomas (agregação dos já existentes),
 * e uma espécie de Strategy para a delegação entre idiomas. Dessa forma, evitou-se
 * o uso de classes anêmicas, que inclusive, havia sido a primeira solução nossa, 
 * valendo-se de uma factory, porém, haveria 19 classes anêmicas com um método cada.
 * Assim, a estratégia utilizada pareceu uma solução mais elegante.
 * 
 * O Builder faz uso de um Factory Method, chamado rebuild.
 * 
 * Para o uso dos Idioma padrões, utilizou-se o padrão Singleton, uma
 * vez que, uma vez construídos, os idiomas são imutáveis.
 *
 * 
 */
public abstract class Idioma {
	
	private Idioma _despedida;
	private Idioma _vocativo;
	private Idioma _pronome;
	private Idioma _data;
	private Idioma _end;
	private Idioma _fone;

	protected Idioma() { // Construtor padrão utilizado para o Singleton
		_despedida = this;
		_vocativo = this;
		_pronome = this;
		_data = this;
		_end = this;
		_fone = this;
	}
	
	protected Idioma(Builder b) {
		_despedida = b._despedida;
		_vocativo = b._vocativo;
		_pronome = b._pronome;
		_data = b._data;
		_end = b._end;
		_fone = b._fone;
	}
	
	/**
	 * É um Factory Method.
	 * @param b Builder a ser utilizado para construção do novo Idioma
	 * @return Novo idioma representado pelo builder.
	 */
	protected abstract Idioma rebuild(Builder b);
	
	protected abstract String despedidaFormato();
	
	public final String despedida() {
		return _despedida.despedidaFormato();
	}
	protected abstract String vocativoFormato();
	
	
	public final String vocativo() {
		return _vocativo.vocativoFormato();
	}
	
	protected abstract String pronomeFormato();
	
	public final String pronome() {
		return _pronome.pronomeFormato();
	}
	
	protected abstract String dataFormato(String dia,String mes,String ano);
	
	public final String data(String dia, String mes, String ano) {
		return _data.dataFormato(dia,mes,ano);
	}
	
	protected abstract String enderecoFormato(String rua, String cidade, String estado,String pais);
	
	public final String endereco(String rua, String cidade, String estado, String pais) {
		return _end.enderecoFormato(rua,cidade, estado,pais);
	}
	
	protected abstract String foneFormato(String DDI,String cc,String lc,String tel);
	public final String fone(String DDI,String cc,String lc,String tel) {
		return _fone.foneFormato(DDI, cc,lc,tel);
	}
	
	public static class Builder {
		private Idioma _despedida;
		private Idioma _vocativo;
		private Idioma _pronome;
		private Idioma _data;
		private Idioma _end;
		private Idioma _fone;
		private Idioma _principal;
		
		public Builder(Idioma idiomaPrincipal) {
			_principal = idiomaPrincipal;
			_despedida = idiomaPrincipal;
			_pronome = idiomaPrincipal;
			_data = idiomaPrincipal;
			_end = idiomaPrincipal;
			_fone = idiomaPrincipal;
			_vocativo = idiomaPrincipal;
		}
		
		public Builder despedida(Idioma despedida) {
			this._despedida = despedida;
			return this;
		}
		public Builder vocativo(Idioma vocativo) {
			_vocativo = vocativo;
			return this;
		}
		public Builder pronome(Idioma pronome) {
			_pronome = pronome;
			return this;
		}
		public Builder data(Idioma data) {
			_data = data;
			return this;
		}
		public Builder endereco(Idioma end) {
			_end = end;
			return this;
		}
		public Builder fone(Idioma fone) {
			_fone = fone;
			return this;
		}
		public Idioma build() {
			return _principal.rebuild(this);
		}
	}
}
