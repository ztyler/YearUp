
public class Main {

	public static void main(String[] args) {
		
		Worker dude = new Worker();
		dude.doWork();
		
		Worker drDude = new Doctor();
		drDude.doWork();
		
		Worker smarterDrDude = new Surgeon();
		smarterDrDude.doWork();
		
		Worker dude_AttorneyInLaw = new Lawyer();
		dude_AttorneyInLaw.doWork();
		
		Worker smartDude = new Programmer();
		smartDude.doWork();
		
		Worker kindaSmartDude = new WebProgrammer();
		kindaSmartDude.doWork();

	}
}