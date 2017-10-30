package ref0;

import ref0.controller.PersonDetailControllerImpl;
import ref0.model.Person;

public class Main {
	public static void main(String[] args) {
		Person p = new Person("Rhuan");
		new PersonDetailControllerImpl(p);
	}

}

