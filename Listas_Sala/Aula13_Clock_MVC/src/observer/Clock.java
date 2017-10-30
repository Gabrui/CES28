package observer;

import java.util.GregorianCalendar;
import java.util.Observable;

public class Clock extends Observable {

	private String time = "";
	
	public Clock() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					updateTime();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();;
	}
	
	public String updateTime() {
		time = "";
		GregorianCalendar calendario = new GregorianCalendar();
		int h = calendario.get(GregorianCalendar.HOUR_OF_DAY);
		int m = calendario.get(GregorianCalendar.MINUTE);
		int s = calendario.get(GregorianCalendar.SECOND);
		time += ((h < 10) ? "0" : "") + h + ":";
		time += ((m < 10) ? "0" : "") + m + ":";
		time += ((s < 10) ? "0" : "") + s;
		setChanged();
		this.notifyObservers(time);
		return time;
	}
	
	public String getTime() {
		return time;
	}
	
}
