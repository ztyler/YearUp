import static java.lang.System.out;

public class Worker {
	
	protected static String work = null;
	
	Worker() {
		work = "I worked.";
	}
	
	protected void doWork() {
		out.println(work);
	}
	
}
