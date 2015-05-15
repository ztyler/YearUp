public class Atom {
	int protons, neutrons, electrons;
	int charge = 0, valence;
	int index;
	String name, symbol, electronConfig;
	boolean isIon = false, isIsotope = false;
	
	Atom(int p) {
		protons = p;
		setID();
		electrons = sumElectrons();
		if (protons != electrons) {
			isIon = true;
			charge = protons - electrons;
		}
	}
	
	private void setID() {
		index = protons - 1;
		name = Main.elements[index][1];
		symbol = Main.elements[index][2];
		electronConfig = Main.elements[index][3];
	}
	
	private int sumElectrons() {
		String[] shells = electronConfig.split("-");
		int sum = 0;
		for (int i = 0; i < shells.length; i++) {
			sum += Integer.parseInt(shells[i]);
		}
		return sum;
	}
}
