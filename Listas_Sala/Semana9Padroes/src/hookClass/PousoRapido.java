package hookClass;

public class PousoRapido extends EstrategiasPouso {
	
	@Override
	protected int dadosInternos(int dado) {
		return dado - 20;
	}

}
