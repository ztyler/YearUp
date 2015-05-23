public class Atom {
	int protons, neutrons, electrons;
	int charge = 0, valence;
	int indexElementsList;
	String name, symbol, electronConfig;
	String[] shells;
	boolean isIon = false, isIsotope = false;
	
	Atom(int p) {
		createInfo(p);
		createElectrons();
		
	}
	
	Atom(int p, int charge) {
		createInfo(p);
	}
	
	private void createInfo(int p) {
		protons = p;
		indexElementsList = protons - 1;
		name = Main.elements[indexElementsList][1];
		symbol = Main.elements[indexElementsList][2];
		electronConfig = Main.elements[indexElementsList][3];
		shells = electronConfig.split("-");
	}
	
	private void createElectrons() {
		int sum = 0;
		for (int i = 0; i < shells.length; i++) {
			sum += Integer.parseInt(shells[i]);
		}
		electrons = sum;
	}
	
	
	
}
