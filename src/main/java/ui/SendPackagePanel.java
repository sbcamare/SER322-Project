package ui;

import javax.swing.*;

import java.awt.*;
import java.sql.Connection;

import main.Main;
import util.App;
import util.Database;

public class SendPackagePanel extends JPanel {

    public SendPackagePanel() {

        JPanel spPanel;
        JLabel titleLabel;
        JLabel messageLabel;
        JLabel message2Label;
        JTextField dimField;
        JTextField weightField;
        JComboBox speedComboBox;
        JComboBox typeComboBox;
        JTextField shipFromField;
        JTextField firstField;
        JTextField lastField;
        JTextField emailField;
        JTextField phoneField;
        JTextField shipToField;
        JButton printButton;
        JLabel shipFromLabel;
        JLabel speedLabel;
        JLabel weightLabel;
        JLabel dimLabel;
        JLabel typeLabel;
        JLabel message3Label;
        JLabel firstLabel;
        JLabel lastLabel;
        JLabel emailLabel;
        JLabel phoneLabel;
        JLabel shipToLabel;



        setLayout(new CardLayout(0, 0));
        setAlignmentX(0.5f);
        setAutoscrolls(false);
        setOpaque(true);



        GridBagConstraints gbc;

        spPanel = new JPanel();
        spPanel.setLayout(new GridBagLayout());

        add(spPanel, "sendPackageCard");





        titleLabel = new JLabel();
        titleLabel.setText("<html><span style='font-size:14px'>SENDING A PACKAGE</span></html>");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(20, 0, 20, 0);
        spPanel.add(titleLabel, gbc);
        messageLabel = new JLabel();
        messageLabel.setText("Please enter following package information");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.WEST;
        spPanel.add(messageLabel, gbc);
        typeLabel = new JLabel();
        typeLabel.setText("Package Type:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        spPanel.add(typeLabel, gbc);
        dimLabel = new JLabel();
        dimLabel.setText("Dimensions:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        spPanel.add(dimLabel, gbc);
        weightLabel = new JLabel();
        weightLabel.setText("Weight:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        spPanel.add(weightLabel, gbc);
        speedLabel = new JLabel();
        speedLabel.setText("Shipping Speed:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.WEST;
        spPanel.add(speedLabel, gbc);
        message3Label = new JLabel();
        message3Label.setText("Receiver Information:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 15;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 30, 0);
        spPanel.add(message3Label, gbc);
        firstLabel = new JLabel();
        firstLabel.setText("First Name:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 16;
        gbc.anchor = GridBagConstraints.WEST;
        spPanel.add(firstLabel, gbc);
        final JSeparator separator1 = new JSeparator();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(20, 0, 20, 0);
        spPanel.add(separator1, gbc);
        final JSeparator separator2 = new JSeparator();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 14;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(20, 0, 20, 0);
        spPanel.add(separator2, gbc);
        message2Label = new JLabel();
        message2Label.setText("Package Information:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 30, 0);
        spPanel.add(message2Label, gbc);
        shipFromLabel = new JLabel();
        shipFromLabel.setText("Ships From:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 13;
        gbc.anchor = GridBagConstraints.WEST;
        spPanel.add(shipFromLabel, gbc);
        lastLabel = new JLabel();
        lastLabel.setText("Last Name:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 18;
        gbc.anchor = GridBagConstraints.WEST;
        spPanel.add(lastLabel, gbc);
        emailLabel = new JLabel();
        emailLabel.setText("Email:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 20;
        gbc.anchor = GridBagConstraints.WEST;
        spPanel.add(emailLabel, gbc);
        phoneLabel = new JLabel();
        phoneLabel.setText("Phone Number:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 22;
        gbc.anchor = GridBagConstraints.WEST;
        spPanel.add(phoneLabel, gbc);
        shipToLabel = new JLabel();
        shipToLabel.setText("Ships To:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 24;
        gbc.anchor = GridBagConstraints.WEST;
        spPanel.add(shipToLabel, gbc);
        dimField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        spPanel.add(dimField, gbc);
        weightField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        spPanel.add(weightField, gbc);
        speedComboBox = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        spPanel.add(speedComboBox, gbc);
        typeComboBox = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 100;
        spPanel.add(typeComboBox, gbc);
        shipFromField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 13;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        spPanel.add(shipFromField, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        spPanel.add(spacer1, gbc);
        firstField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 16;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        spPanel.add(firstField, gbc);
        lastField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 18;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        spPanel.add(lastField, gbc);
        emailField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 20;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        spPanel.add(emailField, gbc);
        phoneField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 22;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        spPanel.add(phoneField, gbc);
        shipToField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 24;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        spPanel.add(shipToField, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 20;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        spPanel.add(spacer2, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 40, 0, 0);
        spPanel.add(spacer3, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 14;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 40);
        spPanel.add(spacer4, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        spPanel.add(spacer5, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 25;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(20, 0, 10, 0);
        spPanel.add(spacer6, gbc);
        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 17;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(5, 0, 5, 0);
        spPanel.add(spacer7, gbc);
        final JPanel spacer8 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 19;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(5, 0, 5, 0);
        spPanel.add(spacer8, gbc);
        final JPanel spacer9 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 21;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(5, 0, 5, 0);
        spPanel.add(spacer9, gbc);
        final JPanel spacer10 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 23;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(5, 0, 5, 0);
        spPanel.add(spacer10, gbc);
        final JPanel spacer11 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 12;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(5, 0, 5, 0);
        spPanel.add(spacer11, gbc);
        final JPanel spacer12 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(5, 0, 5, 0);
        spPanel.add(spacer12, gbc);
        final JPanel spacer13 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(5, 0, 5, 0);
        spPanel.add(spacer13, gbc);
        final JPanel spacer14 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(5, 0, 5, 0);
        spPanel.add(spacer14, gbc);
        printButton = new JButton();
        printButton.setText("Print Shipping Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 26;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 80, 0, 0);
        spPanel.add(printButton, gbc);


        printButton.addActionListener(e -> {

			String receiverEmail = emailField.getText();
			String dimensions = dimField.getText();
			String fromAddress = shipFromField.getText();
			String firstName = firstField.getText();
			String lastName = lastField.getText();
			String phone = phoneField.getText();
			String toAddress = shipToField.getText();
			String type = typeComboBox.getSelectedItem().toString();
			String speed = speedComboBox.getSelectedItem().toString();
			Double weight = Double.parseDouble(weightField.getText());

			Main.sendPackage(Database.getConnection(), App.userPhone, phone, App.userEmail, receiverEmail, speed, toAddress, fromAddress,
					type, dimensions, weight, firstName, lastName);


		});









    }


}
