package RefatoracaoPersonProject.v0;


public class Person {
	static int nextId=0;
	Person(){
		id = nextId++;
	}
	
	boolean participate(Project p) {
		Person[] x = p.getParticipants();
		for(int i=0; i<p.getNumberOfParticipants(); i++) {
		     if (x[i].id == this.getId()) return (true);
	     }
	    return (false);
	}
	   
	public int getId() {
	  return id;
	}
	
	int id;
	
		
	public static void main(String[] args) {
		Person[] ps = new Person[3];
		for (int i=0; i < ps.length; i++)
			ps[i] = new Person();
		
		Project pj = new Project();
		pj.setParticipants(ps);
		pj.printParticipants();
		
		Person x = new Person();
		if (x.participate(pj)) {
			System.out.println("Person "+x.id+" belongs to project");
		} else {
			System.out.println("Person "+x.id+" does not belong to project");
		}
		Person p = ps[1];
		if (p.participate(pj)) {
			System.out.println("Person "+p.id+" belongs to project");
		} else {
			System.out.println("Person "+p.id+" does not belong to project");
		}
		

	}

}
