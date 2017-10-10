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
	
	public FactoryCarta(Pessoa remetente, Pessoa destinatario, Data data, String idioma) {
		
		_listIdioma = new HashMap<String, Idioma>();
		montarListIdioma();
		_remetente = remetente;
		_destinatario = destinatario;
		_data = data;
		setIdioma(idioma);
		
		
	}
	private void montarListIdioma() {
		_listIdioma.put("portugues",new Portugues.PortuguesBuilder().build());
		_listIdioma.put("ingles", new Ingles.InglesBuilder().build());
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
		
		if(_idioma instanceof Ingles) {
			_modelo = new ModeloComercialUSA();
		}
		else if(_idioma instanceof Portugues) {
			_modelo = new ModeloComercialBR();
		}
		return buildCarta();
	}
	public Carta buildCartaPessoal() {
		if(_idioma instanceof Ingles) {
			_modelo = new ModeloPessoalUSA();
		}
		else if(_idioma instanceof Portugues) {
			_modelo = new ModeloPessoalBR();
		}
		return buildCarta();
	}
	public Carta buildCartaArgumentativa() {
		if(_idioma instanceof Ingles) {
			_modelo = new ModeloArgumentativaUSA();
		}
		else if(_idioma instanceof Portugues) {
			_modelo = new ModeloArgumentativaBR();
		}
		return buildCarta();
	}
	public void configIdiomaData(String idioma) {
		Idioma Idiomadata = _listIdioma.get(idioma);
		Idioma.Builder builder = new Idioma.Builder(_idioma);
		builder.data(Idiomadata);
		_idioma = builder.build();
	}
}
