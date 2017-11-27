package utm_v0;

import utm_v0.model.DroneAbstrato;
import utm_v0.model.DroneConcreto;
import utm_v0.presenter.UTMAbstrata;
import utm_v0.presenter.UTMConcreta;
import utm_v0.view.GCSAbstrata;
import utm_v0.view.GCSConcreta;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		UTMAbstrata utm = UTMConcreta.getInstance();
		
		DroneAbstrato d1 = new DroneConcreto(utm);
		DroneAbstrato d2 = new DroneConcreto(utm);
		DroneAbstrato d3 = new DroneConcreto(utm);
		
		GCSAbstrata g1 = new GCSConcreta(utm);
		GCSAbstrata g2 = new GCSConcreta(utm);
		GCSAbstrata g3 = new GCSConcreta(utm);
	}

}
