package RefatoracaoPersonProject.v0;
class Project {
 
  private Person[] participants;
  
  public Person[] getParticipants() { return participants; }
  public int getNumberOfParticipants() { return participants.length; }
  public void setParticipants(Person[] p) { participants=p; }

  public void printParticipants() {
	  for (int i=0; i < participants.length; i++)
		  System.out.println("project has person "+participants[i].id);
  }
}

