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