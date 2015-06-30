import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class NameThingy {

	private JFrame frame;
	private JLabel lblMyNameIs;
	private JLabel lblIAm;
	private JLabel lblYearUp;
	private JTextField textField_Name;
	private JTextField textField_Age;
	private JButton btnTheButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NameThingy window = new NameThingy();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NameThingy() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 219);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblMyNameIs = new JLabel("My name is");
		lblMyNameIs.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMyNameIs.setBounds(12, 16, 113, 16);
		frame.getContentPane().add(lblMyNameIs);
		
		lblIAm = new JLabel("I am");
		lblIAm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIAm.setBounds(69, 44, 56, 16);
		frame.getContentPane().add(lblIAm);
		
		lblYearUp = new JLabel("I am a student of Year Up!");
		lblYearUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblYearUp.setBounds(12, 76, 258, 22);
		frame.getContentPane().add(lblYearUp);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(137, 13, 133, 22);
		frame.getContentPane().add(textField_Name);
		textField_Name.setColumns(10);
		
		textField_Age = new JTextField();
		textField_Age.setColumns(10);
		textField_Age.setBounds(137, 41, 133, 22);
		frame.getContentPane().add(textField_Age);
		
		String btnTextDefault = "Who are you?";
		
		btnTheButton = new JButton(btnTextDefault);
		btnTheButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				if (btnTheButton.getText() == btnTextDefault) {
					textField_Name.setText("Zachary Tyler");
					textField_Age.setText("22");
					btnTheButton.setText("Clear Me");
				}
				else {
					textField_Name.setText(null);
					textField_Age.setText(null);
					btnTheButton.setText(btnTextDefault);
				}
				
				
			}
		});
		btnTheButton.setBounds(12, 111, 258, 50);
		frame.getContentPane().add(btnTheButton);
		

	}
}
