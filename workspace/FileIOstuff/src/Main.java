import java.io.*;
import java.net.URL;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
				String readFile = read("OOP_week15.txt");
				String replacedFile = replace(readFile, "dolor", "hedon");
				
				System.out.println(replacedFile);
				
				write(replacedFile, "OOP_week15.txt");
		}
		catch (IOException ex) {
			System.out.println("File not found");
		}
		catch (NullPointerException ex) {
			System.out.println("Null file name");
		}
		
	}
	
	public static String read(String fileName) throws FileNotFoundException, IOException, NullPointerException {
		FileReader readerThingy = null;
		URL f_URL = null;
		String theFile = null;
		
		
		try {
			
			if (fileName == null) {
				throw new NullPointerException();
			}
			
			f_URL = Main.class.getResource(fileName);
			readerThingy = new FileReader(f_URL.getPath());
			BufferedReader bufferThingy = new BufferedReader(readerThingy);
			StringBuilder builderThingy = new StringBuilder();
			
			String read = bufferThingy.readLine();
			
			while (read != null) {
				builderThingy.append(read);
				read = bufferThingy.readLine();
			}
			
			theFile = builderThingy.toString();
			
			readerThingy.close();
			bufferThingy.close();
			
		}
		
		finally {
			if (readerThingy != null) {
				
				readerThingy.close();
				
			}
			
		}
		
		return theFile;
		
	}

	public static String replace(String read, String original, String replaceWith) {
		
		String replaced = null;
		
		if (read != null) {
			replaced = read.replace(original, replaceWith);
		}
		
		return replaced;
		
	}

	public static void write(String fileString, String fileName) throws IOException {
		if (fileName == null || fileString == null) {
			throw new NullPointerException();
		}
		else {
			URL f_URL = Main.class.getResource(fileName);
			
			FileWriter writerThingy = new FileWriter(f_URL.getPath(), false);
			
			writerThingy.write(fileString);
			writerThingy.close();			
		}
	}
}
