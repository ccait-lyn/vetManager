package vetPetBeta;
import java.util.Set;


////PATIENT INFO////////PATIENT INFO////////PATIENT INFO////////PATIENT INFO////////PATIENT INFO////////PATIENT INFO////
////PATIENT INFO////////PATIENT INFO////////PATIENT INFO////////PATIENT INFO////////PATIENT INFO////////PATIENT INFO////
public class Patient_Info {
	private String ownerName; //Actual Owner of pet, and the name attached insurance
	private String patientName;//The pet's name
	private boolean insurance;//Insurance, if they have insurance it will provide them with broader options of vets
	private Species species; //Animal Type
	private Behavior behavior;//behavior of animal
	private boolean vaccinated;//If the animal is up to date
	private reasonForVisit visitReason; //Reason for visit to flag certain methods or checks
	private boolean emergency;// emergency or non-emergency (if emergency, then will overide availabilty check
	private Set<Availability> availability;
	public enum Species{
		DOG,
		CAT,
		BIRD,
		REPTILE,
		RODENT,
		OTHER
	}
	
	public enum Behavior{
		Aggresive, //Will need 2 vets to handle
		Docile,
		Submissive,
		Territorial, //Will need a vet who can handle territorial animals
		Hyper, //Will need a vet who can handle Hyper Animals
		Social
	}
	public enum reasonForVisit{
		CHECK_UP, //CHECKS: Availabilty , and Species Speciality, behavior
		VACCINATION,//CHECKS: Availabilty , and Species Speciality, Behavior
		PARASITE, //CHECKS: Availabilty , and Species Speciality, Behavior
		BEHAVIOR,//CHECKS: Availabilty , and Species Speciality, Speciality Field, behavior
		
		//BEHAVIOR IS NOT ASKED FOR DENTAL, SURGERY, OR INJURY DUE TO IMPLIED SEDATION
		DENTAL, //CHECKS: Availabilty , and Species Speciality, Speciality Field 
		SURGERY, //CHECKS: Availabilty of 2 vets, and Species Speciality, Speciality Field (Will ask if EMERGENCY)
		INJURY,//CHECKS: Availabilty , and Species Speciality,  (WILL ASK IF BITE, if bitten it will check Vaccination,
		//if no Vaccination history will set to EMERGENCY and will force vaccine and quarintine.
		//If Injury is not a bite, it will ask if Emergency
		
		
		OTHER//CHECKS: Availabilty , and Species Speciality, behavior
	}

	public enum Availability{
		/*Availabiltiy is used to pair with the best Veternarian for their needs
		 *  and if one of the days match with the other it will schedule
		 *  if multiple days are aligned the, there should be a drop down of available options
		 *  */
		MONDAY,
		TUESDAY,
		WEDNESDAY,
		THURSDAY,
		FRIDAY,
		SATURDAY,
		SUNDAY,
		ANYDAY//DEFAULT
	}
////PATIENT INFO////////PATIENT INFO////////PATIENT INFO////////PATIENT INFO////////PATIENT INFO////////PATIENT INFO////
////PATIENT INFO////////PATIENT INFO////////PATIENT INFO////////PATIENT INFO////////PATIENT INFO////////PATIENT INFO////

	
////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////
////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////
	public Patient_Info(String ownerName, String patientName, boolean insurance, Species species,Behavior behavior, boolean vaccinated, reasonForVisit visitReason, boolean emergency,Set<Availability> availability){
		this.ownerName=ownerName;
		this.patientName=patientName;
		this.species=species;
		this.behavior=behavior;
		this.vaccinated=vaccinated;
		this.visitReason=visitReason;
		this.emergency=emergency;
		this.availability=availability;
		
	}
////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////
////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////

	
////GETTER////////GETTER////////GETTER////////GETTER////////GETTER////////GETTER////////GETTER////////GETTER////////GETTER////////GETTER////
////GETTER////////GETTER////////GETTER////////GETTER////////GETTER////////GETTER////////GETTER////////GETTER////////GETTER////////GETTER////
	public String getOwnerName() {
		return ownerName;
	}

	public String getPatientName(){
		return patientName;
	}


	public Species getSpecies(){
		return species;
	}
	
	public Behavior getBehavior() {
		return behavior;
	}
	
	public boolean getVaccinated() {
		return vaccinated;
	}
	
	public boolean getInsurance(){
		return insurance;
	}
	public reasonForVisit getVisitReason(){
		return visitReason;
	}

	public boolean isEmergency(){
		return emergency;
	}

	public Set<Availability> getAvailability(){
		return availability;
	}
////GETTER////////GETTER////////GETTER////////GETTER////////GETTER////////GETTER////////GETTER////////GETTER////////GETTER////////GETTER////
////GETTER////////GETTER////////GETTER////////GETTER////////GETTER////////GETTER////////GETTER////////GETTER////////GETTER////////GETTER////

	
////SETTER////////SETTER////////SETTER////////SETTER////////SETTER////////SETTER////////SETTER////////SETTER////////SETTER////////SETTER////
////SETTER////////SETTER////////SETTER////////SETTER////////SETTER////////SETTER////////SETTER////////SETTER////////SETTER////////SETTER////
	//I added settersfor name and such for possibly a patient info manager almost like a account, though a lot of data shouldnt change, I put the backend tools if needeeed
	public void setOwnerName(String ownerName){
		this.ownerName= ownerName;
	}

	public void setPatientName(String patientName){
		this.patientName= patientName;
	}
	
	public void setSpecies(Species species) {
		this.species=species;
	}
	
	public void setBehavior(Behavior behavior) {
		this.behavior=behavior;
	}
	
	public void setVaccinated(boolean vaccinated){
		this.vaccinated=vaccinated;
	}
	
    public void setInsurance(boolean insurance){
        this.insurance= insurance;
    }


	public void setVisitReason(reasonForVisit visitReason){
		this.visitReason =visitReason;
	}

	public void setEmergency(boolean emergency){
		this.emergency =emergency;
	}

	public void setAvailability(Set<Availability> availability){
		this.availability=availability;
	}
////SETTER////////SETTER////////SETTER////////SETTER////////SETTER////////SETTER////////SETTER////////SETTER////////SETTER////////SETTER////
////SETTER////////SETTER////////SETTER////////SETTER////////SETTER////////SETTER////////SETTER////////SETTER////////SETTER////////SETTER////

	
////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS/////
////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS/////

	public boolean requiresTwoVets(){ //iff surgery or animal  is aggresive 2 vets will be required
		return (this.visitReason==reasonForVisit.SURGERY)|| (this.behavior == Behavior.Aggresive);
	}
}
