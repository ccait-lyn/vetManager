import javax.swing.*;
import java.awt.*;

public class VetGUI {
	
	// Info for patients
	  private static JTextField ownerName, patientName;
	  private static JTextField removeOwnerName, removePatientName;

	// Backend that stores the appointments
	  private static Veternarian_Aid_BE backend = new Veternarian_Aid_BE();

	// Display area for the Registered appointments screen
	  private static JTextArea registeredArea;
	  private static JComboBox<Species> speciesbox;
	  private static JComboBox<Behavior> behaviorbox;
	  private static JComboBox<reasonForVisit> reasonForVisitbox;
	  private static JComboBox<Availability> availabilitybox;
	  private static JCheckBox insurance, vaccinated, emergency;

	public static void main(String[] args) {

		// Creates the app window.
		JFrame frame = new JFrame("Single Window Navigation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 500);
		
		// Cardlayout for making diffrent windows
		CardLayout cardLayout = new CardLayout();
		JPanel mainPanel = new JPanel(cardLayout);
		
		// SCREEN 1: Main Menu
		JPanel screen1 = new JPanel(new GridLayout(1, 2));
		
      // LEFT SIDE OF SCREEN 1: Logo
      JPanel leftPanel = new JPanel(new GridBagLayout());
      leftPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
      JLabel Text = new JLabel("VSPS");
      Text.setFont(new Font("Arial", Font.BOLD, 40));
      leftPanel.add(Text);
          
      // RIGHT SIDE OF SCREEN 2: Main Menu Options
      JPanel rightPanel = new JPanel(new GridBagLayout());
      JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 25));

      JButton P1B1 = new JButton("Appointments");
      P1B1.setFont(new Font("Arial", Font.BOLD, 18));

      JButton P1B3 = new JButton("Veternarian Records");
      P1B3.setFont(new Font("Arial", Font.BOLD, 18));

      JButton P1B4 = new JButton("Patient Records");
      P1B4.setFont(new Font("Arial", Font.BOLD, 18));
      
      buttonPanel.setPreferredSize(new Dimension(250, 320));
      buttonPanel.add(P1B1);
      buttonPanel.add(P1B4);
      buttonPanel.add(P1B3);
      
      rightPanel.add(buttonPanel);
      
      screen1.add(leftPanel);
      screen1.add(rightPanel);
        
    // SCREEN 2: Appointment Page Menu
    JPanel screen2 = new JPanel(new GridLayout(1, 2));
		
		// LEFT SIDE OF SCREEN 2: Logo 
		  JPanel leftPanel1 = new JPanel(new GridBagLayout());
      leftPanel1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
      JLabel Text1 = new JLabel("VSPS");
      Text1.setFont(new Font("Arial", Font.BOLD, 40));
      leftPanel1.add(Text1);
      
      // RIGHT SIDE OF SCREEN 2: Appointment Options
      JPanel rightPanel1 = new JPanel(new GridBagLayout());
      JPanel buttonPanel1 = new JPanel(new GridLayout(4, 1, 10, 25));

      JButton P2B1 = new JButton("New");
      P2B1.setFont(new Font("Arial", Font.BOLD, 18));

      JButton P2B2 = new JButton("Remove");
      P2B2.setFont(new Font("Arial", Font.BOLD, 18));

      JButton P2B3 = new JButton("Registered");
      P2B3.setFont(new Font("Arial", Font.BOLD, 18));

      JButton P2B4 = new JButton("Back to Main Menu");
      P2B4.setFont(new Font("Arial", Font.BOLD, 18));

      buttonPanel1.setPreferredSize(new Dimension(250, 320));
      buttonPanel1.add(P2B1);
      buttonPanel1.add(P2B2);
      buttonPanel1.add(P2B3);
      buttonPanel1.add(P2B4);
      
      rightPanel1.add(buttonPanel1);

