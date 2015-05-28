
public class ArraySearch {

	public static void main(String[] args) {
		int[] array = {85, 29, 34, 110, 43};

		simpleSearch(array, 34);
		simpleSearch(array, 35);
	}
	
	static void simpleSearch(int[] array, int query) {
		if (array != null) {
			
			System.out.printf("Searching for %d...\n", query);
			for (int i = 0; i < array.length; i++) {
				if (array[i] == query) {
					
					System.out.printf("Found %d in array[%d].\n\n", query, i);
					break;
				}
				
				if (i == array.length - 1) {
					
					System.out.println(query + " not found");
					
				}
				
			}
			
		}
		
	}

}
