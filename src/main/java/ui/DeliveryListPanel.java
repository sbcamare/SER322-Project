package ui;

import javax.swing.*;
import main.*;
import java.awt.*;

public class DeliveryListPanel extends  JPanel {

    public DeliveryListPanel() {

        JList<Delivery> deliveryCellList = new DeliveryList().getList();
        deliveryCellList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        deliveryCellList.setCellRenderer(new DeliveryListRenderer());

        JOptionPane jop = new JOptionPane(deliveryCellList, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null);
        jop.setMessage(deliveryCellList);

        JDialog userListDialog = jop.createDialog("Select user");

        deliveryCellList.addListSelectionListener(e1 -> {

            if (!e1.getValueIsAdjusting()) {

                if (deliveryCellList.getSelectedIndex() != -1) {
//                    Delivery selectedUser = deliveryCellList.getSelectedValue();
//                    JDialog editUserDialog = new EditUserDialog(selectedUser);
//                    editUserDialog.setLocationRelativeTo(userListDialog);
//                    editUserDialog.setVisible(true);
                }
            }
        });

        userListDialog.setVisible(true);
    }

}
