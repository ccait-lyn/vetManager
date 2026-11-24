package vetmanager;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

import vetmanager.Patient_Info.Species;
import vetmanager.Patient_Info.Behavior;
import vetmanager.Patient_Info.reasonForVisit;
import vetmanager.Patient_Info.Availability;


public class VetGUI {
	
	//info for patients
	  private static JTextField ownerName, patientName;
	  private static JComboBox<Species> speciesbox;
	  private static JComboBox<Behavior> behaviorbox;
	  private static JComboBox<reasonForVisit> reasonForVisitbox;
	  private static JComboBox<Availability> availabilitybox;
	  private static JCheckBox insurance,vaccinated,emergency;
	  private static JTextArea displayArea;

	public static void main(String[] args) {
		//makes the window
		JFrame frame = new JFrame("Single Window Navigation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 500);
		
		//cardlayout for making diffrent windows
		CardLayout cardLayout = new CardLayout();
		JPanel mainPanel = new JPanel(cardLayout);
		
		//first screen / main menu
		JPanel screen1 = new JPanel(new GridLayout(1, 2));
		
		//leftside of 1
		JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
        JLabel Text = new JLabel("VSPS");
        Text.setFont(new Font("Arial", Font.BOLD, 40));
        leftPanel.add(Text);
        
        //rightside of 1
        JPanel rightPanel = new JPanel(new GridBagLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 25));
        JButton P1B1 = new JButton("Appointments");
        P1B1.setFont(new Font("Arial", Font.BOLD, 18));
        /*
        JButton P1B2 = new JButton("Check In");
        P1B2.setFont(new Font("Arial", Font.BOLD, 18));*/
        JButton P1B3 = new JButton("Hire Doctors");
        P1B3.setFont(new Font("Arial", Font.BOLD, 18));
        JButton P1B4 = new JButton("View Records");
        P1B4.setFont(new Font("Arial", Font.BOLD, 18));
        
        buttonPanel.setPreferredSize(new Dimension(250, 320));
        buttonPanel.add(P1B1);
        //buttonPanel.add(P1B2);
        buttonPanel.add(P1B3);
        buttonPanel.add(P1B4);
        
        rightPanel.add(buttonPanel);
        
        screen1.add(leftPanel);
        screen1.add(rightPanel);
        
        //screen 2 the appointment page
        JPanel screen2 = new JPanel(new GridLayout(1, 2));
		
		//leftside of 1
		JPanel leftPanel1 = new JPanel(new GridBagLayout());
        leftPanel1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
        JLabel Text1 = new JLabel("VSPS");
        Text1.setFont(new Font("Arial", Font.BOLD, 40));
        leftPanel1.add(Text1);
        
        //rightside of 2
        JPanel rightPanel1 = new JPanel(new GridBagLayout());
        JPanel buttonPanel1 = new JPanel(new GridLayout(4, 1, 10, 25));
        JButton P2B1 = new JButton("New");
        P2B1.setFont(new Font("Arial", Font.BOLD, 18));
        JButton P2B2 = new JButton("Remove");
        P2B2.setFont(new Font("Arial", Font.BOLD, 18));
        JButton P2B3 = new JButton("Registered");
        P2B3.setFont(new Font("Arial", Font.BOLD, 18));
        
        buttonPanel1.setPreferredSize(new Dimension(250, 320));
        buttonPanel1.add(P2B1);
        buttonPanel1.add(P2B2);
        buttonPanel1.add(P2B3);
        
        rightPanel1.add(buttonPanel1);

        screen2.add(leftPanel1);
        screen2.add(rightPanel1);
        
        
        //SCREEN 3 NEW PATIENT
        JPanel screen3 = new JPanel(new BorderLayout(15, 15));
        screen3.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));
        JLabel pageTitle = new JLabel("New Patient", SwingConstants.CENTER);
        pageTitle.setFont(new Font("Arial", Font.BOLD, 25));
        screen3.add(pageTitle, BorderLayout.NORTH);

        //INPUT FIELDS
        JPanel newInputPanel = new JPanel(new GridLayout(3, 2, 15, 15));
        newInputPanel.setBorder(BorderFactory.createTitledBorder("Patient Information"));

        //OWNER NAME
        JPanel ownerPanel = new JPanel(new BorderLayout(5, 5));
        ownerPanel.add(new JLabel("Owner Name:"), BorderLayout.NORTH);
        ownerName = new JTextField();
        ownerPanel.add(ownerName, BorderLayout.CENTER);

        //PATIENT NAME
        JPanel patientPanel = new JPanel(new BorderLayout(5, 5));
        patientPanel.add(new JLabel("Patient Name:"), BorderLayout.NORTH);
        patientName = new JTextField();
        patientPanel.add(patientName, BorderLayout.CENTER);

        // COMBO BOX'S
        JPanel speciesPanel = new JPanel(new BorderLayout(5, 5));
        speciesPanel.add(new JLabel("Species:"), BorderLayout.NORTH);
        speciesbox = new JComboBox<>(Species.values());
        speciesPanel.add(speciesbox, BorderLayout.CENTER);

        JPanel behaviorPanel = new JPanel(new BorderLayout(5, 5));
        behaviorPanel.add(new JLabel("Behavior:"), BorderLayout.NORTH);
        behaviorbox = new JComboBox<>(Behavior.values());
        behaviorPanel.add(behaviorbox, BorderLayout.CENTER);

        JPanel reasonPanel = new JPanel(new BorderLayout(5, 5));
        reasonPanel.add(new JLabel("Reason for Visit:"), BorderLayout.NORTH);
        reasonForVisitbox = new JComboBox<>(reasonForVisit.values());
        reasonPanel.add(reasonForVisitbox, BorderLayout.CENTER);

        JPanel availabilityPanel = new JPanel(new BorderLayout(5, 5));
        availabilityPanel.add(new JLabel("Availability:"), BorderLayout.NORTH);
        availabilitybox = new JComboBox<>(Availability.values());
        availabilityPanel.add(availabilitybox, BorderLayout.CENTER);

        newInputPanel.add(ownerPanel);
        newInputPanel.add(patientPanel);
        newInputPanel.add(speciesPanel);
        newInputPanel.add(behaviorPanel);
        newInputPanel.add(reasonPanel);
        newInputPanel.add(availabilityPanel);

        // CHECKBOXES
        JPanel checkBoxPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        checkBoxPanel.setBorder(BorderFactory.createTitledBorder("Additional Information"));
        insurance = new JCheckBox("Insurance");
        vaccinated = new JCheckBox("Vaccinated");
        emergency = new JCheckBox("Emergency");
        checkBoxPanel.add(insurance);
        checkBoxPanel.add(vaccinated);
        checkBoxPanel.add(emergency);

        // CENTER PANEL
        JPanel centerPanel = new JPanel(new BorderLayout(10, 20));
        centerPanel.add(newInputPanel, BorderLayout.CENTER);
        centerPanel.add(checkBoxPanel, BorderLayout.SOUTH);
        screen3.add(centerPanel, BorderLayout.CENTER);

        // CONFIRM BUTTON
        JButton confirmButton = new JButton("Confirm Registration");
        confirmButton.setFont(new Font("Arial", Font.BOLD, 16));
        JPanel confirmPanel = new JPanel();
        confirmPanel.add(confirmButton);
        screen3.add(confirmPanel, BorderLayout.SOUTH);//this code needs a back end to write to the file we open
        
        
        //SCREEN 4 REMOVE PATIENT
        JPanel screen4 = new JPanel(new BorderLayout(15, 15));
        screen4.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));
        JLabel pageTitleP4 = new JLabel("Remove Patient", SwingConstants.CENTER);
        pageTitleP4.setFont(new Font("Arial", Font.BOLD, 25));
        screen4.add(pageTitleP4, BorderLayout.NORTH);

        //INPUT PANEL
        JPanel RemovePanel = new JPanel(new GridLayout(2, 2, 15, 15));
        RemovePanel.setBorder(BorderFactory.createTitledBorder("Patient Information"));

        // Owner and patient fields
        JPanel removeOwnerPanel = new JPanel(new BorderLayout(5, 5));
        removeOwnerPanel.add(new JLabel("Owner Name:"), BorderLayout.NORTH);
        ownerName = new JTextField();
        removeOwnerPanel.add(ownerName, BorderLayout.CENTER);
        
        JPanel RemovePatientPanel = new JPanel(new BorderLayout(5, 5));
        RemovePatientPanel.add(new JLabel("Patient Name:"), BorderLayout.NORTH);
        patientName = new JTextField();
        RemovePatientPanel.add(patientName, BorderLayout.CENTER);
        
        RemovePanel.add(removeOwnerPanel);
        RemovePanel.add(RemovePatientPanel);

        // FOUND PATIENT DISPLAY
        JPanel foundPatientPanel = new JPanel(new BorderLayout());
        foundPatientPanel.setBorder(BorderFactory.createTitledBorder("Found Patient"));
        JTextArea foundPatientArea = new JTextArea(6, 25);
        foundPatientArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(foundPatientArea);
        foundPatientPanel.add(scrollPane, BorderLayout.CENTER);

        // CENTER PANEL
        JPanel removeCenterPanel = new JPanel(new GridLayout(2, 1, 10, 15));
        removeCenterPanel.add(RemovePanel);
        removeCenterPanel.add(foundPatientPanel);
        screen4.add(removeCenterPanel, BorderLayout.CENTER);

        // FIND BUTTON
        JButton FindButton = new JButton("Find Patient");
        FindButton.setFont(new Font("Arial", Font.BOLD, 16));
        JPanel FindPanel = new JPanel();
        FindPanel.add(FindButton);
        screen4.add(FindPanel, BorderLayout.SOUTH);//this code needs a backend or function to find it after getting the info from the person
        
        
        //actionlistener section
        P1B1.addActionListener(e ->cardLayout.show(mainPanel, "Screen2"));
        P2B1.addActionListener(e ->cardLayout.show(mainPanel, "Screen3"));
        P2B2.addActionListener(e -> cardLayout.show(mainPanel, "Screen4"));
        confirmButton.addActionListener(e -> cardLayout.show(mainPanel, "Screen1"));
        
        //adds the screens to the mainPanel so if you need to add more menus put them here
        mainPanel.add(screen1, "Screen1");
        mainPanel.add(screen2, "Screen2");
        mainPanel.add(screen3, "Screen3");
        mainPanel.add(screen4, "Screen4");
        
        //these dont need to be tuched just a closing and opening of the panel
        frame.add(mainPanel);
        
        frame.setVisible(true);
	}
}
