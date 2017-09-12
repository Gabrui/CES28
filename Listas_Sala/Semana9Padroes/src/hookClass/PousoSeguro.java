package hookClass;

public class PousoSeguro extends EstrategiasPouso {
	
	@Override
	protected int dadosInternos(int dado) {
		return dado + 100;
	}

}
