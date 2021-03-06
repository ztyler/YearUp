
public class ArraySearch {

	public static void main(String[] args) {
		int[] array = {85, 29, 34, 110, 43, 34};
		
		simpleSearch(array, 34);
		simpleSearch(array, 35);
		
		countQuery(array, 34);
		countQuery(array, 35);
		countQuery(array, 29);
	}
	
	static void simpleSearch(int[] array, int query) {
		if (array != null) {
			int i;
			for (i = 0; i < array.length; i++) {
				if (array[i] == query) {
					
					System.out.printf("Found %d in array[%d]\n\n", query, i);
					break;
				}
			}
			if (i == array.length) {
				System.out.println(query + " not found\n");
			}
			
		}
		
	}
	
	static void countQuery(int[] array, int query) {
		int count = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] == query) {
				count++;
			}
		}
		
		if (count == 1) {
			System.out.printf("There is 1 occurance of %d\n\n", query);
		}
		else {
			System.out.printf("There are %d occurances of %d\n\n", count, query);
		}
		
	}

}
