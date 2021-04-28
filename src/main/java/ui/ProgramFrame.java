package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProgramFrame extends JFrame {

	public ProgramFrame() {

		JPanel parentPanel;
		JPanel cardPanel;
		JPanel tabsPanel;
		JButton yourAccountButton;
		JButton sendPackageButton;
		JButton trackPackageButton;
		JButton yourPackagesButton;
		JPanel yourPackagesPanel;
		JPanel trackPackagePanel;
		JPanel sendPackagePanel;
		JPanel yourAccountPanel;


		parentPanel = new JPanel();
		parentPanel.setLayout(new BorderLayout(0, 0));
		tabsPanel = new JPanel();
		tabsPanel.setLayout(new GridBagLayout());
		parentPanel.add(tabsPanel, BorderLayout.WEST);
		yourAccountButton = new JButton();
		yourAccountButton.setBorderPainted(false);
		yourAccountButton.setContentAreaFilled(false);
		yourAccountButton.setIcon(new ImageIcon(getClass().getResource("/icons/user-menu-female-96.png")));
		yourAccountButton.setText("Your Account");

		GridBagConstraints gbc;

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(200, 0, 50, 0);
		tabsPanel.add(yourAccountButton, gbc);

		sendPackageButton = new JButton();
		sendPackageButton.setBorderPainted(false);
		sendPackageButton.setContentAreaFilled(false);
		sendPackageButton.setIcon(new ImageIcon(getClass().getResource("/icons/move-stock-96.png")));
		sendPackageButton.setText("Send Package");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(50, 0, 50, 0);
		tabsPanel.add(sendPackageButton, gbc);

		trackPackageButton = new JButton();
		trackPackageButton.setBorderPainted(false);
		trackPackageButton.setContentAreaFilled(false);
		trackPackageButton.setIcon(new ImageIcon(getClass().getResource("/icons/handcart-96.png")));
		trackPackageButton.setText("Track Package");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(50, 0, 50, 0);
		tabsPanel.add(trackPackageButton, gbc);

		yourPackagesButton = new JButton();
		yourPackagesButton.setBorderPainted(false);
		yourPackagesButton.setContentAreaFilled(false);
		yourPackagesButton.setIcon(new ImageIcon(getClass().getResource("/icons/delivered-box-96.png")));
		yourPackagesButton.setOpaque(false);
		yourPackagesButton.setText("Your Packages");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(50, 0, 50, 0);
		tabsPanel.add(yourPackagesButton, gbc);

		cardPanel = new JPanel();
		cardPanel.setLayout(new CardLayout(0, 0));
		parentPanel.add(cardPanel, BorderLayout.CENTER);

		yourPackagesPanel = new YourPackagesPanel();
		cardPanel.add(yourPackagesPanel, "yourPackagesCard");

		trackPackagePanel = new TrackPackagePanel();
		cardPanel.add(trackPackagePanel, "trackPackageCard");

		sendPackagePanel = new SendPackagePanel();
		cardPanel.add(sendPackagePanel, "sendPackageCard");

		yourAccountPanel = new YourAccountPanel();
		cardPanel.add(yourAccountPanel, "yourAccountCard");



		setContentPane(parentPanel);
		setResizable(false);
		pack();
		setVisible(true);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		CardLayout cardLayout = (CardLayout) (cardPanel.getLayout());


		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// YOUR PACKAGES BUTTON LISTENER
		yourPackagesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				cardLayout.show(cardPanel, "yourPackagesCard");
			}
		});

		// TRACK PACKAGE BUTTON LISTENER
		trackPackageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				cardLayout.show(cardPanel, "trackPackageCard");
			}
		});


		// SEND PACKAGE BUTTON LISTENER
		sendPackageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				cardLayout.show(cardPanel, "sendPackageCard");
			}
		});

		// YOUR ACCOUNT BUTTON LISTENER
		yourAccountButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				cardLayout.show(cardPanel, "yourAccountCard");
			}
		});

	}

}
