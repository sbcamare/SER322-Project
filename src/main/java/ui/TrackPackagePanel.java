package ui;

import main.Delivery;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrackPackagePanel extends JPanel {

    public TrackPackagePanel() { // TODO: ADD FIELD LISTENER AND LOGIC

        JPanel tpPanel;
        JLabel tpTitleLabel;
        JTextField textField1;

        setLayout(new CardLayout(0, 0));

        tpPanel = new JPanel();
        tpPanel.setLayout(new GridBagLayout());
        add(tpPanel, "trackPackageCard");


        GridBagConstraints gbc;

        tpTitleLabel = new JLabel();
        tpTitleLabel.setText("<html><span style='font-size:14px'>ENTER A PACKAGE TO TRACK</span></html>");
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

        JButton buttonOk = new JButton("Track");
        buttonOk.setEnabled(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        tpPanel.add(buttonOk,gbc);

        // Action Listener for button
        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int trackingInput;
                try {
                    trackingInput = Integer.parseInt(textField1.getText());
                    Delivery newDel = new Delivery(trackingInput);

                    if (newDel.checkDelivery()) {
                        textField1.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.white));

                        JDialog trackingDiag = new PackageDetailDialog(newDel);
                        trackingDiag.setLocationRelativeTo(null);
                        trackingDiag.setResizable(false);
                        trackingDiag.setVisible(true);

                    } else {
                        textField1.setText("Delivery ID not found!");
                        textField1.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.red));
                    }

                } catch (NumberFormatException ne) {
                    textField1.setText("Invalid Input.");
                    textField1.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.red));
                }
            }
        });

        // Document listener for textfield
        textField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changed();
            }
            public void changedUpdate(DocumentEvent e) {
                changed();
            }
            public void removeUpdate(DocumentEvent e) {
                changed();
            }

            public void changed() {
                if (textField1.getText().equals("")){
                    buttonOk.setEnabled(false);
                }
                else {
                    buttonOk.setEnabled(true);
                }
            }
        });
    }



}
