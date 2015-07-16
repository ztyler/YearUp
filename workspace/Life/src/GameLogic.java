import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;


public class GameLogic {
	
	static JButton[][] grid;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LifeGUI window = new LifeGUI();
					window.frame.setVisible(true);
					grid = window.grid;
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void newGeneration() {
			
		for (int y = 0; y < grid.length; y++)
			for (int x = 0; x < grid[y].length; x++)
				grid[y][x].setEnabled(false);
		
		List<JButton> birth = new ArrayList<JButton>();
		List<JButton> death = new ArrayList<JButton>();
		
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[y].length; x++) {
				
				int liveNeighbors = 0;
				
				//count living neighbors
				for (int i = -1; i < 2; i++) {
					for (int n = -1; n < 2; n++) {
						if (n == 0 && i == 0) continue;
						
						JButton btnCheck = null;
						
						try {
							btnCheck = grid[y - i][x - n];
						}
						catch (ArrayIndexOutOfBoundsException e) {
							continue;
						}
						
						if (btnCheck.getBackground().equals(LifeGUI.alive)) {
							liveNeighbors++;
						}
						
					}
					
				}
				
				//decide fate
				if (grid[y][x].getBackground().equals(LifeGUI.alive)) {
					
					if (liveNeighbors < 2 || liveNeighbors > 3) {
						
						death.add(grid[y][x]);
						
					}
					
				}
				else {
					
					if (liveNeighbors == 3) {
						
						birth.add(grid[y][x]);
						
					}
					
				}
				
			}
			
		}
		
		//update grid
		for (JButton btn : birth)
			btn.setBackground(LifeGUI.alive);
		
		for (JButton btn : death)
			btn.setBackground(null);
			
	}
	
}

