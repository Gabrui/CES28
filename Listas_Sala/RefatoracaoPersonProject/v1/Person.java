package RefatoracaoPersonProject.v1;


public class Person {
	
	private static int nextId=0;
	private int id;
	
	public Person() {
		id = nextId++;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Person)
			return this.id == ((Person) o).getId();
		return false;
	}
}
