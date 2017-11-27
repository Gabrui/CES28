package utm_v0.view;

import java.util.Observable;

import utm_v0.presenter.UTMAbstrata;

public class GCSConcreta extends GCSAbstrata {
	private String nome;

	public GCSConcreta(UTMAbstrata utm, String nome) {
		super(utm);
		this.nome = nome;
	}
	
	@Override
	public void update(Observable utm, Object mapa) {
		super.update(utm, mapa);
		System.out.println(nome+" recebi mapa: "+this.mapasAtualizados);
	}


}
