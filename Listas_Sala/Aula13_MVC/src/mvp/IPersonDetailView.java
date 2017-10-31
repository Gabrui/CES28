package mvp;

import java.util.Observable;
import java.util.Observer;

public interface IPersonDetailView {
	public abstract String getNameFromTextField();
	public abstract void display();
	public abstract void setPresenter(Observer controller);
}
