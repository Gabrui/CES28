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
		// É Singleton, não tem como dar new, apenas getInstance().
		UTMAbstrata utm = UTMConcreta.getInstance();
		
		// Crio os 3 Drones
		DroneAbstrato d1 = new DroneConcreto(utm, 1, "Drone 1");
		DroneAbstrato d2 = new DroneConcreto(utm, 5, "Drone 2");
		DroneAbstrato d3 = new DroneConcreto(utm, 13, "Drone 3");
		
		// Crio os 3 GCS
		GCSAbstrata g1 = new GCSConcreta(utm, "Estação 1");
		GCSAbstrata g2 = new GCSConcreta(utm, "Estação 2");
		GCSAbstrata g3 = new GCSConcreta(utm, "Estação 3");
	}

}
