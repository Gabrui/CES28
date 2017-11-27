package utm_v0.view;

import java.util.Observable;
import java.util.Observer;

import utm_v0.presenter.SistemaMapas;
import utm_v0.presenter.UTMAbstrata;

public class GCSAbstrata implements Observer {
	protected UTMAbstrata utm;
	protected SistemaMapas mapasAtualizados;

	public GCSAbstrata(UTMAbstrata utm) {
		this.utm = utm;
		utm.addObserver(this);
	}

	@Override
	public void update(Observable utm, Object mapa) {
		mapasAtualizados = (SistemaMapas) mapa;
	}
	
	public SistemaMapas getMapasAtualizados() {
		return mapasAtualizados;
	}

}
