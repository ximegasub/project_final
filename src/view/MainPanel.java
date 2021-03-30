package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JFrame {
    private static final long serialVersionUID = 1L;

    JPanel p1;
    JButton array_but, arrayList_but, linkedList_but, hashSet_but, bst_but;
    JLabel hs_heading;

    public MainPanel() {
        //Creating UI
        p1 = new JPanel();
        array_but = new JButton("Arrays");
        arrayList_but = new JButton("Array Lists");
        linkedList_but = new JButton("Linked Lists");
        hashSet_but = new JButton("Hash Set");
        bst_but = new JButton("Binary Search Tree");
        String paragraph = "Data Structures";
        hs_heading = new JLabel();
        hs_heading.setText("<html><p style=\"width:600px\">"+paragraph+"</p></html>");
        Font f1 = new Font("Arial", Font.BOLD, 50);
        hs_heading.setFont(f1);
        p1.setBounds(0, 0, 800, 100);
        p1.add(hs_heading);
        p1.add(array_but);
        p1.add(arrayList_but);
        p1.add(linkedList_but);
        p1.add(hashSet_but);
        p1.add(bst_but);
        add(p1);
        setLayout(null);
        setFocusable(true);
        array_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new UIDataStructure().draw("ARRAY");
            }
        });
        arrayList_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new UIDataStructure().draw("ARRAYLIST");
            }
        });
        linkedList_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new UIDataStructure().draw("LINKEDLIST");
            }
        });
        hashSet_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new UIDataStructure().draw("HASHSET");
            }
        });
        bst_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new UIDataStructure().draw("BST");
            }
        });
    }
}
