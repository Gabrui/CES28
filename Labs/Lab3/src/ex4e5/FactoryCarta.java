/**
 * LAB -3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 10/10/2017
 */
package ex4e5;
import java.util.HashMap;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Representa a classe de criacao de cartas.
 * 
 * Ao escolher uma língua, o usuário das classes automaticamente receberá 
 * uma carta comercial no formato correspondente à língua escolhida, não 
 * apenas considerando o formato dos campos (Idioma), mas também a ordenação e 
 * disposição dos campos na página (Modelo). 

 */
public class FactoryCarta {

	private Pessoa _remetente;
	private Pessoa _destinatario;
	private Data _data;
	protected String idioma;
	private Idioma novo;
	private HashMap<String, ModeloComercial> _listModeloComercial;
	private HashMap<String, ModeloPessoal> _listModeloPessoal;
	private HashMap<String, ModeloArgumentativa> _listModeloArgumentativa;
	private HashMap<String, Idioma> stringIdioma;
	
	public FactoryCarta(Pessoa remetente, Pessoa destinatario, Data data, String idiomaModelo) {
		_listModeloComercial = new HashMap<String, ModeloComercial>();
		_listModeloPessoal = new HashMap<String,ModeloPessoal>();
		_listModeloArgumentativa = new HashMap<String, ModeloArgumentativa>();
		stringIdioma = new HashMap<>();
		
		montarListModelo();
		_remetente = remetente;
		_destinatario = destinatario;
		_data = data;
		idioma = idiomaModelo;
	}
	
	public FactoryCarta(Pessoa remetente, Pessoa destinatario, Data data, String idiomaModelo, Idioma novo) {
		this(remetente, destinatario, data, idiomaModelo);
		this.novo = novo;
	}
	
	
	private void montarListModelo() {
		addModeloComercial("en_US", new ModeloComercialUSA());
		addModeloPessoal("en_US", new ModeloPessoalUSA());
		addModeloArgumentativo("en_US", new ModeloArgumentativaUSA());
		
		addModeloComercial("pt_BR", new ModeloComercialBR());
		addModeloPessoal("pt_BR", new ModeloPessoalBR());
		addModeloArgumentativo("pt_BR", new ModeloArgumentativaBR());
		
		addStringIdioma("en_US", Ingles.INSTANCE);
		addStringIdioma("pt_BR", Portugues.INSTANCE);
	}
	
	// Métodos Protected para facilitar a extensão da Factory
	protected ModeloArgumentativa getModeloArgumentativo(String idioma) {
		return _listModeloArgumentativa.get(idioma);
	}
	
	protected ModeloComercial getModeloComercial(String idioma) {
		return _listModeloComercial.get(idioma);
	}
	
	protected ModeloPessoal getModeloPessoal(String idioma) {
		return _listModeloPessoal.get(idioma);
	}
	
	protected void addStringIdioma(String nome, Idioma idioma) {
		this.stringIdioma.put(nome, idioma);
	}
	
	protected void addModeloArgumentativo(String idioma, ModeloArgumentativa modelo) {
		this._listModeloArgumentativa.put(idioma, modelo);
	}
	
	protected void addModeloComercial(String idioma, ModeloComercial modelo) {
		this._listModeloComercial.put(idioma, modelo);
	}
	
	protected void addModeloPessoal(String idioma, ModeloPessoal modelo) {
		this._listModeloPessoal.put(idioma, modelo);
	}
	
	/**
	 * Método extra caso se queira passa um modelo explicitamente.
	 * @param modelo
	 * @return
	 */
	public Carta buildCarta(Modelo modelo) {
		if (novo != null)
			return new Carta(_remetente, _destinatario, _data,novo, modelo);
		return new Carta(_remetente, _destinatario, _data,stringIdioma.get(idioma), modelo);
	}
	
	public Carta buildCartaComercial() {
		return buildCarta(getModeloComercial(idioma));
	}
	public Carta buildCartaPessoal() {
		return buildCarta(getModeloPessoal(idioma));
	}
	public Carta buildCartaArgumentativa() {
		return buildCarta(getModeloArgumentativo(idioma));
	}
}
