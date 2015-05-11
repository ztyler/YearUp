public class Atom {
	int protons, neutrons, electrons, charge;
	String name, symbol;
	boolean isIon = false, isIsotope = false;
	
	Atom(int p, int n, int e) {
		protons = p;
		neutrons = n;
		electrons = e;
		SetID();
		charge = protons - electrons;
		if (charge != 0) isIon = true;
	}
	
	private void SetID() {
		if (protons == 1) {
			name = "hydrogen";
			symbol = "H";
			if (neutrons > 0) {
				isIsotope = true;
			}
		}
	}
}
