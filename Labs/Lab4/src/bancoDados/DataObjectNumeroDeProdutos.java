package bancoDados;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DataObjectNumeroDeProdutos implements DataObject{

	 HashMap<String,Imposto> _listImpostos;
	protected DataObjectNumeroDeProdutos() {
		_listImpostos = new HashMap<String,Imposto>();
		Imposto impf = new ImpostoFruta();
		Imposto impp = new ImpostoPao();
		Imposto impv = new ImpostoVegetais();
		_listImpostos.put(impf.id(),impf);
		_listImpostos.put(impp.id(), impp);
		_listImpostos.put(impv.id(), impv);
	}
	@Override
	public List<Imposto> getAllImposto() {
		LinkedList<Imposto> l = new LinkedList<Imposto>();
		l.addAll(_listImpostos.values()); //Poderia ter tido o cuidado de clonar cada um
		//mas isso eh soh um exemplo simples de implementacao
		return l;
	}

	@Override
	public Imposto imposto(String NA) {
		//Poderia-se tomar o cuidado de entreguar uma copia
		return _listImpostos.get(NA);
	}

	@Override
	public void updateImposto(Imposto imp) {
		_listImpostos.get(imp.id()).setRealimentacao(imp.getRealimentacao());
	}

}
