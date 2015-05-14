public class Atom {
	int protons, neutrons, electrons, charge;
	String name, symbol, electronConfig;
	boolean isIon = false, isIsotope = false;
	
	Atom(int p) {
		protons = p;
		electrons = p;
		charge = 0;
		
		setID();
	}
	
	private void setID() {
		int aNum = protons - 1;
		name = Main.m_elements[aNum][1];
		symbol = Main.m_elements[aNum][2];
		electronConfig = Main.m_elements[aNum][3];
	}
}
