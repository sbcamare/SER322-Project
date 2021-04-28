package ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class yourPackagesPanel extends JPanel {

    public yourPackagesPanel() { // TODO: ADD PACKAGES TO packageListPanel

        JPanel ypPanel;
        JLabel ypTitleLabel;
        JLabel ypMessageLabel;
        JPanel packageListPanel;


        setLayout(new CardLayout(0, 0));

        ypPanel = new JPanel();
        ypPanel.setLayout(new GridBagLayout());
        add(ypPanel, "yourPackagesCard");


        GridBagConstraints gbc;

        ypTitleLabel = new JLabel();
        ypTitleLabel.setText("VIEWING YOUR PACKAGES");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        ypPanel.add(ypTitleLabel, gbc);

        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(20, 0, 200, 0);
        ypPanel.add(spacer1, gbc);

        ypMessageLabel = new JLabel();
        ypMessageLabel.setText("These are known packages related to you: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        ypPanel.add(ypMessageLabel, gbc);

        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(15, 0, 15, 0);
        ypPanel.add(spacer2, gbc);

        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(20, 0, 0, 0);
        ypPanel.add(spacer3, gbc);

        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(20, 0, 20, 0);
        ypPanel.add(spacer4, gbc);

        packageListPanel = new JPanel();
        packageListPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipady = 50;
        gbc.insets = new Insets(100, 0, 100, 0);
        ypPanel.add(packageListPanel, gbc);
        packageListPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
    }


}
