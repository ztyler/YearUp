import javax.swing.JButton;

public class Template {
	
	public static void setTemplate() {
		JButton[][] grid = LifeGUI._grid;
		
		if (LifeGUI._radioDefault.isSelected()) {
			resetGrid();
		}
		else if (LifeGUI._radioCheckerboard.isSelected()) {
			resetGrid();
			
			for (int y = 0; y < grid.length; y++) {
				for (int x = 0; x < grid[y].length; x++) {
					if (y % 2 == 0) {
						if (x % 2 != 0) {
							set(grid[y][x]);
						}
					}
					else {
						if (x % 2 == 0) {
							set(grid[y][x]);
						}
					}
				}
			}
		}
		else if (LifeGUI._radioFourBoxes.isSelected()) {
			resetGrid();
			
			for (int y = 0; y < grid.length; y++) {
				for (int x = 0; x < grid[y].length; x++) {
					if (x == 0 || y == 0) {
						set(grid[y][x]);
					}
					else if (x == grid[y].length - 1 || y == grid.length - 1) {
						set(grid[y][x]);
					}
					else if (x == (grid[y].length - 1) / 2 || y == (grid.length - 1) / 2) {
						set(grid[y][x]);
					}
				}
			}	
		}
		else if (LifeGUI._radioBorders.isSelected()) {
			resetGrid();
			
			for (int y = 0; y < grid.length; y++) {
				for (int x = 0; x < grid[y].length; x++) {
					if (x == 0 || y == 0) {
						if (x % 2 == 0 && y % 2 == 0) {
							set(grid[y][x]);
						}
					}
					else if (x == grid[y].length - 1 || y == grid.length - 1) {
						if (x % 2 != 0 && y % 2 != 0) {
							set(grid[y][x]);
						}
					}
					if (x == 1 || y == 1) {
						if (x % 2 != 0 && y % 2 != 0) {
							set(grid[y][x]);
						}
					}
					else if (x == grid[y].length - 2 || y == grid.length - 2) {
						if (x % 2 == 0 && y % 2 == 0) {
							set(grid[y][x]);
						}
					}
				}
			}
		}
		else if (LifeGUI._radioMesh.isSelected()) {
			resetGrid();
			
			for (int y = 0; y < grid.length; y++) {
				for (int x = 0; x < grid[y].length; x++) {
					if (x % 3 == 0 || y % 3 == 0) {
						set(grid[y][x]);
					}
				}
			}
		}
		else if (LifeGUI._radioFlowers.isSelected()) {
			resetGrid();
			
			for (int y = 0; y < grid.length; y++) {
				for (int x = 0; x < grid[y].length; x++) {
					if (x % 7 == 0 || y % 7 == 0) {
						set(grid[y][x]);
					}
				}
			}
		}
	}
	
	private static void set(JButton btn) {
		btn.setBackground(LifeGUI._alive);
	}
	
	static void resetGrid() {
		for (JButton[] array : LifeGUI._grid) {
			for (JButton btn : array) {
				btn.setEnabled(true);
				if (btn.getBackground() != null) {
					btn.setBackground(null);
				}
			}
		}
	}
	
}
