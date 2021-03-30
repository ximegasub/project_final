package view;

import controller.OwnLinkedList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;

public class UILinkedList extends JFrame {
    private static final long serialVersionUID = 1L;

    JPanel p1, p2, p3;
    JTextField ins, del, find, pos;
    JButton ins_but, del_but, find_but, show_but;
    JLabel hs_heading, notation;
    int rectangleX = 30;
    int rectangleY = 150;
    int rectangleWH = 50;
    int linesDistance = 100;

    UILinkedList() {
        //Creating UI
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        ins = new JTextField(7);
        pos = new JTextField(7);
        del = new JTextField(7);
        find = new JTextField(7);
        ins_but = new JButton("Insert");
        del_but = new JButton("Delete");
        find_but = new JButton("Find");
        show_but = new JButton("Show");
        hs_heading = new JLabel("Linked List");
        notation = new JLabel("Big O(n)");
        Font f1 = new Font("Arial", Font.BOLD, 50);
        Font f2 = new Font("Arial", Font.ITALIC, 20);
        hs_heading.setFont(f1);
        notation.setFont(f2);
        p1.setBounds(0, 0, 800, 100);
        p1.add(hs_heading);
        p1.add(notation);
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        p2.add(pos);
        p2.add(ins);
        p2.add(ins_but);
        p2.add(del);
        p2.add(del_but);
        p2.add(find);
        p2.add(find_but);
        p2.add(show_but);
        p2.setBackground(Color.LIGHT_GRAY);
        p2.setBounds(0, 100, 800, 50);
        p3.add(p1);
        p3.add(p2);
        p3.setBounds(0, 0, 800, 150);
        add(p3);
        setLayout(null);
        setFocusable(true);
        OwnLinkedList ownLinkedList = new OwnLinkedList();
        ownLinkedList.start();
        show_but.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  Graphics g = getGraphics();
                  Graphics2D g2 = (Graphics2D) g;
                  g2.setStroke(new BasicStroke(3));
                  rectangleX = 30;
                  rectangleY = 150;
                  rectangleWH = 50;
                  linesDistance = 100;
                  LinkedList<Integer> ll = ownLinkedList.getLinkedList();
                  for (int i = 0; i < ll.size(); i++) {
                      if (i == 0) {
                          g2.drawString("head", rectangleX + 10, rectangleY + 25);
                      }
                      if (i == ll.size() - 1) {
                          g2.drawString("tail", rectangleX + 10, rectangleY + 25);
                      }
                      rectangleX = rectangleX + linesDistance;
                  }
                  rectangleY = 200;
                  rectangleX = 30;
                  for (int i = 0; i < ll.size(); i++) {
                      g2.draw(new Rectangle2D.Float(rectangleX, rectangleY, rectangleWH, rectangleWH));
                      g2.drawString(Integer.toString(ll.get(i)), rectangleX + 10, rectangleY + 25);
                      g2.draw(new Line2D.Float(rectangleX + rectangleWH, rectangleWH / 2 + rectangleY, rectangleX + linesDistance, rectangleWH / 2 + rectangleY));
                      if (i == ll.size() - 1) {
                          g2.drawString("null", rectangleX + 110, rectangleY + 25);
                      }
                      rectangleX = rectangleX + linesDistance;
                  }
              }
        });
        ins_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Graphics g = getGraphics();
                int value = Integer.parseInt(ins.getText());
                int index = Integer.parseInt(pos.getText());
                LinkedList<Integer> ll = ownLinkedList.getLinkedList();
                ownLinkedList.addAnyPosition(value, index);

                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));

                rectangleY = 270;
                int position = index - 1;
                if (position == 0) {
                    rectangleX = (50 * position) + 30;
                }else{
                    rectangleX = (100 * position) + 30;
                }

                g2.setColor(Color.gray);
                g2.draw(new Rectangle2D.Float(rectangleX, rectangleY, rectangleWH, rectangleWH));
                g2.drawString(Integer.toString(value), rectangleX + 10, rectangleY + 25);
                rectangleX = rectangleX + linesDistance;

                rectangleY = 340;
                rectangleX = 30;
                for (int i = 0; i < ll.size(); i++) {
                    g2.setColor(Color.BLACK);
                    if (i == index - 1){
                        g2.setColor(Color.gray);
                    }
                    g2.draw(new Rectangle2D.Float(rectangleX, rectangleY, rectangleWH, rectangleWH));
                    g2.drawString(Integer.toString(ll.get(i)), rectangleX + 10, rectangleY + 25);
                    g2.draw(new Line2D.Float(rectangleX + rectangleWH, rectangleWH / 2 + rectangleY, rectangleX + linesDistance, rectangleWH / 2 + rectangleY));
                    if (i == ll.size() - 1){
                        g2.drawString("null", rectangleX + 110, rectangleY + 25);
                    }
                    rectangleX = rectangleX + linesDistance;
                }
            }
        });
        del_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Graphics g = getGraphics();
                int index = Integer.parseInt(del.getText());
//                LinkedList<Integer> ll = ownLinkedList.getLinkedList();
                LinkedList<Integer> ll = ownLinkedList.deleteFromAnyPosition(index);

                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));

                rectangleY = 300;
                rectangleX = 30;
                System.out.println(ll.size());
                for (int i = 0; i < ll.size(); i++) {
                    System.out.println(ll.get(i));
                    g2.draw(new Rectangle2D.Float(rectangleX, rectangleY, rectangleWH, rectangleWH));
                    g2.drawString(Integer.toString(ll.get(i)), rectangleX + 10, rectangleY + 25);
                    g2.draw(new Line2D.Float(rectangleX + rectangleWH, rectangleWH / 2 + rectangleY, rectangleX + linesDistance, rectangleWH / 2 + rectangleY));
                    if (i == ll.size() -1 ){
                        g2.drawString("null", rectangleX + 110, rectangleY + 25);
                    }
                    rectangleX = rectangleX + linesDistance;
                }
            }
        });
        find_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Graphics g = getGraphics();
                int value = Integer.parseInt(find.getText());
                LinkedList<Integer> ll = ownLinkedList.getLinkedList();
                int index = ownLinkedList.searchByValue(value);

                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));

                rectangleY = 270;
                rectangleX = 30;
                for (int i = 0; i < ll.size(); i++) {
                    g2.setColor(Color.BLACK);
                    if (i == index - 1){
                        g2.setColor(Color.gray);
                    }
                    g2.draw(new Rectangle2D.Float(rectangleX, rectangleY, rectangleWH, rectangleWH));
                    g2.drawString(Integer.toString(ll.get(i)), rectangleX + 10, rectangleY + 25);
                    g2.draw(new Line2D.Float(rectangleX + rectangleWH, rectangleWH / 2 + rectangleY, rectangleX + linesDistance, rectangleWH / 2 + rectangleY));
                    if (i == ll.size() -1 ){
                        g2.drawString("null", rectangleX + 110, rectangleY + 25);
                    }
                    rectangleX = rectangleX + linesDistance;
                }
            }
        });
    }
}

