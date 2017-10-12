/**
 * LAB -3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 10/10/2017
 */
package ex3;
import java.util.HashMap;

import ex4.Carta;
import ex4.Data;
import ex4.Idioma;
import ex4.Ingles;
import ex4.Modelo;
import ex4.ModeloArgumentativa;
import ex4.ModeloArgumentativaBR;
import ex4.ModeloArgumentativaUSA;
import ex4.ModeloComercial;
import ex4.ModeloComercialBR;
import ex4.ModeloComercialUSA;
import ex4.ModeloPessoal;
import ex4.ModeloPessoalBR;
import ex4.ModeloPessoalUSA;
import ex4.Pessoa;
import ex4.Portugues;
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
	private HashMap<Idioma,ModeloComercial> _listModeloComercial;
	private HashMap<Idioma,ModeloPessoal> _listModeloPessoal;
	private HashMap<Idioma,ModeloArgumentativa> _listModeloArgumentativa;
	
	public FactoryCarta(Pessoa remetente, Pessoa destinatario, Data data, Idioma idioma) {
		

		_listModeloComercial = new HashMap<Idioma,ModeloComercial>();
		_listModeloPessoal = new HashMap<Idioma,ModeloPessoal>();
		_listModeloArgumentativa = new HashMap<Idioma,ModeloArgumentativa>();
		montarListModelo();
		_remetente = remetente;
		_destinatario = destinatario;
		_data = data;
		_idioma = idioma;
		
		
	}
	protected void montarListModelo() {
		
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
	protected Carta buildCarta() {
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
}
