import java.util.Arrays;

import static java.lang.System.out;

public class Anagram {

	public static void main(String[] args) {
		isAnagram(null, "meh");
		
		isAnagram("Blah", "hhAb");
		
		isAnagram("dog", "God");
	}
	
	static void isAnagram(String wordOne, String wordTwo) {
		if (wordOne != null && wordTwo != null) {
			if (wordOne.length() == wordTwo.length()) {
				boolean isAnagram = true;
				wordOne = wordOne.toUpperCase();
				wordTwo = wordTwo.toUpperCase();
				
				char[] arrayOne = wordOne.toCharArray();
				char[] arrayTwo = wordTwo.toCharArray();
				
				Arrays.sort(arrayOne);
				Arrays.sort(arrayTwo);
				
				for (int i = 0; i < arrayOne.length; i++) {
					if (arrayOne[i] != arrayTwo[i]) {
						isAnagram = false;
						break;
					}
				}
				
				if (isAnagram) {
					out.println("totally an anagram.");
				}
				else {
					out.println("so totally not an anagram.");
				}
				
			}
			
		}
		else {
			out.println("Null value!");
		}
		
	}
		
}
