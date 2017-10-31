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

@SuppressWarnings("serial")
public class PersonDetailView extends IPersonDetailView implements WindowListener {

	public PersonDetailView() {
		this.createUI();
		this.bindUI();
	}

	private void createUI() {
		pannel.setLayout(new BoxLayout(pannel, BoxLayout.Y_AXIS));
		
		this.label = new JLabel();
		pannel.add(label, BorderLayout.NORTH);
	
		this.nameTextField = new JTextField();
		pannel.add(nameTextField);
		
		this.changeButton = new JButton(LABEL_CHANGE_BUTTON);
		pannel.add(changeButton);
	}
	
	private void bindUI() {
		this.changeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PersonDetailView.this.setChanged();
				PersonDetailView.this.notifyObservers(PersonDetailView.this.getNameFromTextField());
			}
		});
	}
	
	@Override
	public void updateView(Color cor, String nome) {
		this.label.setText(LABEL + nome);
		this.label.setForeground(cor);
	}
	
	@Override
	public String getNameFromTextField() {
		System.out.println("getNameFromTextField");
		return nameTextField.getText();
	}
	
	@Override
	public void display() {
		if (this.frame == null) {
			this.frame = new JFrame() {
				{
					setTitle(FRAME_TITLE );
					setLocationRelativeTo(null);
					setContentPane(PersonDetailView.this.pannel);
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
		PersonDetailView.this.setChanged();
		this.notifyObservers();
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

	private static final String LABEL = "The person name is ";
	private static final String LABEL_CHANGE_BUTTON = "Change";
	private static final String FRAME_TITLE = null;
	
	private JPanel pannel = new JPanel();

	private JLabel label;
	private JTextField nameTextField;
	private JButton changeButton;
	private JFrame frame;
	
}
