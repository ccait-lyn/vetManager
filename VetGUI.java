import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class VetGUI {

	// Cohesive clinic color palette
	private static final Color APP_BG = new Color(241, 245, 249);
	private static final Color SURFACE_BG = Color.WHITE;
	private static final Color SIDEBAR_BG = new Color(15, 41, 66);
	private static final Color SIDEBAR_ACCENT = new Color(56, 189, 248);
	private static final Color SECONDARY_BTN = new Color(226, 232, 240);
	private static final Color TEXT_PRIMARY = new Color(15, 23, 42);
	private static final Color BORDER_COLOR = new Color(203, 213, 225);

	// Typography
	private static final Font LOGO_FONT = new Font("SansSerif", Font.BOLD, 42);
	private static final Font TITLE_FONT = new Font("SansSerif", Font.BOLD, 24);
	private static final Font MENU_BTN_FONT = new Font("SansSerif", Font.BOLD, 16);
	private static final Font ACTION_BTN_FONT = new Font("SansSerif", Font.BOLD, 14);
	private static final Font LABEL_FONT = new Font("SansSerif", Font.BOLD, 13);
	private static final Font INPUT_FONT = new Font("SansSerif", Font.PLAIN, 14);
	private static final Font MONO_FONT = new Font("Monospaced", Font.PLAIN, 13);

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
		applyLookAndFeel();

		// Creates the app window.
		JFrame frame = new JFrame("Veterinary Scheduling and Processing System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(760, 540);
		frame.setMinimumSize(new Dimension(680, 480));
		frame.getContentPane().setBackground(APP_BG);

		// Cardlayout for making diffrent windows
		CardLayout cardLayout = new CardLayout();
		JPanel mainPanel = new JPanel(cardLayout);
		mainPanel.setBackground(APP_BG);

		// SCREEN 1: Main Menu
		JPanel screen1 = new JPanel(new GridLayout(1, 2));
		screen1.setBackground(APP_BG);

		// LEFT SIDE OF SCREEN 1: Logo
		JPanel leftPanel = new JPanel(new GridBagLayout());
		JLabel Text = new JLabel("VSPS");
		JLabel subtitle1 = new JLabel("Veterinary Care Portal");
		styleSidebar(leftPanel, Text, subtitle1);

		GridBagConstraints side1Gbc = new GridBagConstraints();
		side1Gbc.gridx = 0;
		side1Gbc.gridy = 0;
		leftPanel.add(Text, side1Gbc);
		side1Gbc.gridy = 1;
		side1Gbc.insets = new Insets(6, 0, 0, 0);
		leftPanel.add(subtitle1, side1Gbc);

		// RIGHT SIDE OF SCREEN 1: Main Menu Options
		JPanel rightPanel = new JPanel(new GridBagLayout());
		rightPanel.setBackground(APP_BG);
		JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 20));
		buttonPanel.setBackground(APP_BG);

		JButton P1B1 = new JButton("Appointments");
		styleSecondaryButton(P1B1, MENU_BTN_FONT);

		JButton P1B3 = new JButton("Veternarian Records");
		styleSecondaryButton(P1B3, MENU_BTN_FONT);

		JButton P1B4 = new JButton("Patient Records");
		styleSecondaryButton(P1B4, MENU_BTN_FONT);

		buttonPanel.setPreferredSize(new Dimension(260, 280));
		buttonPanel.add(P1B1);
		buttonPanel.add(P1B4);
		buttonPanel.add(P1B3);

		rightPanel.add(buttonPanel);

		screen1.add(leftPanel);
		screen1.add(rightPanel);

		// SCREEN 2: Appointment Page Menu
		JPanel screen2 = new JPanel(new GridLayout(1, 2));
		screen2.setBackground(APP_BG);

		// LEFT SIDE OF SCREEN 2: Logo
		JPanel leftPanel1 = new JPanel(new GridBagLayout());
		JLabel Text1 = new JLabel("VSPS");
		JLabel subtitle2 = new JLabel("Appointment Management");
		styleSidebar(leftPanel1, Text1, subtitle2);

		GridBagConstraints side2Gbc = new GridBagConstraints();
		side2Gbc.gridx = 0;
		side2Gbc.gridy = 0;
		leftPanel1.add(Text1, side2Gbc);
		side2Gbc.gridy = 1;
		side2Gbc.insets = new Insets(6, 0, 0, 0);
		leftPanel1.add(subtitle2, side2Gbc);

		// RIGHT SIDE OF SCREEN 2: Appointment Options
		JPanel rightPanel1 = new JPanel(new GridBagLayout());
		rightPanel1.setBackground(APP_BG);
		JPanel buttonPanel1 = new JPanel(new GridLayout(4, 1, 10, 18));
		buttonPanel1.setBackground(APP_BG);

		JButton P2B1 = new JButton("New");
		styleSecondaryButton(P2B1, MENU_BTN_FONT);

		JButton P2B2 = new JButton("Remove");
		styleSecondaryButton(P2B2, MENU_BTN_FONT);

		JButton P2B3 = new JButton("Registered");
		styleSecondaryButton(P2B3, MENU_BTN_FONT);

		JButton P2B4 = new JButton("Back to Main Menu");
		styleSecondaryButton(P2B4, MENU_BTN_FONT);

		buttonPanel1.setPreferredSize(new Dimension(260, 320));
		buttonPanel1.add(P2B1);
		buttonPanel1.add(P2B2);
		buttonPanel1.add(P2B3);
		buttonPanel1.add(P2B4);

		rightPanel1.add(buttonPanel1);

		screen2.add(leftPanel1);
		screen2.add(rightPanel1);

		// SCREEN 3: Adding New Patient
		JPanel screen3 = new JPanel(new BorderLayout(15, 15));
		screen3.setBackground(APP_BG);
		screen3.setBorder(createScreenPadding());
		JLabel pageTitle = new JLabel("New Patient", SwingConstants.CENTER);
		stylePageTitle(pageTitle);
		screen3.add(pageTitle, BorderLayout.NORTH);

		// INPUT FIELDS
		JPanel newInputPanel = new JPanel(new GridLayout(3, 2, 16, 14));
		newInputPanel.setBackground(SURFACE_BG);
		newInputPanel.setBorder(createCardBorder("Patient Information"));

		// OWNER NAME
		JPanel ownerPanel = new JPanel(new BorderLayout(5, 5));
		ownerPanel.setBackground(SURFACE_BG);
		JLabel ownerLabel = new JLabel("Owner Name:");
		styleFieldLabel(ownerLabel);
		ownerPanel.add(ownerLabel, BorderLayout.NORTH);
		ownerName = new JTextField();
		styleTextField(ownerName);
		ownerPanel.add(ownerName, BorderLayout.CENTER);

		// PATIENT NAME
		JPanel patientPanel = new JPanel(new BorderLayout(5, 5));
		patientPanel.setBackground(SURFACE_BG);
		JLabel patientLabel = new JLabel("Patient Name:");
		styleFieldLabel(patientLabel);
		patientPanel.add(patientLabel, BorderLayout.NORTH);
		patientName = new JTextField();
		styleTextField(patientName);
		patientPanel.add(patientName, BorderLayout.CENTER);

		// COMBO BOX'S
		JPanel speciesPanel = new JPanel(new BorderLayout(5, 5));
		speciesPanel.setBackground(SURFACE_BG);
		JLabel speciesLabel = new JLabel("Species:");
		styleFieldLabel(speciesLabel);
		speciesPanel.add(speciesLabel, BorderLayout.NORTH);
		speciesbox = new JComboBox<>(Species.values());
		styleComboBox(speciesbox);
		speciesPanel.add(speciesbox, BorderLayout.CENTER);

		JPanel behaviorPanel = new JPanel(new BorderLayout(5, 5));
		behaviorPanel.setBackground(SURFACE_BG);
		JLabel behaviorLabel = new JLabel("Behavior:");
		styleFieldLabel(behaviorLabel);
		behaviorPanel.add(behaviorLabel, BorderLayout.NORTH);
		behaviorbox = new JComboBox<>(Behavior.values());
		styleComboBox(behaviorbox);
		behaviorPanel.add(behaviorbox, BorderLayout.CENTER);

		JPanel reasonPanel = new JPanel(new BorderLayout(5, 5));
		reasonPanel.setBackground(SURFACE_BG);
		JLabel reasonLabel = new JLabel("Reason for Visit:");
		styleFieldLabel(reasonLabel);
		reasonPanel.add(reasonLabel, BorderLayout.NORTH);
		reasonForVisitbox = new JComboBox<>(reasonForVisit.values());
		styleComboBox(reasonForVisitbox);
		reasonPanel.add(reasonForVisitbox, BorderLayout.CENTER);

		JPanel availabilityPanel = new JPanel(new BorderLayout(5, 5));
		availabilityPanel.setBackground(SURFACE_BG);
		JLabel availabilityLabel = new JLabel("Availability:");
		styleFieldLabel(availabilityLabel);
		availabilityPanel.add(availabilityLabel, BorderLayout.NORTH);
		availabilitybox = new JComboBox<>(Availability.values());
		styleComboBox(availabilitybox);
		availabilityPanel.add(availabilitybox, BorderLayout.CENTER);

		newInputPanel.add(ownerPanel);
		newInputPanel.add(patientPanel);
		newInputPanel.add(speciesPanel);
		newInputPanel.add(behaviorPanel);
		newInputPanel.add(reasonPanel);
		newInputPanel.add(availabilityPanel);

		// CHECKBOXES
		JPanel checkBoxPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 28, 8));
		checkBoxPanel.setBackground(SURFACE_BG);
		checkBoxPanel.setBorder(createCardBorder("Additional Information"));
		insurance = new JCheckBox("Insurance");
		vaccinated = new JCheckBox("Vaccinated");
		emergency = new JCheckBox("Emergency");
		styleCheckBox(insurance);
		styleCheckBox(vaccinated);
		styleCheckBox(emergency);
		checkBoxPanel.add(insurance);
		checkBoxPanel.add(vaccinated);
		checkBoxPanel.add(emergency);

		// CENTER PANEL
		JPanel centerPanel = new JPanel(new BorderLayout(10, 16));
		centerPanel.setBackground(APP_BG);
		centerPanel.add(newInputPanel, BorderLayout.CENTER);
		centerPanel.add(checkBoxPanel, BorderLayout.SOUTH);
		screen3.add(centerPanel, BorderLayout.CENTER);

		// CONFIRM BUTTON
		JButton confirmButton = new JButton("Confirm Registration");
		stylePrimaryButton(confirmButton, ACTION_BTN_FONT);
		JButton backButtonP3 = new JButton("Back");
		styleSecondaryButton(backButtonP3, ACTION_BTN_FONT);
		JPanel confirmPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 14, 4));
		confirmPanel.setBackground(APP_BG);
		confirmPanel.add(backButtonP3);
		confirmPanel.add(confirmButton);
		screen3.add(confirmPanel, BorderLayout.SOUTH); // this code needs a back end to write to the file we open

		// SCREEN 4: Remove Patient
		JPanel screen4 = new JPanel(new BorderLayout(15, 15));
		screen4.setBackground(APP_BG);
		screen4.setBorder(createScreenPadding());
		JLabel pageTitleP4 = new JLabel("Remove Patient", SwingConstants.CENTER);
		stylePageTitle(pageTitleP4);
		screen4.add(pageTitleP4, BorderLayout.NORTH);

		// INPUT PANEL
		JPanel RemovePanel = new JPanel(new GridLayout(1, 2, 16, 14));
		RemovePanel.setBackground(SURFACE_BG);
		RemovePanel.setBorder(createCardBorder("Patient Information"));

		// OWNER AND PATIENT FIELDS
		JPanel removeOwnerPanel = new JPanel(new BorderLayout(5, 5));
		removeOwnerPanel.setBackground(SURFACE_BG);
		JLabel removeOwnerLabel = new JLabel("Owner Name:");
		styleFieldLabel(removeOwnerLabel);
		removeOwnerPanel.add(removeOwnerLabel, BorderLayout.NORTH);
		removeOwnerName = new JTextField();
		styleTextField(removeOwnerName);
		removeOwnerPanel.add(removeOwnerName, BorderLayout.CENTER);

		JPanel RemovePatientPanel = new JPanel(new BorderLayout(5, 5));
		RemovePatientPanel.setBackground(SURFACE_BG);
		JLabel removePatientLabel = new JLabel("Patient Name:");
		styleFieldLabel(removePatientLabel);
		RemovePatientPanel.add(removePatientLabel, BorderLayout.NORTH);
		removePatientName = new JTextField();
		styleTextField(removePatientName);
		RemovePatientPanel.add(removePatientName, BorderLayout.CENTER);

		RemovePanel.add(removeOwnerPanel);
		RemovePanel.add(RemovePatientPanel);

		// FOUND PATIENT DISPLAY
		JPanel foundPatientPanel = new JPanel(new BorderLayout());
		foundPatientPanel.setBackground(SURFACE_BG);
		foundPatientPanel.setBorder(createCardBorder("Found Patient"));
		JTextArea foundPatientArea = new JTextArea(6, 25);
		foundPatientArea.setEditable(false);
		foundPatientArea.setLineWrap(true);
		foundPatientArea.setWrapStyleWord(true);
		styleTextArea(foundPatientArea, MONO_FONT);
		JScrollPane scrollPane = new JScrollPane(foundPatientArea);
		scrollPane.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 1));
		foundPatientPanel.add(scrollPane, BorderLayout.CENTER);

		// CENTER PANEL
		JPanel removeCenterPanel = new JPanel(new BorderLayout(10, 16));
		removeCenterPanel.setBackground(APP_BG);
		removeCenterPanel.add(RemovePanel, BorderLayout.NORTH);
		removeCenterPanel.add(foundPatientPanel, BorderLayout.CENTER);
		screen4.add(removeCenterPanel, BorderLayout.CENTER);

		// FIND BUTTON
		JButton FindButton = new JButton("Find Patient");
		stylePrimaryButton(FindButton, ACTION_BTN_FONT);
		JButton backButtonP4 = new JButton("Back");
		styleSecondaryButton(backButtonP4, ACTION_BTN_FONT);
		JPanel FindPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 14, 4));
		FindPanel.setBackground(APP_BG);
		FindPanel.add(backButtonP4);
		FindPanel.add(FindButton);
		screen4.add(FindPanel, BorderLayout.SOUTH); // this code needs a backend or function to find it after getting the info from the person

		// SCREEN 5: Registered Appointments
		JPanel screen5 = new JPanel(new BorderLayout(15, 15));
		screen5.setBackground(APP_BG);
		screen5.setBorder(createScreenPadding());
		JLabel pageTitleP5 = new JLabel("Registered Appointments", SwingConstants.CENTER);
		stylePageTitle(pageTitleP5);
		screen5.add(pageTitleP5, BorderLayout.NORTH);

		// DISPLAY AREA
		JPanel registeredPanel = new JPanel(new BorderLayout());
		registeredPanel.setBackground(SURFACE_BG);
		registeredPanel.setBorder(createCardBorder("Appointments"));
		registeredArea = new JTextArea();
		registeredArea.setEditable(false);
		registeredArea.setLineWrap(true);
		registeredArea.setWrapStyleWord(true);
		styleTextArea(registeredArea, MONO_FONT);
		JScrollPane registeredScroll = new JScrollPane(registeredArea);
		registeredScroll.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 1));
		registeredPanel.add(registeredScroll, BorderLayout.CENTER);
		screen5.add(registeredPanel, BorderLayout.CENTER);

		// BACK BUTTON
		JButton backButtonP5 = new JButton("Back");
		styleSecondaryButton(backButtonP5, ACTION_BTN_FONT);
		JPanel registeredButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 14, 4));
		registeredButtonPanel.setBackground(APP_BG);
		registeredButtonPanel.add(backButtonP5);
		screen5.add(registeredButtonPanel, BorderLayout.SOUTH);

		// ACTIONLISTENER SECTION
		P1B1.addActionListener(e -> cardLayout.show(mainPanel, "Screen2"));
		P2B1.addActionListener(e -> cardLayout.show(mainPanel, "Screen3"));
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

	private static void applyLookAndFeel() {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					return;
				}
			}
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception ignored) {
			// Fall back to default Swing L&F if unavailable
		}
	}

	private static Border createCardBorder(String title) {
		Border line = BorderFactory.createLineBorder(BORDER_COLOR, 1, true);
		Border padding = BorderFactory.createEmptyBorder(12, 14, 12, 14);
		TitledBorder titled = BorderFactory.createTitledBorder(
				line,
				title,
				TitledBorder.LEFT,
				TitledBorder.TOP,
				LABEL_FONT,
				TEXT_PRIMARY
		);
		return BorderFactory.createCompoundBorder(titled, padding);
	}

	private static Border createScreenPadding() {
		return BorderFactory.createEmptyBorder(22, 28, 22, 28);
	}

	private static void styleSidebar(JPanel sidebar, JLabel brandLabel, JLabel subtitleLabel) {
		sidebar.setBackground(SIDEBAR_BG);
		sidebar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, SIDEBAR_ACCENT));

		brandLabel.setFont(LOGO_FONT);
		brandLabel.setForeground(Color.WHITE);

		subtitleLabel.setFont(LABEL_FONT);
		subtitleLabel.setForeground(SIDEBAR_ACCENT);
	}

	private static void stylePageTitle(JLabel titleLabel) {
		titleLabel.setFont(TITLE_FONT);
		titleLabel.setForeground(TEXT_PRIMARY);
	}

	private static void styleFieldLabel(JLabel label) {
		label.setFont(LABEL_FONT);
		label.setForeground(TEXT_PRIMARY);
	}

	private static void styleTextField(JTextField field) {
		field.setFont(INPUT_FONT);
		field.setForeground(TEXT_PRIMARY);
		field.setBackground(SURFACE_BG);
		field.setCaretColor(TEXT_PRIMARY);
		field.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(BORDER_COLOR, 1),
				BorderFactory.createEmptyBorder(6, 10, 6, 10)
		));
	}

	private static <E> void styleComboBox(JComboBox<E> comboBox) {
		comboBox.setFont(INPUT_FONT);
		comboBox.setForeground(TEXT_PRIMARY);
		comboBox.setBackground(SURFACE_BG);
	}

	private static void styleCheckBox(JCheckBox checkBox) {
		checkBox.setFont(INPUT_FONT);
		checkBox.setForeground(TEXT_PRIMARY);
		checkBox.setBackground(SURFACE_BG);
		checkBox.setFocusPainted(false);
	}

	private static void styleTextArea(JTextArea area, Font font) {
		area.setFont(font);
		area.setForeground(TEXT_PRIMARY);
		area.setBackground(SURFACE_BG);
		area.setCaretColor(TEXT_PRIMARY);
		area.setMargin(new Insets(10, 12, 10, 12));
	}

	private static void stylePrimaryButton(JButton button, Font font) {
		styleSecondaryButton(button, font);
	}

	private static void styleSecondaryButton(JButton button, Font font) {
		button.setFont(font);
		button.setBackground(SECONDARY_BTN);
		button.setForeground(TEXT_PRIMARY);
		button.setOpaque(true);
		button.setContentAreaFilled(true);
		button.setFocusPainted(false);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(BORDER_COLOR, 1),
				BorderFactory.createEmptyBorder(10, 18, 10, 18)
		));
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
