import java.util.Set;

////PATIENT INFO

public class Patient_Info {
	private String ownerName; //Actual Owner of pet, and the name attached insurance
	private String patientName;//The pet's name	
	
	private boolean insurance;//Insurance, if they have insurance it will provide them with broader options of vets
	private boolean emergency;// emergency or non-emergency (if emergency, then will overide availabilty check
	private boolean vaccinated;//If the animal is up to date
	
	private Species species; //Animal Type
	private Behavior behavior;//behavior of animal
	private reasonForVisit visitReason; //Reason for visit to flag certain methods or checks
	private Set<Availability> availability;



	
////CONSTRUCTOR

	public Patient_Info(String ownerName, String patientName, 
        boolean insurance, Species species,Behavior behavior, boolean vaccinated, 
        reasonForVisit visitReason, boolean emergency,Set<Availability> availability)
    {
        setOwnerName(ownerName);
        setPatientName(patientName);
        setSpecies(species);
        setBehavior(behavior);
        setVisitReason(visitReason);
        setAvailability(availability);

        this.insurance = insurance;
        this.vaccinated = vaccinated;
        this.emergency = emergency;
		
	}
////CONSTRUCTOR


	
////GETTER

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
////GETTER


	
////SETTER

	//I added settersfor name and such for possibly a patient info manager almost like a account, though a lot of data shouldnt change, I put the backend tools if needeeed
    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException(
                "Owner Name cannot be empty."
            );
        }
        this.ownerName = ownerName;
    }

    public void setPatientName(String patientName) {
        if (patientName == null || patientName.isBlank()) {
            throw new IllegalArgumentException(
                "Patient Name cannot be empty."
            );
        }
        this.patientName = patientName;
    }

    public void setSpecies(Species species) {
        if (species == null) {
            throw new IllegalArgumentException(
                "Species must be selected."
            );
        }
        this.species = species;
    }

    public void setBehavior(Behavior behavior) {
        if (behavior == null) {
            throw new IllegalArgumentException(
                "Behavior must be selected."
            );
        }
        this.behavior = behavior;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    public void setVisitReason(reasonForVisit visitReason) {
        if (visitReason == null) {
            throw new IllegalArgumentException(
                "Reason for visit must be selected."
            );
        }
        this.visitReason = visitReason;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }

    public void setAvailability(Set<Availability> availability) {
        if (availability == null || availability.isEmpty()) {
            throw new IllegalArgumentException(
                "Available day must be selected."
            );
        }
        this.availability = availability;
    }



	
////METHODS

	public boolean requiresTwoVets(){ //iff surgery or animal  is aggresive 2 vets will be required
		return (this.visitReason==reasonForVisit.SURGERY)|| (this.behavior == Behavior.Aggresive);
	}

	public boolean equals(Object obj){
		if(this==obj){//if current object is equal to proposed record
			return true;
		}
		if(obj==null|| getClass()!=obj.getClass()){//since this accepts any object make sure its recieving a patient object and isnt null
			return false;
		}
		Patient_Info other  =(Patient_Info) obj;
		return this.ownerName.equalsIgnoreCase(other.ownerName)&&this.patientName.equalsIgnoreCase(other.patientName);//if this comes back true, that means their name is in the system
		
	}


	
    public String toString()
    {
        return "Owner: " + this.ownerName + "\n"
        + "Patient: " + this.patientName + "\n"
        + "Species: " + this.species + "\n"
        + "Behavior: " + this.behavior + "\n"
        + "Visit Reason: " + this.visitReason + "\n"
        + "Availability: " + this.availability + "\n"
        + "Insurance: " + (this.insurance ? "Yes" : "No") + "\n"
        + "Vaccinated: " + (this.vaccinated ? "Yes" : "No") + "\n"
        + "Emergency: " + (this.emergency ? "Yes" : "No");
    }
}
