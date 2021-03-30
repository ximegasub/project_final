package view;

import controller.OwnHashSet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;

public class UIHashSet extends JFrame {
    private static final long serialVersionUID = 1L;

    JPanel p1, p2, p3;
    JTextField ins, del, find, tam;
    JButton ins_but, del_but, find_but;
    JLabel hs_heading, notation;
    int rectangleX = 30;
    int rectangleY = 130;
    int rectangleWH = 50;
    int linesDistance = 80;

    UIHashSet() {
        //Creating UI
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        ins = new JTextField(7);
        del = new JTextField(7);
        find = new JTextField(7);
        tam = new JTextField(7);
        ins_but = new JButton("Insert");
        del_but = new JButton("Delete");
        find_but = new JButton("Find");
        hs_heading = new JLabel("Hash Set");
        notation = new JLabel("Big O(1)");
        Font f1 = new Font("Arial", Font.BOLD, 50);
        Font f2 = new Font("Arial", Font.ITALIC, 20);
        hs_heading.setFont(f1);
        notation.setFont(f2);
        p1.setBounds(0, 0, 800, 100);
        p1.add(hs_heading);
        p1.add(notation);
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        p2.add(tam);
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

        ins_but.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String value = ins.getText();
                int size = Integer.parseInt(tam.getText());
                OwnHashSet ownHashSet = new OwnHashSet();
                ownHashSet.start(size);
                LinkedList<String>[] bucket = ownHashSet.addAnyPosition(value);
                Graphics g = getGraphics();
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));
                rectangleX = 30;
                rectangleY = 130;
                rectangleWH = 50;
                linesDistance = 80;
                for (int i = 0; i < bucket.length; i++) {
                    rectangleX = 30;
                    g2.draw(new Rectangle2D.Float(rectangleX, rectangleY, rectangleWH, rectangleWH));
                    g2.drawString(Integer.toString(i), rectangleX + 10, rectangleY + 25);
                    if (!bucket[i].isEmpty()){
                        System.out.println(bucket[i]);
                        g2.draw(new Line2D.Float(rectangleX + rectangleWH, rectangleWH / 2 + rectangleY, rectangleX + linesDistance, rectangleWH / 2 + rectangleY));
                        rectangleY = rectangleY + linesDistance;
                        rectangleX = 110;
                        for (int j = 0; j < bucket[i].size(); j++) {
                            g2.draw(new Rectangle2D.Float(rectangleX, rectangleY - linesDistance, rectangleWH, rectangleWH));
                            g2.drawString(bucket[i].get(j), rectangleX + 10, rectangleY - linesDistance + 25);
                            g2.draw(new Line2D.Float(rectangleX + rectangleWH, rectangleWH / 2 + rectangleY  - linesDistance, rectangleX + linesDistance, rectangleWH / 2 + rectangleY  - linesDistance));
                            if (j == bucket[i].size() - 1) {
                                g2.drawString("null", rectangleX + 110, rectangleY - linesDistance + 25);
                            }
                            rectangleX = rectangleX + linesDistance;
                        }
                    }else{
                        rectangleY = rectangleY + linesDistance;
                    }

                }
            }
        });
    }
}


