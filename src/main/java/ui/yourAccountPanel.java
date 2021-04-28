package ui;

import javax.swing.*;
import java.awt.*;

public class yourAccountPanel extends JPanel {





    public yourAccountPanel() { // TODO: ADD USER INFO

        JPanel yaPanel;
        JLabel yaTitleLabel;
        JLabel firstNLabel;
        JLabel fLabel;
        JLabel lLabel;
        JLabel pLabel;
        JLabel phoneLabel;
        JLabel lastNLabel;
        JLabel emailLabel;
        JLabel eLabel;
        JLabel addressLabel;
        JLabel aLabel;


        setLayout(new CardLayout(0, 0));

        yaPanel = new JPanel();
        yaPanel.setLayout(new GridBagLayout());

        add(yaPanel, "yourAccountCard");


        GridBagConstraints gbc;

        yaTitleLabel = new JLabel();
        yaTitleLabel.setText("YOUR ACCOUNT INFORMATION");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        yaPanel.add(yaTitleLabel, gbc);

        final JPanel spacer16 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        yaPanel.add(spacer16, gbc);

        firstNLabel = new JLabel();
        firstNLabel.setText("First Name:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 100);
        yaPanel.add(firstNLabel, gbc);

        final JPanel spacer17 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.VERTICAL;
        yaPanel.add(spacer17, gbc);

        lastNLabel = new JLabel();
        lastNLabel.setText("Last Name:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        yaPanel.add(lastNLabel, gbc);

        final JPanel spacer18 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.VERTICAL;
        yaPanel.add(spacer18, gbc);

        phoneLabel = new JLabel();
        phoneLabel.setText("Phone Number:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        yaPanel.add(phoneLabel, gbc);

        final JPanel spacer19 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.VERTICAL;
        yaPanel.add(spacer19, gbc);

        emailLabel = new JLabel();
        emailLabel.setText("Email:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        yaPanel.add(emailLabel, gbc);

        fLabel = new JLabel();
        fLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 150;
        yaPanel.add(fLabel, gbc);

        lLabel = new JLabel();
        lLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 150;
        yaPanel.add(lLabel, gbc);

        pLabel = new JLabel();
        pLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 150;
        yaPanel.add(pLabel, gbc);

        eLabel = new JLabel();
        eLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 150;
        yaPanel.add(eLabel, gbc);

        final JPanel spacer20 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.VERTICAL;
        yaPanel.add(spacer20, gbc);

        addressLabel = new JLabel();
        addressLabel.setText("Address:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.WEST;
        yaPanel.add(addressLabel, gbc);

        aLabel = new JLabel();
        aLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 150;
        yaPanel.add(aLabel, gbc);

        final JPanel spacer21 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.fill = GridBagConstraints.VERTICAL;
        yaPanel.add(spacer21, gbc);

        final JPanel spacer22 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        yaPanel.add(spacer22, gbc);

    }


}
