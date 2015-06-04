import static java.lang.System.out;

public class Main {

	public static void main(String[] args) {
		out.println(helloName("Zach"));
		out.println(makeOutWord("<<>>", "Zach"));
		out.println(firstHalf("WooHoo"));

	}
	
	static String helloName(String name) {
		String newString = "Hello " + name + "!";
		return newString;
	}
	
	static String makeOutWord(String out, String word) {
		String newString = out.substring(0, 2) + word + out.substring(out.length() - 2, out.length());
		return newString;
	}
	
	static String firstHalf(String word) {
		word = word.substring(0, word.length()/2);
		return word;
	}

}	
