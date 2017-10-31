/**
 * 
 */
package mvp;

import java.awt.Color;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Dylan N. Sugimoto
 *
 */
public class PersonPresenter implements Observer {
	
	private Person model;
	private IPersonDetailView view;
	private HashMap<String, Color> cores;
	
	public PersonPresenter(Person p, IPersonDetailView v) {

		cores = new HashMap<>();
		cores.put("curto", Color.RED);
		cores.put("medio", Color.GREEN);
		cores.put("longo", Color.YELLOW);
		
		this.model = p;
		this.view = v;
		view.addObserver(this);
		model.addObserver(this);
		
		view.display();
		view.updateView(cores.get(model.getClassificacao()), model.getName());
		
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(arg);
		if (o instanceof IPersonDetailView) {
			if (arg == null)
				System.exit(0);
			model.setName((String) arg);
			view.updateView(cores.get(model.getClassificacao()), model.getName());
		}
	}
	
}