      screen2.add(leftPanel1);
      screen2.add(rightPanel1);
        
        
    // SCREEN 3: Adding New Patient
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
      JButton backButtonP3 = new JButton("Back");
      backButtonP3.setFont(new Font("Arial", Font.BOLD, 16));
      JPanel confirmPanel = new JPanel();
      confirmPanel.add(backButtonP3);
      confirmPanel.add(confirmButton);
      screen3.add(confirmPanel, BorderLayout.SOUTH);//this code needs a back end to write to the file we open
        
        
    // SCREEN 4: Remove Patient
    JPanel screen4 = new JPanel(new BorderLayout(15, 15));
    screen4.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));
    JLabel pageTitleP4 = new JLabel("Remove Patient", SwingConstants.CENTER);
    pageTitleP4.setFont(new Font("Arial", Font.BOLD, 25));
    screen4.add(pageTitleP4, BorderLayout.NORTH);

      //INPUT PANEL
      JPanel RemovePanel = new JPanel(new GridLayout(2, 2, 15, 15));
      RemovePanel.setBorder(BorderFactory.createTitledBorder("Patient Information"));

      // OWNER AND PATIENT FIELDS
      JPanel removeOwnerPanel = new JPanel(new BorderLayout(5, 5));
      removeOwnerPanel.add(new JLabel("Owner Name:"), BorderLayout.NORTH);
      removeOwnerName = new JTextField();
      removeOwnerPanel.add(removeOwnerName, BorderLayout.CENTER);
      
      JPanel RemovePatientPanel = new JPanel(new BorderLayout(5, 5));
      RemovePatientPanel.add(new JLabel("Patient Name:"), BorderLayout.NORTH);
      removePatientName = new JTextField();
      RemovePatientPanel.add(removePatientName, BorderLayout.CENTER);
      
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
      JButton backButtonP4 = new JButton("Back");
      backButtonP4.setFont(new Font("Arial", Font.BOLD, 16));
      JPanel FindPanel = new JPanel();
      FindPanel.add(backButtonP4);
      FindPanel.add(FindButton);
      screen4.add(FindPanel, BorderLayout.SOUTH);//this code needs a backend or function to find it after getting the info from the person


    // SCREEN 5: Registered Appointments
    JPanel screen5 = new JPanel(new BorderLayout(15, 15));
    screen5.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));
    JLabel pageTitleP5 = new JLabel("Registered Appointments", SwingConstants.CENTER);
    pageTitleP5.setFont(new Font("Arial", Font.BOLD, 25));
    screen5.add(pageTitleP5, BorderLayout.NORTH);

      // DISPLAY AREA
      JPanel registeredPanel = new JPanel(new BorderLayout());
      registeredPanel.setBorder(BorderFactory.createTitledBorder("Appointments"));
      registeredArea = new JTextArea();
      registeredArea.setEditable(false);
      registeredArea.setLineWrap(true);
      registeredArea.setWrapStyleWord(true);
      registeredArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
      JScrollPane registeredScroll = new JScrollPane(registeredArea);
      registeredPanel.add(registeredScroll, BorderLayout.CENTER);
      screen5.add(registeredPanel, BorderLayout.CENTER);

      // BACK BUTTON
      JButton backButtonP5 = new JButton("Back");
      backButtonP5.setFont(new Font("Arial", Font.BOLD, 16));
      JPanel registeredButtonPanel = new JPanel();
      registeredButtonPanel.add(backButtonP5);
      screen5.add(registeredButtonPanel, BorderLayout.SOUTH);


    // ACTIONLISTENER SECTION
    P1B1.addActionListener(e ->cardLayout.show(mainPanel, "Screen2"));
    P2B1.addActionListener(e ->cardLayout.show(mainPanel, "Screen3"));
    P2B2.addActionListener(e -> cardLayout.show(mainPanel, "Screen4"));
    P2B3.addActionListener(e -> {
        refreshRegisteredAppointments();
        cardLayout.show(mainPanel, "Screen5");
    });
    P2B4.addActionListener(e -> cardLayout.show(mainPanel, "Screen1"));
    backButtonP5.addActionListener(e -> cardLayout.show(mainPanel, "Screen2"));
    backButtonP3.addActionListener(e -> cardLayout.show(mainPanel, "Screen2"));
    backButtonP4.addActionListener(e -> cardLayout.show(mainPanel, "Screen2"));
    confirmButton.addActionListener(e -> cardLayout.show(mainPanel, "Screen1"));
    
    // Adds the screens to the mainPanel so if you need to add more menus put them here.
    mainPanel.add(screen1, "Screen1");
    mainPanel.add(screen2, "Screen2");
    mainPanel.add(screen3, "Screen3");
    mainPanel.add(screen4, "Screen4");
    mainPanel.add(screen5, "Screen5");

    // These dont need to be tuched just a closing and opening of the panel.
    frame.add(mainPanel);
    frame.setVisible(true);
	}

	// Fills the Registered screen's display area with every stored appointment.
	private static void refreshRegisteredAppointments() {
		GenLL<Patient_Info> records = backend.getPatientRecords();

		if (records.size() == 0) {
			registeredArea.setText("No appointments are currently registered.");
			return;
		}

		// Clear the old list, then add each appointment using Patient_Info's toString().
		registeredArea.setText("");
		for (int i = 0; i < records.size(); i++) {
			registeredArea.append("Appointment #" + (i + 1) + "\n");
			registeredArea.append(records.get(i).toString() + "\n\n");
		}
		registeredArea.setCaretPosition(0);
	}
}
