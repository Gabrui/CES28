/**
 * LAB -3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 10/10/2017
 */
package ex4;
import java.util.HashMap;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Representa a classe de criacao de cartas.
 */
public class FactoryCarta {

	private Pessoa _remetente;
	private Pessoa _destinatario;
	private Data _data;
	private Idioma _idioma;
	private Modelo _modelo;
	private HashMap<String,Idioma> _listIdioma;
	private HashMap<Idioma,ModeloComercial> _listModeloComercial;
	private HashMap<Idioma,ModeloPessoal> _listModeloPessoal;
	private HashMap<Idioma,ModeloArgumentativa> _listModeloArgumentativa;
	
	public FactoryCarta(Pessoa remetente, Pessoa destinatario, Data data, String idioma) {
		
		_listIdioma = new HashMap<String, Idioma>();
		_listModeloComercial = new HashMap<Idioma,ModeloComercial>();
		_listModeloPessoal = new HashMap<Idioma,ModeloPessoal>();
		_listModeloArgumentativa = new HashMap<Idioma,ModeloArgumentativa>();
		montarListIdioma();
		montarListModelo();
		_remetente = remetente;
		_destinatario = destinatario;
		_data = data;
		setIdioma(idioma);
		
		
	}
	private void montarListIdioma() {
		_listIdioma.put("portugues", Portugues.INSTANCE);
		_listIdioma.put("ingles", Ingles.INSTANCE);
	}
	private void montarListModelo() {
		
		//Colocando modelo da lingua Inglesa
		_listModeloComercial.put(Ingles.INSTANCE, new ModeloComercialUSA());
		_listModeloPessoal.put(Ingles.INSTANCE, new ModeloPessoalUSA());
		_listModeloArgumentativa.put(Ingles.INSTANCE, new ModeloArgumentativaUSA());
		//Fim dos modelos americanos
		
		//Colocando modelo da linga portuguesa
		_listModeloComercial.put(Portugues.INSTANCE, new ModeloComercialBR());
		_listModeloPessoal.put(Portugues.INSTANCE, new ModeloPessoalBR());
		_listModeloArgumentativa.put(Portugues.INSTANCE, new ModeloArgumentativaBR());
		//Fim dos modelos brasileiros
		
	}
	private void setIdioma(String idioma) {
		
		_idioma = _listIdioma.get(idioma.toLowerCase());
		if(_idioma == null) {
			
			throw new IllegalArgumentException();
		}
	}
	private Carta buildCarta() {
		return new Carta(_remetente, _destinatario, _data,_idioma,_modelo);
	}
	public Carta buildCartaComercial() {
		
		_modelo = _listModeloComercial.get(_idioma);
		return buildCarta();
	}
	public Carta buildCartaPessoal() {
		_modelo = _listModeloPessoal.get(_idioma);
		return buildCarta();
	}
	public Carta buildCartaArgumentativa() {
		_modelo = _listModeloArgumentativa.get(_idioma);
		return buildCarta();
	}
	public void configIdiomaData(String idioma) {
		Idioma Idiomadata = _listIdioma.get(idioma.toLowerCase());
		Idioma.Builder builder = new Idioma.Builder(_idioma);
		builder.data(Idiomadata);
		_idioma = builder.build();
	}
	public void configIdiomaDespedida(String idioma) {
		Idioma IdiomaDespedida = _listIdioma.get(idioma.toLowerCase());
		Idioma.Builder builder = new Idioma.Builder(_idioma);
		builder.despedida(IdiomaDespedida);
		_idioma = builder.build();
	}
}
