
public class Intro {

	public static void main(String[] args) {
		
		int sum = Add(1, 2);
		int otherSum = Add(1, 2, 3);
		String foobar = Add("foo", "bar");
		
		System.out.println(sum);
		System.out.println(otherSum);
		System.out.println(foobar);

	}
	
	static int Add(int n1, int n2) {
		return n1 + n2;
	}
	
	static int Add(int n1, int n2, int n3) {
		return Add(n1, n2) + n3;
	}
	
	static String Add(String s1, String s2) {
		return s1 + s2;
	}

}
