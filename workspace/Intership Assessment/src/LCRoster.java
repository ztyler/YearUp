
import static java.lang.System.out;

public class LCRoster {
	
	private String m_lcName;
	private int m_lcID;
	private String[] m_students;
	
	LCRoster(int learningCommunityID, String learningCommunityName) {
		out.println("Creating new Learning Community...");
		setName(learningCommunityName);
		setID(learningCommunityID);
	}
	
	public void printInfo() {
		out.printf("LC NAME: %s\n", getName());
		out.printf("LC ID: %d\n\n", getID());
		if (m_students != null) {
			out.println("ENROLLED STUDENTS:");
			for (int i = 0; i < m_students.length; i++) {
				out.println(m_students[i]);
			}
		}
		else {
			out.println("NO ENROLLED STUDENTS");
		}
		out.println(); //for cleaner output
	}
	
	public void inputStudentList(String[] inputList) {
		out.println("Creating student list...");
		
		if (inputList != null) {
			
			//check array for null slots
			int nullCount = 0;
			
			for (int i = 0; i < inputList.length; i++) {
				if (inputList[i] == null) {
					nullCount++;
				}
			}
			
			out.printf("Null entries: %d\n", nullCount);
			out.printf("Adding %d new entries\n\n", (inputList.length - nullCount));
			
			m_students = new String[inputList.length - nullCount];
			
			//add non-null slots to array
			for (int i = 0, n = 0; i < inputList.length; i++) {
				if (inputList[i] != null) {
					m_students[n] = inputList[i];
					n++;
				}
			}
			
		}
		else {
			out.print("NULL ARRAY STUPID\n\n");
		}
	}
	
	public String getName() {
		return m_lcName;
	}
	
	public int getID() {
		return m_lcID;
	}
	
	public String[] getStudents() {
		return m_students;
	}
	
	private void setName(String learningCommunityName) {
		m_lcName = learningCommunityName;
	}
	
	private void setID(int learningCommunityID) {
		m_lcID = learningCommunityID;
	}
}
