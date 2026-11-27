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
}
