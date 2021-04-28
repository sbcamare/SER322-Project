package ui;

import javax.swing.*;
import java.awt.*;

public class sendPackagePanel extends JPanel {


    private JPanel spPanel;
    private JLabel typeLabel;
    private JLabel dimensionsLabel;
    private JLabel weightLabel;
    private JTextField weightField;
    private JTextField dimensionsField;
    private JComboBox typeComboBox;
    private JLabel titleLabel;
    private JLabel messageLabel;
    private JButton printButton;


    public sendPackagePanel() {

        setLayout(new CardLayout(0, 0));
        setAlignmentX(0.5f);
        setAutoscrolls(false);
        setOpaque(true);



        GridBagConstraints gbc;

        spPanel = new JPanel();
        spPanel.setLayout(new GridBagLayout());

        add(spPanel, "sendPackageCard");

        typeLabel = new JLabel();
        typeLabel.setText("Package Type:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        spPanel.add(typeLabel, gbc);

        dimensionsLabel = new JLabel();
        dimensionsLabel.setText("Dimensions:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        spPanel.add(dimensionsLabel, gbc);

        weightLabel = new JLabel();
        weightLabel.setText("Weight:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        spPanel.add(weightLabel, gbc);

        weightField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        spPanel.add(weightField, gbc);

        dimensionsField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        spPanel.add(dimensionsField, gbc);

        typeComboBox = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 200;
        spPanel.add(typeComboBox, gbc);

        titleLabel = new JLabel();
        titleLabel.setText("SENDING A PACKAGE");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        spPanel.add(titleLabel, gbc);

        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(20, 0, 20, 0);
        spPanel.add(spacer6, gbc);

        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(20, 0, 20, 0);
        spPanel.add(spacer7, gbc);

        final JPanel spacer8 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(20, 0, 200, 0);
        spPanel.add(spacer8, gbc);

        final JPanel spacer9 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(200, 0, 20, 0);
        spPanel.add(spacer9, gbc);

        final JPanel spacer10 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 20, 0, 20);
        spPanel.add(spacer10, gbc);

        final JPanel spacer11 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 20, 0, 0);
        spPanel.add(spacer11, gbc);

        final JPanel spacer12 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 20);
        spPanel.add(spacer12, gbc);

        messageLabel = new JLabel();
        messageLabel.setText("Please enter following package information");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST;
        spPanel.add(messageLabel, gbc);

        final JPanel spacer13 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(15, 0, 15, 0);
        spPanel.add(spacer13, gbc);

        final JPanel spacer14 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(20, 0, 0, 0);
        spPanel.add(spacer14, gbc);

        printButton = new JButton();
        printButton.setText("Print Shipping Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.EAST;
        spPanel.add(printButton, gbc);

        final JPanel spacer15 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 12;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(20, 0, 20, 0);
        spPanel.add(spacer15, gbc);


    }


}
