package view;
import common.Node;
import controller.OwnBinarySearchTree;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UIBinarySearchTree extends JFrame {

    private static final long serialVersionUID = 1L;

    JPanel p1, p2, p3;
    JTextField ins, del, find;
    JButton ins_but, del_but, find_but;
    JLabel bst_heading, notation;

    int mov1 = 0;
    int mov2 = 0;


    UIBinarySearchTree() {
        //Creating UI
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        ins = new JTextField(7);
        del = new JTextField(7);
        find = new JTextField(7);
        ins_but = new JButton("Insert");
        del_but = new JButton("Delete");
        find_but = new JButton("Find");
        bst_heading = new JLabel("Binary Search Tree");
        notation = new JLabel("Big O(log n)");
        Font f1 = new Font("Arial", Font.BOLD, 50);
        Font f2 = new Font("Arial", Font.ITALIC, 20);
        bst_heading.setFont(f1);
        notation.setFont(f2);
        p1.setBounds(0, 0, 800, 100);
        p1.add(bst_heading);
        p1.add(notation);
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        p2.add(ins);
        p2.add(ins_but);
        p2.add(del);
        p2.add(del_but);
        p2.add(find);
        p2.add(find_but);
        p2.setBackground(Color.LIGHT_GRAY);
        p2.setBounds(0, 100, 800, 50);
        p3.add(p1);
        p3.add(p2);
        p3.setBounds(0, 0, 800, 150);
        add(p3);
        setLayout(null);
        setFocusable(true);

        //Creating main node

        Node nodeMain = new Node(15);
        nodeMain.left = null;
        nodeMain.right = null;
        JLabel mainLabel = new JLabel(String.valueOf(nodeMain.value)); // LABEL1
        add(mainLabel);
        mainLabel.setBackground(Color.gray);
        mainLabel.setOpaque(true);
        mainLabel.setBounds(400, 200, 25, 25);
        mainLabel.setForeground(Color.white);

        ins_but.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int left = 400;
                int down = 200;
                int val = Integer.parseInt(ins.getText());

                JLabel label = new JLabel(ins.getText());
                label.setBackground(Color.gray);
                String s = OwnBinarySearchTree.insertNode(val, nodeMain, left, down);
                String[] nums = s.split("\\s+");
                add(label);
                int[] numsInt = {400, 200, 400, 200};
                numsInt[0] = Integer.parseInt(nums[0]);
                numsInt[1] = Integer.parseInt(nums[1]);
                numsInt[2] = Integer.parseInt(nums[2]);
                numsInt[3] = Integer.parseInt(nums[3]);
                label.setBounds(numsInt[0], numsInt[1], 25, 25);
                label.setForeground(Color.white);
                label.setOpaque(true);
                Graphics g = getGraphics();
                g.drawLine(numsInt[2] + 25, numsInt[3] + 55, numsInt[0] + 20, numsInt[1] + 30); // messy part
                System.out.println(nums[2] + " " + nums[3] + "     " + nums[0] + " " + nums[1]);
                System.out.println(numsInt[0] + " " + numsInt[1] + " " + numsInt[2] + " " + numsInt[3] + " ");
                System.out.println();
            }
        });
    }
}