public class Atom {
	int _protons, _neutrons, _electrons;
	int _charge = 0, _valence;
	int _indexElementsList;
	String _name, _symbol, _electronConfig;
	String[] _shells;
	boolean _isIon = false, _isIsotope = false;
	
	Atom(int p) {
		createInfo(p);
		createElectrons();
		
	}
	
	Atom(int p, int charge) {
		createInfo(p);
	}
	
	private void createInfo(int p) {
		_protons = p;
		_indexElementsList = _protons - 1;
		_name = Main.elements[_indexElementsList][1];
		_symbol = Main.elements[_indexElementsList][2];
		_electronConfig = Main.elements[_indexElementsList][3];
		_shells = _electronConfig.split("-");
	}
	
	private void createElectrons() {
		int sum = 0;
		for (int i = 0; i < _shells.length; i++) {
			sum += Integer.parseInt(_shells[i]);
		}
		_electrons = sum;
	}
	
	
	
}
