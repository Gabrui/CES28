/**
 * LAB -3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 12/10/2017
 */
package ex4;

import java.util.HashMap;
/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Classe Escritor serve para receber o pedido do cliente e devolver uma carta.
 */
public class Escritor {

	private Idioma _idioma;
	private Pessoa _remetente;
	private Pessoa _destinatario;
	private Data _data;
	private HashMap<String,Idioma> _mapIdioma;
	
	public Escritor(Pessoa remetente, Pessoa destinatario, Data data) {
		_remetente = remetente;
		_destinatario = destinatario;
		_data = data;
		_mapIdioma = new HashMap<String,Idioma>();
	}
	//Ao escolher um idioma para carta
	//todos os formato dos campos sao daquele idioma escolhido.
	private void definePrincipalIdioma() {
		_mapIdioma.put("principal", _idioma);
		_mapIdioma.put("despedida",_idioma);
		_mapIdioma.put("pronome", _idioma);
		_mapIdioma.put("data",_idioma);
		_mapIdioma.put("end",_idioma);
		_mapIdioma.put("fone",_idioma);
		_mapIdioma.put("vocativo",_idioma);
	}
	//metodo chamado para caso o cliente queira mudar algum formato
	//de algum campo em especifico.
	private void configIdioma() {
		
		Idioma.Builder builder = new Idioma.Builder(_mapIdioma.get("principal"));
		builder.despedida(_mapIdioma.get("despedida"));
		builder.data(_mapIdioma.get("data"));
		builder.endereco(_mapIdioma.get("end"));
		builder.fone(_mapIdioma.get("fone"));
		builder.pronome(_mapIdioma.get("pronome"));
		builder.vocativo(_mapIdioma.get("vocativo"));
		_idioma = builder.build();
	}
	//Metodos para facilitar a extensao, caso outros 
	//formatos de idioma para data, por exemplo, sejam criados.
	//Assim com esse metodo o programador que extende nao precisa
	//trabalhar com as string hardcode e tem menos chance de errar.
	private void configDataMapIdioma(Idioma idiomaData) {
		
		_mapIdioma.put("data",idiomaData);
	}
	private void configDespedidaMapIdioma(Idioma idiomaDespedida) {
		
		_mapIdioma.put("despedida",idiomaDespedida);
	}
	private void configEndMapIdioma(Idioma idiomaEnd) {
		_mapIdioma.put("end",idiomaEnd);
	}
	private void configFoneMapIdioma(Idioma idiomaFone) {
		_mapIdioma.put("fone",idiomaFone);
	}
	private void configPronomeMapIdioma(Idioma idiomaPronome) {
		_mapIdioma.put("pronome",idiomaPronome);
	}
	private void configVocativoMapIdioma(Idioma idiomaVocativo) {
		_mapIdioma.put("vocativo",idiomaVocativo);
	}
	// fim dos metodos facilitadores de extensao
	public void Ingles() {
		_idioma = Ingles.INSTANCE;
		definePrincipalIdioma();
	}
	public void Portugues() {
		_idioma = Portugues.INSTANCE;
		definePrincipalIdioma();
	}
	public void configIdiomaData2Ingles() {
		configDataMapIdioma(Ingles.INSTANCE);
		configIdioma();
	}
	public void configIdiomaDespedida2Ingles() {
		configDespedidaMapIdioma(Ingles.INSTANCE);
		configIdioma();
	}
	public void configIdiomaEndereco2Ingles() {
		this.configEndMapIdioma(Ingles.INSTANCE);
		this.configIdioma();
	}
	public void configIdiomaFone2Ingles() {
		this.configFoneMapIdioma(Ingles.INSTANCE);
		this.configIdioma();
	}
	public void configIdiomaPronome2Ingles() {
		this.configPronomeMapIdioma(Ingles.INSTANCE);
		this.configIdioma();
	}
	public void configIdiomaVocativo2Ingles() {
		this.configVocativoMapIdioma(Ingles.INSTANCE);
		this.configIdioma();
	}
	public void configIdiomaData2Portugues() {
		configDataMapIdioma(Portugues.INSTANCE);
		configIdioma();
	}
	public void configIdiomaDespedida2Portugues() {
		configDespedidaMapIdioma(Portugues.INSTANCE);
		configIdioma();
	}
	public void configIdiomaEndereco2Portugues() {
		this.configEndMapIdioma(Portugues.INSTANCE);
		this.configIdioma();
	}
	public void configIdiomaFone2Portugues() {
		this.configFoneMapIdioma(Portugues.INSTANCE);
		this.configIdioma();
	}
	public void configIdiomaPronome2Portugues() {
		this.configPronomeMapIdioma(Portugues.INSTANCE);
		this.configIdioma();
	}
	public void configIdiomaVocativo2Portugues() {
		this.configVocativoMapIdioma(Portugues.INSTANCE);
		this.configIdioma();
	}
	public Carta writeCartaComercial() {
		if(_idioma == null) {
			
			throw new RuntimeException("variable Idioma not especified! "
				+ "\nPlease use Ingles or Portugues before use write method.");
		}
		
		FactoryCarta fCarta = new FactoryCarta(_remetente,_destinatario,_data,_idioma);
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
		if(_idioma == null) {
			
			throw new RuntimeException("variable Idioma not especified! "
				+ "\nPlease use Ingles or Portugues before use write method.");
		}
		FactoryCarta fCarta = new FactoryCarta(_remetente,_destinatario,_data,_idioma);
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
		if(_idioma == null) {
			
			throw new RuntimeException("variable Idioma not especified! "
				+ "\nPlease use Ingles or Portugues before use write method.");
		}
		FactoryCarta fCarta = new FactoryCarta(_remetente,_destinatario,_data,_idioma);
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
