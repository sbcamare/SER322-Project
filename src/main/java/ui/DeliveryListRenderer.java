package ui;


import javax.swing.*;
import java.awt.*;
import main.Delivery;

public class DeliveryListRenderer extends JPanel implements ListCellRenderer<Delivery> {

    private final JPanel cellPanel;

    private final JLabel deliveryId;
    private final JLabel shipSpeed;
    private final JLabel fromAddress;
    private final JLabel toAddress;
    private final JLabel arrivalDate;
    private final JLabel arriveTime;

    public DeliveryListRenderer() {

        super(new BorderLayout());

        JLabel iconLabel;
        JLabel uLabel;
        JLabel fLabel;
        JLabel lLabel;
        JLabel eLabel;



        iconLabel = new JLabel();

        Icon loginIcon = new ImageIcon(getClass().getResource("/icons/big-parcel-48.png"));
        iconLabel.setIcon(loginIcon);
        add(iconLabel, BorderLayout.WEST);






        cellPanel = new JPanel();
        cellPanel.setLayout(new GridBagLayout());
        uLabel = new JLabel();
        uLabel.setText("ID:");
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
        fLabel.setText("SPEED:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        cellPanel.add(fLabel, gbc);
        lLabel = new JLabel();
        lLabel.setText("FROM:");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        cellPanel.add(lLabel, gbc);
        eLabel = new JLabel();
        eLabel.setText("TO:");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        cellPanel.add(eLabel, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("DATE:");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        cellPanel.add(label1, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("TIME:");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        cellPanel.add(label2, gbc);
        shipSpeed = new JLabel();
        shipSpeed.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 30;
        cellPanel.add(shipSpeed, gbc);
        fromAddress = new JLabel();
        fromAddress.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 30;
        cellPanel.add(fromAddress, gbc);
        toAddress = new JLabel();
        toAddress.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 30;
        cellPanel.add(toAddress, gbc);
        arrivalDate = new JLabel();
        arrivalDate.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 30;
        cellPanel.add(arrivalDate, gbc);
        arriveTime = new JLabel();
        arriveTime.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 30;
        cellPanel.add(arriveTime, gbc);






        add(cellPanel, BorderLayout.EAST);
        setOpaque(true); // Visible on panel
        cellPanel.setOpaque(true);//for visible backgrounds
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Delivery> jList, Delivery delivery, int i, boolean isSelected, boolean cellHasFocus) {
        deliveryId.setText(delivery.getDeliveryId());
        shipSpeed.setText(delivery.getShippingSpeed());
        fromAddress.setText(delivery.getFromAddress());
        toAddress.setText(delivery.getToAddress());
        arrivalDate.setText(delivery.getArrivalDate());
        arriveTime.setText(delivery.getArrivalTime());

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
