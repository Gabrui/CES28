/**
 * LAB -3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 12/10/2017
 */
package ex4;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Classe Escritor serve para receber o pedido do cliente e devolver uma carta.
 */
public class Escritor {

	private Pessoa _remetente;
	private Pessoa _destinatario;
	private Data _data;
	private Idioma.Builder _builder;
	
	public Escritor(Pessoa remetente, Pessoa destinatario, Data data) {
		_remetente = remetente;
		_destinatario = destinatario;
		_data = data;
	}
	protected Idioma getIdioma() {
		if(_builder == null)
			throw new RuntimeException("variable Idioma not especified! "
				+ "\nPlease use Ingles or Portugues before use write method.");
		return _builder.build();
	}
	//Ao escolher um idioma para carta
	//todos os formato dos campos sao daquele idioma escolhido.
	private void definePrincipalIdioma(Idioma idioma) {
		_builder = new Idioma.Builder(idioma);
	}
	// fim dos metodos facilitadores de extensao
	public void Ingles() {
		definePrincipalIdioma(Ingles.INSTANCE);
	}
	public void Portugues() {
		definePrincipalIdioma(Portugues.INSTANCE);
	}
	public void configIdiomaData2Ingles() {
		_builder.data(Ingles.INSTANCE);
	}
	public void configIdiomaDespedida2Ingles() {
		_builder.despedida(Ingles.INSTANCE);
	}
	public void configIdiomaEndereco2Ingles() {
		_builder.endereco(Ingles.INSTANCE);
	}
	public void configIdiomaFone2Ingles() {
		_builder.fone(Ingles.INSTANCE);
	}
	public void configIdiomaPronome2Ingles() {
		_builder.pronome(Ingles.INSTANCE);
	}
	public void configIdiomaVocativo2Ingles() {
		_builder.vocativo(Ingles.INSTANCE);
	}
	public void configIdiomaData2Portugues() {
		_builder.data(Portugues.INSTANCE);
	}
	public void configIdiomaDespedida2Portugues() {
		_builder.despedida(Portugues.INSTANCE);
	}
	public void configIdiomaEndereco2Portugues() {
		_builder.endereco(Portugues.INSTANCE);
	}
	public void configIdiomaFone2Portugues() {
		_builder.fone(Portugues.INSTANCE);
	}
	public void configIdiomaPronome2Portugues() {
		_builder.pronome(Portugues.INSTANCE);
	}
	public void configIdiomaVocativo2Portugues() {
		_builder.vocativo(Portugues.INSTANCE);
	}
	
	public Carta writeCartaComercial() {
		FactoryCarta fCarta = new FactoryCarta(_remetente,_destinatario,_data, getIdioma());
		return fCarta.buildCartaComercial();
	}
	
	//Metodo para facilitar pro cliente criar
	//cartas comerciais no modelo americano padrao.
	public Carta writeCartaComercialUSA() {
		
		this.Ingles();
		return this.writeCartaComercial();
		
	}
	
	//Metodo para facilitar pro cliente criar
	//cartas comerciais no modelo brasileiro padrao.
	public Carta writeCartaComercialBR() {
		
		this.Portugues();
		return this.writeCartaComercial();
		
	}
	
	public Carta writeCartaPessoal() {
		FactoryCarta fCarta = new FactoryCarta(_remetente,_destinatario,_data,getIdioma());
		return fCarta.buildCartaPessoal();
	}
	
	//Metodo para facilitar pro cliente criar
	//cartas pessoal no modelo americano padrao.
	public Carta writeCartaPessoalUSA() {
		this.Ingles();
		return this.writeCartaPessoal();
	}
	
	//Metodo para facilitar pro cliente criar
	//cartas pessoal no modelo brasileiro padrao.
	public Carta writeCartaPessoalBR() {
		this.Portugues();
		return this.writeCartaPessoal();
	}
	
	public Carta writeCartaArgumentativa() {
		FactoryCarta fCarta = new FactoryCarta(_remetente,_destinatario,_data,getIdioma());
		return fCarta.buildCartaArgumentativa();
	}
	
	//Metodo para facilitar pro cliente criar
	//cartas argumentativa no modelo americano padrao.
	public Carta writeCartaArgumentativaUSA() {
		this.Ingles();
		return this.writeCartaArgumentativa();
	}
	
	//Metodo para facilitar pro cliente criar
	//cartas argumentativa no modelo brasileiro padrao.
	public Carta writeCartaArgumentativaBR() {
		this.Portugues();
		return this.writeCartaArgumentativa();
	}
}
