public class Atom {
	int protons, neutrons, electrons, charge;
	String name, symbol;
	boolean isIon = false, isIsotope = false;
	
	
	
	//Regular
	Atom(int p) {
		protons = p;
		electrons = p;
		charge = 0;
		
		setID();
	}
	
	//Ion
	Atom (int p, int e) {
		protons = p;
		electrons = e;
		charge = protons - electrons;
		
		if (charge != 0) {
			isIon = true;
		}
		
		setID();
	}
	
	private void setID() {
		name = Main.m_elements[protons - 1][1];
		symbol = Main.m_elements[protons - 1][2];
	}
}
