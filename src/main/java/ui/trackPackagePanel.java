package ui;

import javax.swing.*;
import java.awt.*;

public class trackPackagePanel extends JPanel {


    public trackPackagePanel() { // TODO: ADD FIELD LISTENER AND LOGIC

        JPanel tpPanel;
        JLabel tpTitleLabel;
        JTextField textField1;


        setLayout(new CardLayout(0, 0));

        tpPanel = new JPanel();
        tpPanel.setLayout(new GridBagLayout());
        add(tpPanel, "trackPackageCard");


        GridBagConstraints gbc;

        tpTitleLabel = new JLabel();
        tpTitleLabel.setText("ENTER A PACKAGE TO TRACK");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        tpPanel.add(tpTitleLabel, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        tpPanel.add(spacer5, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("Tracking Number:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 50);
        tpPanel.add(label1, gbc);
        textField1 = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 150;
        tpPanel.add(textField1, gbc);
    }

}
