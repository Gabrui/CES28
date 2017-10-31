package ref0.controller;

import ref0.model.Person;
import ref0.view.IPersonDetailView;
import ref0.view.PersonDetailView;
import ref0.view.PersonDetailViewListener;

public class PersonDetailControllerImpl implements PersonDetailViewListener {

	public PersonDetailControllerImpl(Person person)
	{
		this.setModel(person);
		this.setView(person); 
	}
	
	public PersonDetailControllerImpl(Person person, IPersonDetailView view)
	{
		this.setModel(person);
		this.setView(person, view); 
	}

	@Override
	public void changedButtonPressed() {
		System.out.println("changedButtonPressed");
		final String newName = _view.getNameFromTextField();
		
		if (isNotEmpty(newName))
		{	
			this.getModel().setName(newName);
		}
	}
	
	@Override
	public void windowClosed() {
		System.exit(0);
	}
	
	protected IPersonDetailView getView() {
		return _view;
	}
	
	protected void setView(Person person){
		_view = new PersonDetailView(person, this);
		this.getView().display();
	}
	
	protected void setView(Person person, IPersonDetailView view){
		_view = view;
		this.getView().display();
	}
	
	protected Person getModel() {
		return _model;
	}

	protected void setModel(Person model) {
		_model = model;
	}
	
	private Boolean isNotEmpty(String s){
		return !s.trim().isEmpty();
	}

	private Person _model;
	private IPersonDetailView _view;
}
