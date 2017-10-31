package mvp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ref0.model.Person;
import ref0.model.Person.PersonListener;

@SuppressWarnings("serial")
public class PersonDetailView extends JPanel implements WindowListener, IPersonDetailView {

	public PersonDetailView() {
		this.createUI();
		this.bindUI();
		this.populateView();
	}

	private void createUI() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.label = new JLabel();
		add(label, BorderLayout.NORTH);
	
		this.nameTextField = new JTextField();
		add(nameTextField);
		
		this.changeButton = new JButton(LABEL_CHANGE_BUTTON);
		add(changeButton);
	}
	
	private void bindUI() {
		this.getPerson().addListener(this);
		this.changeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				_controller.changedButtonPressed();
			}
		});
	}
	
	private void populateView() {
		Color cor;
		String classificacao = this.getPerson().getClassificacao();
		if (classificacao.equals("curto"))
			cor = Color.RED;
		else if (classificacao.equals("medio"))
			cor = Color.GREEN;
		else cor = Color.YELLOW;
		if (nameIsNonNullAndNonVoidString()) {
			this.label.setText(LABEL + this.getPerson().getName());
			this.label.setForeground(cor);
		}
		else this.label.setText(LABEL + "...");
	}
	
	@Override
	public String getNameFromTextField()
	{
		System.out.println("\ngetNameFromTextField");
		return nameTextField.getText();
	}

	@Override
	public void onPersonNameChanged() {
		this.populateView();
	}
	
	@Override
	public void display() {
		if (this.frame == null) {
			this.frame = new JFrame() {
				{
					setTitle(FRAME_TITLE );
					setLocationRelativeTo(null);
					setContentPane(PersonDetailView.this);
					setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					addWindowListener(PersonDetailView.this);
					pack();
				}
			};
		}

		this.frame.setVisible(true);
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		this.getController().windowClosed();
	}
	
	@Override
	public void windowActivated(WindowEvent arg0) {
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
	}
	
	protected Person getPerson() {
		return _person;
	}

	protected void setPerson(Person person) {
		_person = person;
	}

	protected PersonDetailViewListener getController() {
		return _controller;
	}

	@Override
	public void setController(PersonDetailViewListener controller) {
		_controller = controller;
	}

	protected Boolean nameIsNonNullAndNonVoidString()
	{	if ((this.getPerson().getName() != null) & (this.getPerson().getName() != ""))
				return true;
		return false;
	}

	private static final String LABEL = "The person name is ";
	private static final String LABEL_CHANGE_BUTTON = "Change";
	private static final String FRAME_TITLE = null;
	
	private JPannel pannel;
	
	private Person _person;
	private PersonDetailViewListener _controller;

	private JLabel label;
	private JTextField nameTextField;
	private JButton changeButton;
	private JFrame frame;
}
