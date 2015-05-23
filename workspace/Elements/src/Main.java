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
