import java.util.Set;

public class Veternarian_Aid_BE {
	// Initializes a new record for patients.
	private GenLL<Patient_Info> patientRecords;

	public Veternarian_Aid_BE()
	{
		patientRecords = new GenLL<>();
	}
	
	// Returns all stored patient records.
	public GenLL<Patient_Info> getPatientRecords()
	{
		return patientRecords;
	}

	//Checks for insurance
	public boolean insuranceCheck(boolean insurance)
	{
		return insurance;
	}

	//Adds a new patient
	public void addPatient(String newOwnerName, String newPatientName, boolean anInsurance,
			Species newSpecies, Behavior newBehavior, boolean isVaccinated,
				reasonForVisit newReason, boolean isEmergency, Set<Availability> anAvailability)
	{
		Patient_Info newPatient = new Patient_Info(newOwnerName, newPatientName, anInsurance, newSpecies,
				newBehavior, isVaccinated, newReason, isEmergency, anAvailability);

		patientRecords.add(newPatient);
	}
	//Adds appointment to queue and records (if not already done)
	public void addAppointment(String ownerName,String patientName, boolean insurance,
			Species species,Behavior behavior,boolean vaccinated, 
			reasonForVisit visitReason,boolean emergency, Set<Availability> availability)
	{
			Patient_Info newPatient = new Patient_Info(newOwnerName, newPatientName, anInsurance, newSpecies,
				newBehavior, isVaccinated, newReason, isEmergency, anAvailability);

			boolean exist=false;//record doesnt exist until proven to exist
			for(int i=0; i<patientRecords.size();i++)
			{
				if(patientRecords.get(i).equals(new Patient)){//checks reocrds with current patient to see if matching data
					exist=true;
					break;
				}
			}
			if(!exists){
				patientRecords.add(newPatient);
			}
		appointmentQueue.addToQueue(newPatient);//adds to appointment queue
	}
	//View all appointments for the day
	public void viewCurrentAppointments(){
		appointmentQueue.displayAppointments();
	}

	//remove appointment
	public Patient_Info removeNextAppointment(){
		return appointmentQueue.removeFromQueue();
	}

	
}
