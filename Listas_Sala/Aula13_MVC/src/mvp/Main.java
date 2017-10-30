package mvp;

import mvp.controller.PersonDetailControllerImpl;
import mvp.model.Person;

public class Main {
	public static void main(String[] args) {
		Person p = new Person("Rhuan");
		new PersonDetailControllerImpl(p);
	}

}

