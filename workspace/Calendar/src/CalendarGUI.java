import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.util.GregorianCalendar;



public class CalendarGUI {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel defTblModel = null;
	private int realMonth = -1;
	private int realYear = -1;
	private int realDay = -1;
	private int currentMonth = -1;
	private int currentYear = -1;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalendarGUI window = new CalendarGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CalendarGUI() {
		
		defTblModel = new DefaultTableModel();
		GregorianCalendar cal = new GregorianCalendar(); //Create calendar
		realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
		realMonth = cal.get(GregorianCalendar.MONTH); //Get month
		realYear = cal.get(GregorianCalendar.YEAR); //Get year
		currentMonth = realMonth; //Match month and year
		currentYear = realYear;
		
		initialize();
		
		
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 526, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 490, 377);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPrevious.setBounds(10, 10, 89, 23);
		panel.add(btnPrevious);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(244, 10, 89, 23);
		panel.add(btnNext);
		
		JComboBox comboBox_Month = new JComboBox();
		comboBox_Month.setBounds(105, 11, 134, 20);
		panel.add(comboBox_Month);
		
		JComboBox<String> comboBox_Year = new JComboBox<String>();
		comboBox_Year.setBounds(375, 11, 105, 20);
		for (int i = realYear - 100; i <= realYear + 100; i++) {
			   comboBox_Year.addItem(String.valueOf(i));
		}
		comboBox_Year.setSelectedItem(String.valueOf(realYear));
		panel.add(comboBox_Year);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 470, 324);
		panel.add(scrollPane);
		
		table = new JTable(defTblModel);
		scrollPane.setViewportView(table);
	}
}
