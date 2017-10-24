package nomvc;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClockView implements Runnable {
	public ClockView() {
		this.mountDisplay();
	}

	public void update() {
		System.out.println("Hora: " + getTime());
		label.setText((String) getTime());
	}

	public String getTime() {
		String time = "";
		GregorianCalendar calendario = new GregorianCalendar();
		int h = calendario.get(GregorianCalendar.HOUR_OF_DAY);
		int m = calendario.get(GregorianCalendar.MINUTE);
		int s = calendario.get(GregorianCalendar.SECOND);
		time += ((h < 10) ? "0" : "") + h + ":";
		time += ((m < 10) ? "0" : "") + m + ":";
		time += ((s < 10) ? "0" : "") + s;
		return time;
	}

	public void mountDisplay() {
		JPanel panel = new JPanel();

		panel.add(label);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));

		label.setFont(new Font("Arial", Font.ITALIC, 25));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(panel);

		frame.setResizable(false);
		frame.setBounds(200, 200, 500, 110);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		label.setText(getTime());
	}

	@Override
	public void run() {
		while (true) {
			update();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	private JLabel label = new JLabel();
	private static JFrame frame = new JFrame("Clock :D");

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ClockView clView = new ClockView();
				Thread th = new Thread(clView);
				th.start();

			}
		});
	}

}
