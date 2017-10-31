package mvp;

import java.awt.Color;
import java.util.Observable;

public abstract class IPersonDetailView extends Observable {
	public abstract String getNameFromTextField();
	public abstract void display();
	public abstract void updateView(Color cor, String nome);
}
