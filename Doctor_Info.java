package vetPetBeta;



import java.util.Set;

////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////
////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////
public class Doctor_Info{
	private String doctorName;// Name of the veterinarian
	private Set<Patient_Info.Species> speciesExperience; //Species the vet can treat
	private Set<Patient_Info.Behavior> handledBehaviors;//Specific behaviors a vet can handle
	private Set<Patient_Info.Availability> availability; //availability
	private boolean acceptsInsurance; //whether the doctor accepts insurance
	private boolean isSurgeon; //qualified to do surgries
	private boolean isDentist;// Qaulified to do dental
////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////
////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////////DOCTOR INFO////
	

////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////
////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////
	public Doctor_Info(String doctorName,Set<Patient_Info.Species> speciesExperience,Set<Patient_Info.Behavior> handledBehaviors,Set<Patient_Info.Availability> availableDays,boolean acceptsInsurance, boolean isSurgeon, boolean isDentist){
		this.doctorName=doctorName;
		this.speciesExperience= speciesExperience;
		this.handledBehaviors= handledBehaviors;
		this.availability =availableDays;
		this.acceptsInsurance= acceptsInsurance;
		this.isSurgeon= isSurgeon;
		this.isDentist= isDentist;
	}
////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////
////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////////CONSTRUCTOR////

	
////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////
////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////
	public String getDoctorName(){
		return doctorName;
	}

	public Set<Patient_Info.Species> getSupportedSpecies() {
		return speciesExperience;
	}

	public Set<Patient_Info.Behavior> getHandledBehaviors(){
		return handledBehaviors;
	}

	public Set<Patient_Info.Availability> getAvailableDays(){
		return availability;
	}

	public boolean acceptsInsurance(){
		return acceptsInsurance;
	}

	public boolean isSurgeon(){
		return isSurgeon;
	}
	
	public boolean isDentist() {
		return isDentist;
	}
////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////
////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////////GETTERS////


////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////
////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////
	public void setDoctorName(String doctorName) {
		this.doctorName= doctorName;
	}

	public void setSupportedSpecies(Set<Patient_Info.Species> speciesExperience){
		this.speciesExperience= speciesExperience;
	}

	public void setHandledBehaviors(Set<Patient_Info.Behavior> handledBehaviors){
		this.handledBehaviors=handledBehaviors;
	}

	public void setAvailableDays(Set<Patient_Info.Availability> availableDays){
		this.availability =availableDays;
	}

	public void setAcceptsInsurance(boolean acceptsInsurance){
		this.acceptsInsurance= acceptsInsurance;
	}

	public void setSurgeon(boolean isSurgeon){
		this.isSurgeon= isSurgeon;
	}
	
	public void setDentist(boolean isDentist) {
		this.isDentist=isDentist;
	}
////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////
////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////////SETTERS////

////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////
////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////////METHODS////
	
	public boolean canTreatPatient(Patient_Info patient){
		//check if emergency to override
		boolean speciesMatch =patient.isEmergency()||speciesExperience.contains(patient.getSpecies())  ||speciesExperience.contains(Patient_Info.Species.OTHER);//Check if there is a match for species and their experience
		
		boolean behaviorMatch = handledBehaviors.contains(patient.getBehavior()); //check to see if the vet can handle the animals behavior
		
		//check if available
		boolean available= false; //default is no
		if(this.availability.contains(Patient_Info.Availability.ANYDAY)||patient.getAvailability().contains(Patient_Info.Availability.ANYDAY)){ //check if anyday is present, if present then they are available
			available=true;
		}else{
	
			for(Patient_Info.Availability day : patient.getAvailability()){//Else check every day within set to see if one matches
				if(this.availability.contains(day)){
					available= true;
					break;
				}
			}
		}

		//check if surgeon or dentist
		boolean surgeryMatch=true;
		if (patient.getVisitReason()==Patient_Info.reasonForVisit.SURGERY){
			surgeryMatch = this.isSurgeon;
		}
		boolean dentistMatch=true;
		if (patient.getVisitReason()==Patient_Info.reasonForVisit.DENTAL) {
			dentistMatch=this.isDentist;
		}

		return speciesMatch && behaviorMatch && available && surgeryMatch&&dentistMatch;//if all is true then returns true for FE
	}

	
}