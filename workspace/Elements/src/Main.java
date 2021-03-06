import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;


public class Main  {

	
	static String[][] elements;
	
	public static void main(String[] args) throws Exception {
		
		elements = loadElements();
		
		Atom Atom = new Atom(89);
		
		out.printf("%s\n"
				+ "protons: %d\n"
				+ "neutrons: %d\n"
				+ "electrons: %d\n\n", 
				Atom.name,
				Atom.protons,
				Atom.neutrons,
				Atom.electrons);
		
		for (int i = 0; i < Atom.shells.length; i++) {
			out.printf("electron shell %d: %s\n", i + 1, Atom.shells[i]);
		}
		
	}
	
	static String[][] loadElements() throws FileNotFoundException {
		/* for each element in 1st dimension:
		 * [0]: atomic number
		 * [1]: name
		 * [2]: symbol
		 */
		
		//grab file directory
		URL url = Main.class.getResource("elements.txt");
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
