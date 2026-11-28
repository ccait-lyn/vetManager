import java.io.FileNotFoundException;
import java.util.Set;

public class Veternarian_Aid_BE {
	// Initializes a new record for patients.
	private GenLL<Patient_Info> patientRecords;
	
	private GenLL<Doctor_Info> doctorRecords;

	public Veternarian_Aid_BE()
	{
		patientRecords = new GenLL<>();
		
	    try 
	    {
	        doctorRecords = DoctorFileHandler.loadDoctors();
	    } catch (FileNotFoundException e) {
	        System.out.println("Error loading doctors.");
	        doctorRecords = new GenLL<>();
	    }
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
	
	// doctor file handling and list handling
	
	public void saveDoctorRecords() throws FileNotFoundException 
	{
	    DoctorFileHandler.saveDoctors(doctorRecords);
	}
	
	public void addDoctor(Doctor_Info doctor) throws FileNotFoundException 
	{
	    doctorRecords.add(doctor);
	    saveDoctorRecords();
	}
	
	public boolean removeDoctor(String doctorName) throws FileNotFoundException {

	    for (int i = 0; i < doctorRecords.size(); i++) {

	        Doctor_Info doctor = doctorRecords.get(i);

	        if (doctor.getDoctorName().equalsIgnoreCase(doctorName)) {

	            doctorRecords.remove(doctor);
	            DoctorFileHandler.saveDoctors(doctorRecords);
	            return true;
	        }
	    }

	    return false;
	}
	
	
}
