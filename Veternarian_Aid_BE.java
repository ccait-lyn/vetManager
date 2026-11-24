package vetPetBeta;

import java.util.Set;

import vetPetBeta.VetManager.Patient_Info.Behavior;
import vetPetBeta.VetManager.Patient_Info.Species;
import vetPetBeta.VetManager.Patient_Info.reasonForVisit;
import vetPetBeta.VetManager.Patient_Info.Availability;

public class Veternarian_Aid_BE {
	
	//Checks for insurance
	public boolean insuranceCheck(boolean insurance)
	{
		return insurance;
	}
	
	//Returns the type of animal
	public static Species animalType(int selection)
	{	
		switch(selection)
		{
		case 1:
			return Species.DOG;
			
		case 2:
			return Species.CAT;
		
		case 3:
			return Species.BIRD;
			
		case 4:
			return Species.REPTILE;
			
		case 5:
			return Species.RODENT;
			
		default:
			return Species.OTHER;
		}
	}
	
	//Adds a new patient
	public void addPatient(String newOwnerName, String newPatientName, boolean anInsurance,
			Species newSpecies, Behavior newBehavior, boolean isVaccinated,
				reasonForVisit newReason, boolean isEmergency, Set<Availability> anAvailability)
	{
		if(newOwnerName != null && newPatientName != null)
		{
			Patient_Info newPatient = new Patient_Info(newOwnerName, newPatientName, anInsurance, newSpecies,
					newBehavior, isVaccinated, newReason, isEmergency, anAvailability);
		}
	}
}
