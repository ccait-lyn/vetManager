package vetPetBeta;


import java.util.Set;

////DOCTOR INFO
	private String doctorName;// Name of the veterinarian
	
	private Set<Species> speciesExperience; //Species the vet can treat
	private Set<Behavior> handledBehaviors;//Specific behaviors a vet can handle
	private Set<Availability> availability; //availability
	
	private boolean acceptsInsurance; //whether the doctor accepts insurance
	private boolean isSurgeon; //qualified to do surgries
	private boolean isDentist;// Qaulified to do dental
////DOCTOR INFO
	

///CONSTRUCTOR
	public Doctor_Info(String doctorName, Set<Species> speciesExperience,
					   Set<Behavior> handledBehaviors, Set<Availability> 
					   availableDays, boolean acceptsInsurance, boolean isSurgeon, boolean isDentist)
	{
        setDoctorName(doctorName);
        setSupportedSpecies(speciesExperience);
        setHandledBehaviors(handledBehaviors);
        setAvailableDays(availableDays);

        this.acceptsInsurance = acceptsInsurance;
        this.isSurgeon = isSurgeon;
        this.isDentist = isDentist;
	}

///CONSTRUCTOR

	
///GETTERS
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
///GETTERS



////SETTERS
    public void setDoctorName(String doctorName) {
        if (doctorName == null || doctorName.isBlank()) {
            throw new IllegalArgumentException(
                "Doctor name cannot be empty."
            );
        }
        this.doctorName = doctorName;
    }

    public void setSupportedSpecies(Set<Species> speciesExperience) {
        if (speciesExperience == null || speciesExperience.isEmpty()) {
            throw new IllegalArgumentException(
                "Doctor must support at least one species."
            );
        }
        this.speciesExperience = speciesExperience;
    }

    public void setHandledBehaviors(Set<Behavior> handledBehaviors) {
        if (handledBehaviors == null || handledBehaviors.isEmpty()) {
            throw new IllegalArgumentException(
                "Doctor must handle at least one behavior."
            );
        }
        this.handledBehaviors = handledBehaviors;
    }

    public void setAvailableDays(Set<Availability> availableDays) {
        if (availableDays == null || availableDays.isEmpty()) {
            throw new IllegalArgumentException(
                "Doctor must have at least one available day."
            );
        }
        this.availability = availableDays;
    }

    public void setAcceptsInsurance(boolean acceptsInsurance) {
        this.acceptsInsurance = acceptsInsurance;
    }

    public void setSurgeon(boolean isSurgeon) {
        this.isSurgeon = isSurgeon;
    }

    public void setDentist(boolean isDentist) {
        this.isDentist = isDentist;
    }

////SETTERS



////METHODS
	public boolean canTreatPatient(Patient_Info patient){
		
		if (patient == null) {
		    throw new IllegalArgumentException("Patient cannot be null.");
		}
		
		//check if emergency to override
		boolean speciesMatch = patient.isEmergency()||speciesExperience.contains(patient.getSpecies())  ||speciesExperience.contains(Species.OTHER);//Check if there is a match for species and their experience
		
		boolean behaviorMatch = handledBehaviors.contains(patient.getBehavior()); //check to see if the vet can handle the animals behavior
		
		//check if available
		boolean available = false; //default is no
		if(this.availability.contains(Availability.ANYDAY)||patient.getAvailability().contains(Availability.ANYDAY)){ //check if anyday is present, if present then they are available
			available = true;
		}else{
	
			for(Availability day : patient.getAvailability()){//Else check every day within set to see if one matches
				if(this.availability.contains(day)){
					available = true;
					break;
				}
			}
		}

		//check if surgeon or dentist
		boolean surgeryMatch=true;
		if (patient.getVisitReason() == reasonForVisit.SURGERY){
			surgeryMatch = this.isSurgeon;
		}
		boolean dentistMatch=true;
		if (patient.getVisitReason() == reasonForVisit.DENTAL) {
			dentistMatch=this.isDentist;
		}

		return speciesMatch && behaviorMatch && available && surgeryMatch&&dentistMatch;//if all is true then returns true for FE
	}

	
}