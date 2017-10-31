package ref0.view;

public interface IPersonDetailView {
	public String getNameFromTextField();
	public void display();
	public void setController(PersonDetailViewListener controller);
}
