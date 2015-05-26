import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;


public class Main  {

	
	static String[][] elements;
	
	public static void main(String[] args) throws Exception {
		
		elements = loadElements();
		
		Atom atom1 = new Atom(27);
		
		out.printf("%s\n"
				+ "protons: %d\n"
				+ "neutrons: %d\n"
				+ "electrons: %d\n\n", 
				atom1.name,
				atom1.protons,
				atom1.neutrons,
				atom1.electrons);
		
		for (int i = 0; i < atom1.shells.length; i++) {
			out.printf("electron shell %d: %s\n", i + 1, atom1.shells[i]);
		}
		
	}
	
	static String[][] loadElements() throws Exception {
		/* for each element in 1st dimension:
		 * [0]: atomic number
		 * [1]: name
		 * [2]: symbol
		 */
		
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
		String[][] y = new String[x.length][4];
		
		for (int i = 0; i < x.length; i++) {
			String[] elementInfo = x[i].split("\\s+");
			y[i] = elementInfo;
		}
		
		return y;
	}
}
