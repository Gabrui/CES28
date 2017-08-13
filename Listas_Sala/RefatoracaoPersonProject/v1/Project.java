package RefatoracaoPersonProject.v1;

import java.util.*;


public class Project {

	private Vector<Person> participants;
	
	public Project() {
		participants = new Vector<Person>();
	}
	
	public Vector<Person> getParticipants() { 
		return (Vector<Person>) Collections.unmodifiableList(participants);
	}
	
	public int getNumberOfParticipants() { 
		return participants.size(); 
	}
	
	public void addParticipant(Person p) { 
		if (p == null)
			throw new NullPointerException("O ponteiro não deveria ser nulo");
		participants.addElement(p);
	}
	
	public boolean hasParticipante(Person p) {
		return this.participants.contains(p);
	}
	
	@Override
	public String toString() {
		if (participants.isEmpty()) 
			return "Project has no person";
		String resposta = "Project has person(s): ";
		for (Person p : participants)
			resposta += p.getId()+", ";
		return resposta;
	}
	
	
	
}
