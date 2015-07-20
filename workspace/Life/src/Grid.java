import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class Grid {
	
	private int y = 25;
	private int x = 25;
	private JButton[][] grid;
	private Color alive = new Color(50, 200, 50);
	
	Grid() {
		build();
	}
	
	Grid(int num) {
		y = num;
		x = num;
		build();
	}
	
	Grid(int y, int x) {
		this.y = y;
		this.x = x;
		build();
	}
	
	public int getY() {
		return y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getSize() {
		return y * x;
	}
	
	public void enableGrid(boolean option) {
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[y].length; x++) {
				JButton btn = grid[y][x];
				if (btn.isEnabled() == option) {
					continue;
				}
				
				btn.setEnabled(false);
				
			}
		}
	}
	
	private void build() {
		grid = new JButton[y][x];
		
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[y].length; x++) {
				JButton btn = grid[y][x];
				
				ActionListener gridBtnAction = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btn.setEnabled(false);
						btn.setBackground(alive);
					}
				};
				btn.addActionListener(gridBtnAction);
				
			}
		}
	}
	
	
}
