package ui;

import util.Login;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupDialog extends JDialog {

	public SignupDialog() {

		// Declaring SWING components
		JTextField phoneField;
		JTextField emailField;
		JTextField lastNField;
		JTextField firstNField;
		JPasswordField passField;
		JPanel panel;
		JLabel firstNLabel;
		JLabel lastNLabel;
		JLabel emailLabel;
		JLabel phoneLabel;
		JLabel passLabel;
		JLabel passConLabel;
		JLabel contactLabel;
		JLabel credLabel;
		JPanel container;
		JPasswordField passConField;
		JLabel iconLabel;
		JLabel welcomeLabel;
		Icon signupIcon = new ImageIcon(getClass().getResource("/icons/add-user-male-96.png"));
		JButton signButton;

		// Initializing SWING components
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		firstNLabel = new JLabel();
		firstNLabel.setText("First Name:");
		GridBagConstraints gbc;
		gbc = new GridBagConstraints();
		gbc.gridx = 5;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 0, 70);
		panel.add(firstNLabel, gbc);
		lastNLabel = new JLabel();
		lastNLabel.setText("Last Name:");
		gbc = new GridBagConstraints();
		gbc.gridx = 5;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(lastNLabel, gbc);
		phoneLabel = new JLabel();
		phoneLabel.setText("Phone");
		gbc = new GridBagConstraints();
		gbc.gridx = 5;
		gbc.gridy = 9;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(phoneLabel, gbc);
		final JSeparator separator1 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 10;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(20, 0, 20, 0);
		panel.add(separator1, gbc);
		phoneField = new JFormattedTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 6;
		gbc.gridy = 9;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipadx = 50;
		gbc.insets = new Insets(0, 0, 0, 40);
		panel.add(phoneField, gbc);
		lastNField = new JTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 6;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipadx = 50;
		gbc.insets = new Insets(0, 0, 0, 40);
		panel.add(lastNField, gbc);
		firstNField = new JTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 6;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipadx = 50;
		gbc.insets = new Insets(0, 0, 0, 40);
		panel.add(firstNField, gbc);
		final JPanel spacer1 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 6;
		gbc.gridy = 6;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel.add(spacer1, gbc);
		final JPanel spacer2 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 6;
		gbc.gridy = 8;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel.add(spacer2, gbc);
		contactLabel = new JLabel();
		contactLabel.setText("<html><span style='font-size:12px'>Contact information:</span></html>");
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 3;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 10, 0);
		panel.add(contactLabel, gbc);
		final JPanel spacer3 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 7;
		gbc.gridy = 0;
		gbc.gridheight = 15;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 0, 20);
		panel.add(spacer3, gbc);
		final JPanel spacer4 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridheight = 14;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 10, 0, 0);
		panel.add(spacer4, gbc);
		welcomeLabel = new JLabel();
		welcomeLabel.setText("<html><span style='font-size:14px'>Please enter the following information: </span></html>");
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel.add(welcomeLabel, gbc);
		final JPanel spacer5 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 5;
		gbc.gridy = 14;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.insets = new Insets(0, 0, 20, 0);
		panel.add(spacer5, gbc);
		final JPanel spacer6 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 5;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel.add(spacer6, gbc);
		final JPanel spacer7 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 5;
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel.add(spacer7, gbc);
		credLabel = new JLabel();
		credLabel.setText("<html><span style='font-size:12px'>Credentials:</span></html>");
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 11;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 10, 0);
		panel.add(credLabel, gbc);
		container = new JPanel();
		container.setLayout(new GridBagLayout());
		container.setEnabled(true);
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 12;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.BOTH;
		panel.add(container, gbc);
		emailField = new JTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipadx = 200;
		container.add(emailField, gbc);
		passLabel = new JLabel();
		passLabel.setText("Password:");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		container.add(passLabel, gbc);
		passField = new JPasswordField();
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipadx = 100;
		container.add(passField, gbc);
		passConLabel = new JLabel();
		passConLabel.setText("Confirm Password:");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 0, 50);
		container.add(passConLabel, gbc);
		final JPanel spacer8 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.insets = new Insets(0, 0, 20, 0);
		container.add(spacer8, gbc);
		final JPanel spacer9 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.VERTICAL;
		container.add(spacer9, gbc);
		emailLabel = new JLabel();
		emailLabel.setText("Email");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 0, 50);
		container.add(emailLabel, gbc);
		passConField = new JPasswordField();
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 5;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipadx = 100;
		container.add(passConField, gbc);
		final JPanel spacer10 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.VERTICAL;
		container.add(spacer10, gbc);
		final JPanel spacer11 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.VERTICAL;
		container.add(spacer11, gbc);
		final JPanel spacer12 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		container.add(spacer12, gbc);
		final JPanel spacer13 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		container.add(spacer13, gbc);
		final JPanel spacer14 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 5;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.insets = new Insets(20, 0, 0, 0);
		panel.add(spacer14, gbc);
		final JPanel spacer15 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel.add(spacer15, gbc);
		final JPanel spacer16 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 15;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 20, 0, 0);
		panel.add(spacer16, gbc);
		iconLabel = new JLabel();
		iconLabel.setIcon(signupIcon);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(iconLabel, gbc);
		final JSeparator separator2 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 13;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(15, 0, 0, 0);
		panel.add(separator2, gbc);
		final JPanel panel1 = new JPanel();
		panel1.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 15;
		gbc.gridwidth = 8;
		gbc.fill = GridBagConstraints.BOTH;
		panel.add(panel1, gbc);
		signButton = new JButton();
		signButton.setText("Sign up");
		signButton.setEnabled(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 6;
		gbc.gridy = 16;
		gbc.insets = new Insets(0, 0, 15, 0);
		panel.add(signButton, gbc);
		final JPanel spacer17 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 6;
		gbc.gridy = 17;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel.add(spacer17, gbc);


		setPanelEnabled(container, false);

		// Setting JDialog options
		setContentPane(panel);
		setModal(true);
		getRootPane().setDefaultButton(signButton);
		pack();
		setResizable(false);


		firstNField.getDocument().addDocumentListener(new DocumentListener() {
			protected void update() {
				setPanelEnabled(container, (firstNField.getText().length() > 0) && (lastNField.getText().length() > 0) && isPhone(phoneField.getText()));
				signButton.setEnabled(false);

				if (firstNField.getText().length() > 0) {
					firstNField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
				}
				if (firstNField.getText().length() > 0 && passMatch(String.valueOf(passField.getPassword()), String.valueOf(passConField.getPassword())) && emailField.getText().length() > 0) {
					signButton.setEnabled(true);
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				update();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				update();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				update();
			}
		});

		lastNField.getDocument().addDocumentListener(new DocumentListener() {
			protected void update() {
				setPanelEnabled(container, (firstNField.getText().length() > 0) && (lastNField.getText().length() > 0) && isPhone(phoneField.getText()));
				signButton.setEnabled(false);

				if (lastNField.getText().length() > 0) {
					lastNField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
				}
				if (lastNField.getText().length() > 0 && passMatch(String.valueOf(passField.getPassword()), String.valueOf(passConField.getPassword())) && emailField.getText().length() > 0) {
					signButton.setEnabled(true);
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				update();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				update();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				update();
			}
		});


		phoneField.getDocument().addDocumentListener(new DocumentListener() {
			protected void update() {
				setPanelEnabled(container, (firstNField.getText().length() > 0) && (lastNField.getText().length() > 0) && isPhone(phoneField.getText()));
				phoneField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
				signButton.setEnabled(false);

				if (isPhone(phoneField.getText())) {
					phoneField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
				}
				if (isPhone(phoneField.getText()) && passMatch(String.valueOf(passField.getPassword()), String.valueOf(passConField.getPassword())) && isEmail(emailField.getText())) {
					signButton.setEnabled(true);
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				update();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				update();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				update();
			}
		});


		emailField.getDocument().addDocumentListener(new DocumentListener() {
			protected void update() {
				emailField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
				signButton.setEnabled(false);

				if (isEmail(emailField.getText())) {
					emailField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
				}
				if (isEmail(emailField.getText()) && passMatch(String.valueOf(passField.getPassword()), String.valueOf(passConField.getPassword())) && emailField.getText().length() > 0) {
					signButton.setEnabled(true);
				}

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				update();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				update();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				update();
			}
		});


		emailField.getDocument().addDocumentListener(new DocumentListener() {
			protected void update() {
				signButton.setEnabled(false);

				if (emailField.getText().length() > 0) {
					emailField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
				}
				if (passMatch(String.valueOf(passField.getPassword()), String.valueOf(passConField.getPassword())) && isEmail(emailField.getText())) {
					emailField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
					signButton.setEnabled(true);
				}

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				update();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				update();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				update();
			}
		});


		passField.getDocument().addDocumentListener(new DocumentListener() {
			protected void update() {
				passField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
				passConField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
				signButton.setEnabled(false);

				if (passMatch(String.valueOf(passField.getPassword()), String.valueOf(passConField.getPassword())) && isEmail(emailField.getText())) {
					signButton.setEnabled(true);
				}
				if (passMatch(String.valueOf(passField.getPassword()), String.valueOf(passConField.getPassword()))) {
					passField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
					passConField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				update();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				update();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				update();
			}
		});


		passConField.getDocument().addDocumentListener(new DocumentListener() {
			protected void update() {
				passField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
				passConField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
				signButton.setEnabled(false);

				if (passMatch(String.valueOf(passField.getPassword()), String.valueOf(passConField.getPassword())) && isEmail(emailField.getText())) {
					signButton.setEnabled(true);
				}
				if (passMatch(String.valueOf(passField.getPassword()), String.valueOf(passConField.getPassword()))) {
					passField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
					passConField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				update();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				update();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				update();
			}
		});


		// Listener for 'Sign Up' button
		signButton.addActionListener(e -> {

			String email = emailField.getText();
			String pass = String.valueOf(passField.getPassword());
			String first = firstNField.getText();
			String last = lastNField.getText();
			String phone = phoneField.getText();

			if (Login.userSignup(email, pass, first, last, phone)) { // SIGNUP SUCCESSFUL
				dispose();
			} else { // SIGNUP FAILED... USERNAME IS ALREADY TAKEN
				JOptionPane.showMessageDialog(null, "This user already exists!", "Unable to sign up!", JOptionPane.WARNING_MESSAGE);
				emailField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
			}

		});


		// Listener for 'X' button
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// Listener for 'Esc' key
		panel.registerKeyboardAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

	}


	private void setPanelEnabled(JPanel panel, Boolean bool) {
		panel.setEnabled(bool);
		Component[] components = panel.getComponents();
		for (Component component : components) {
			if (component instanceof JPanel) {
				setPanelEnabled((JPanel) component, bool);
			}
			component.setEnabled(bool);
		}
	}


	private boolean passMatch(String pass1, String pass2) {
		return (pass1.equals(pass2) && pass1.length() > 0);
	}


	private boolean isEmail(String input) {
		//String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{3,6}$";
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.com$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		return matcher.find();
	}

	private boolean isPhone(String input) {
		String regex = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		return matcher.find();
	}
}
