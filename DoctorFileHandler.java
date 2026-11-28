import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.EnumSet;

public class DoctorFileHandler 
{
	
	
    public static void saveDoctors(GenLL<Doctor_Info> doctors) throws FileNotFoundException 
    {

        PrintWriter output = new PrintWriter("doctors.txt");

        for (int i = 0; i < doctors.size(); i++) 
        {
            Doctor_Info doctor = doctors.get(i);

            output.println(
                    doctor.getDoctorName() + "|"
                    + joinEnums(doctor.getSupportedSpecies()) + "|"
                    + joinEnums(doctor.getHandledBehaviors()) + "|"
                    + joinEnums(doctor.getAvailableDays()) + "|"
                    + doctor.acceptsInsurance() + "|"
                    + doctor.isSurgeon() + "|"
                    + doctor.isDentist());
        }

        output.close();
    }

    
    
    public static GenLL<Doctor_Info> loadDoctors() throws FileNotFoundException 
    {

        GenLL<Doctor_Info> doctors = new GenLL<>();
        File file = new File("doctors.txt");


        Scanner input = new Scanner(file);

        while (input.hasNextLine()) 
        {
            String line = input.nextLine();

            if (!line.isEmpty()) {
                String[] parts = line.split("\\|");

                if (parts.length != 7) 
                {
                    input.close();
                    throw new IllegalArgumentException("Invalid doctor record: " + line);
                }

                Set<Species> species = EnumSet.noneOf(Species.class);
                for (String value : parts[1].split(",")) 
                {
                    species.add(Species.valueOf(value));
                }

                Set<Behavior> behaviors = EnumSet.noneOf(Behavior.class);
                for (String value : parts[2].split(",")) 
                {
                    behaviors.add(Behavior.valueOf(value));
                }

                Set<Availability> days = EnumSet.noneOf(Availability.class);
                for (String value : parts[3].split(",")) 
                {
                    days.add(Availability.valueOf(value));
                }

                Doctor_Info doctor = new Doctor_Info(
                        parts[0], species, behaviors, days,
                        Boolean.parseBoolean(parts[4]),
                        Boolean.parseBoolean(parts[5]),
                        Boolean.parseBoolean(parts[6]));

                doctors.add(doctor);
            }
        }

        input.close();
        return doctors;
    }

    private static String joinEnums(Set<?> values) 
    {
        String result = "";

        for (Object value : values) 
        {
            if (!result.isEmpty()) result += ",";
            result += value.toString();
        }

        return result;
    }

}