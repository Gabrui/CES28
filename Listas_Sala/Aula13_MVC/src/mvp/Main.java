package mvp;

public class Main {
	public static void main(String[] args) {
		Person p = new Person("Rhuan");
		IPersonDetailView v = new PersonDetailView();
		new PersonPresenter(p, v);
	}

}

