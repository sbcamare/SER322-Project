package ui;

import javax.swing.*;
import main.*;
import java.awt.*;

public class DeliveryListPanel extends  JPanel {

    public DeliveryListPanel() {

        JList<Delivery> deliveryCellList = new DeliveryList().getList();
        deliveryCellList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        deliveryCellList.setCellRenderer(new DeliveryListRenderer());

        add(deliveryCellList);
    }

}
