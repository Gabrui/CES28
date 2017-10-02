package Q3.refatorado;


public class Alarm {
	private final double LowPressureThreshold = 17;
	private final double HighPressureThreshold = 21;

	private ISensor _sensor;
	private boolean _alarmOn = false; // PEQUENA REFATORAÇÃO PARA PRESERVAR ATRIBUTO INTERNO

	public Alarm (ISensor sensor) {
		this._sensor = sensor;
	}

	public void check() {
		double psiPressureValue = _sensor.popNextPressurePsiValue();

		if (isPressureOffChart(psiPressureValue)) { // PEQUENA REFATORAÇÃO
			_alarmOn = true;
		}
	}

	// PEQUENA REFATORAÇÃO PARA DEIXAR O CÓDIGO MAIS LEGÍVEL
	private boolean isPressureOffChart(double psiPressureValue) {
		return psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue;
	}

	public boolean isAlarmOn() {
		return _alarmOn; 
	}
	
	/**
	 * Permite que um agente externo desligue o alarme.
	 */
	public void turnOffAlarm() { // FAZ PARTE DA PEQUENA REFATORAÇÃO
		this._alarmOn = false;
	}
	
}
