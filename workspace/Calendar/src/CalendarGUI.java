import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import java.text.DateFormatSymbols;
import java.util.GregorianCalendar;



public class CalendarGUI {

	private JFrame frame;
	private JTable table;
	private JPanel panel;
	private JButton btnPrevious;
	private JButton btnNext;
	private JComboBox<String> comboBox_Month;
	private JComboBox<String> comboBox_Year;
	private JScrollPane scrollPane;
	private DefaultTableModel defTblModel = null;
	private String[] months;
	private String[] days;
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
		
	    months = new DateFormatSymbols().getMonths();
	    days = new DateFormatSymbols().getWeekdays();
		
		initialize();
		
	}

	private void initialize() {
		
		//Create body
		frame = new JFrame();
		frame.setBounds(100, 100, 526, 342);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 490, 282);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		//Create buttons
		btnPrevious = new JButton("Previous");
		initAction(btnPrevious, 0);
		btnPrevious.setBounds(10, 10, 89, 23);
		panel.add(btnPrevious);
		
		btnNext = new JButton("Next");
		initAction(btnNext, 1);
		btnNext.setBounds(244, 10, 89, 23);
		panel.add(btnNext);
		
		//Create combo boxes
		comboBox_Month = new JComboBox<String>();
		comboBox_Month.setBounds(105, 11, 134, 20);
		for (int i = 0; i < months.length - 1; i++) {
			comboBox_Month.addItem(months[i]);
		}
		comboBox_Month.setSelectedItem(months[currentMonth - 1]);
		panel.add(comboBox_Month);
		
		comboBox_Year = new JComboBox<String>();
		comboBox_Year.setBounds(375, 11, 105, 20);
		for (int i = realYear - 100; i <= realYear + 100; i++) {
			comboBox_Year.addItem(String.valueOf(i));
		}
		comboBox_Year.setSelectedItem("" + currentYear);
		panel.add(comboBox_Year);
		
		//Create calendar table
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 470, 229);
		panel.add(scrollPane);
		
		table = new JTable(defTblModel);
		scrollPane.setColumnHeaderView(table);
		
		table.setColumnSelectionAllowed(true);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.setRowHeight(38);
		defTblModel.setColumnCount(7);
		defTblModel.setRowCount(6);
		
		table.getParent().setBackground(table.getBackground());
		
		refreshCalendar();
	}
	
	public void refreshCalendar() {
		
		btnPrevious.setEnabled(true);
		btnNext.setEnabled(true);
		
		if (comboBox_Month.getSelectedIndex() == 0 && comboBox_Year.getSelectedIndex() == 0) {
			btnPrevious.setEnabled(false);
		}
		if (comboBox_Month.getSelectedIndex() == comboBox_Month.getItemCount() - 1 && comboBox_Year.getSelectedIndex() == comboBox_Year.getItemCount() - 1) {
			btnNext.setEnabled(false);
		}
		
	}
	
	public void initAction(JButton button, int btn) {
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (btn == 0) {
					
					if (comboBox_Month.getSelectedIndex() != 0) {
						
						comboBox_Month.setSelectedIndex(comboBox_Month.getSelectedIndex() - 1);
						
					}
					else {
						
						comboBox_Month.setSelectedIndex(comboBox_Month.getItemCount() - 1);
						comboBox_Year.setSelectedIndex(comboBox_Year.getSelectedIndex() - 1);
						
					}
					
				}
				else if (btn == 1) {
					
					if (comboBox_Month.getSelectedIndex() != comboBox_Month.getItemCount() - 1) {
						
						comboBox_Month.setSelectedIndex(comboBox_Month.getSelectedIndex() + 1);
						
					}
					else {
						
						comboBox_Month.setSelectedIndex(0);
						comboBox_Year.setSelectedIndex(comboBox_Year.getSelectedIndex() + 1);
						
					}
					
				}
				
				refreshCalendar();
			}
		});
		
	}
	
	public void initAction(JComboBox<String> comboBox) {
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshCalendar();
			}
		});
		
	}
	
}
