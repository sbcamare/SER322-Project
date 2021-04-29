package ui;


import javax.swing.*;
import java.awt.*;
import main.Delivery;

public class DeliveryListRenderer extends JPanel implements ListCellRenderer<Delivery> {

    private final JPanel cellPanel;
    private final JLabel deliveryId;
    private JLabel firstLabel;
    private JLabel lastLabel;
    private final JLabel emailLabel;
    private final JLabel typeLabel;
    private final JLabel rankLabel;

    public DeliveryListRenderer() {

        super(new BorderLayout());

        JLabel iconLabel;
        JLabel uLabel;
        JLabel fLabel;
        JLabel lLabel;
        JLabel eLabel;

        firstLabel = new JLabel();
        lastLabel = new JLabel();

        iconLabel = new JLabel();

        Icon loginIcon = new ImageIcon(getClass().getResource("/ui/icons/big-parcel-48.png"));
        iconLabel.setIcon(loginIcon);
        add(iconLabel, BorderLayout.WEST);






        cellPanel = new JPanel();
        cellPanel.setLayout(new GridBagLayout());
        uLabel = new JLabel();
        uLabel.setText("USER:");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        cellPanel.add(uLabel, gbc);
        deliveryId = new JLabel();
        deliveryId.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 30;
        cellPanel.add(deliveryId, gbc);
        fLabel = new JLabel();
        fLabel.setText("FIRST:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        cellPanel.add(fLabel, gbc);
        lLabel = new JLabel();
        lLabel.setText("LAST:");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        cellPanel.add(lLabel, gbc);
        eLabel = new JLabel();
        eLabel.setText("EMAIL:");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        cellPanel.add(eLabel, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("TYPE:");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        cellPanel.add(label1, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("RANK:");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        cellPanel.add(label2, gbc);
        firstLabel = new JLabel();
        firstLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 30;
        cellPanel.add(firstLabel, gbc);
        lastLabel = new JLabel();
        lastLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 30;
        cellPanel.add(lastLabel, gbc);
        emailLabel = new JLabel();
        emailLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 30;
        cellPanel.add(emailLabel, gbc);
        typeLabel = new JLabel();
        typeLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 30;
        cellPanel.add(typeLabel, gbc);
        rankLabel = new JLabel();
        rankLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 30;
        cellPanel.add(rankLabel, gbc);






        add(cellPanel, BorderLayout.EAST);
        setOpaque(true); // Visible on panel
        cellPanel.setOpaque(true);//for visible backgrounds
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Delivery> jList, Delivery delivery, int i, boolean isSelected, boolean cellHasFocus) {
//        deliveryId.setText(delivery.getUser());
//        firstLabel.setText(delivery.getFirst());
//        lastLabel.setText(delivery.getLast());
//        emailLabel.setText(delivery.getEmail());
//        typeLabel.setText(delivery.getType());
//        rankLabel.setText(delivery.getRank());

        if (isSelected) {
            setBackground(jList.getSelectionBackground());
            setForeground(jList.getSelectionForeground());
            cellPanel.setBackground(jList.getSelectionBackground());
            cellPanel.setForeground(jList.getSelectionForeground());
        }
        else {
            setBackground(jList.getBackground());
            setForeground(jList.getForeground());
            cellPanel.setBackground(jList.getBackground());
            cellPanel.setForeground(jList.getForeground());
        }

        return this;
    }

}
