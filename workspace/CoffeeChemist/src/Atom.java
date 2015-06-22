import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Atom {
	int protons, 
		neutrons, 
		electrons;
	
	String name, 
		symbol, 
		electronConfig;
	
	Atom(int p) throws Exception {
		protons = p;
		neutrons = p;
		
		String[][] elements = loadElements();
		
		name = elements[protons - 1][1];
		symbol = elements[protons - 1][2];
		electronConfig = elements[protons - 1][3];
	}
	
	private String[][] loadElements() throws Exception {
		/* for each element in 1st dimension:
		 * [0]: atomic number
		 * [1]: name
		 * [2]: symbol
		 */
		
		//grab file directory
		URL url = Atom.class.getResource("elements.txt");
		File f_Elements = new File(url.getPath());
		
		Scanner scanElements = new Scanner(f_Elements);
		
		List<String> temp = new ArrayList<String>();
		
		while(scanElements.hasNextLine()) {
			String line = scanElements.nextLine();
			temp.add(line);
		}
		
		scanElements.close();
		
		String[] x = temp.toArray(new String[temp.size()]);
		String[][] elementsList = new String[x.length][4];
		
		for (int i = 0; i < x.length; i++) {
			String[] elementInfo = x[i].split("\\s+");
			elementsList[i] = elementInfo;
		}
		
		return elementsList;
	}
	
}
