package view;

import controller.OwnArray;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

public class UIArray extends JFrame {
    private static final long serialVersionUID = 1L;

    JPanel p1, p2, p3;
    JTextField ins, del, find, pos;
    JButton ins_but, del_but, find_but, show_but;
    JLabel hs_heading, notation;
    int rectangleX = 30;
    int rectangleY = 150;
    int rectangleWH = 50;
    int linesDistance = 50;


    UIArray() {
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
        hs_heading = new JLabel("Arrays");
        notation = new JLabel("Big O(1)");
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
        OwnArray ownArray = new OwnArray();
        ownArray.start();
        show_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Graphics g = getGraphics();
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));
                int rectangleX = 30;
                int rectangleY = 180;
                int rectangleWH = 50;
                int linesDistance = 50;
                int [] arr = ownArray.getNums();
                for (int i = 0; i < arr.length; i++) {
                    g2.draw(new Rectangle2D.Float(rectangleX, rectangleY, rectangleWH, rectangleWH));
                    g2.drawString(Integer.toString(i), rectangleX + 10, rectangleY + 25);
                    rectangleX = rectangleX + linesDistance;
                }
                rectangleY = 230;
                rectangleX = 30;
                for (int i = 0; i < arr.length; i++) {
                    g2.draw(new Rectangle2D.Float(rectangleX, rectangleY, rectangleWH, rectangleWH));
                    g2.drawString(String.valueOf(arr[i]), rectangleX + 10, rectangleY + 25);
                    rectangleX = rectangleX + linesDistance;
                }
            }
        });
        ins_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(ins.getText());
                int index = Integer.parseInt(pos.getText());
                int [] arr = ownArray.getNums();
                int[] newArr = ownArray.addAnyPosition(arr, value, index);
                Graphics g = getGraphics();
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));

                rectangleY = 300;
                rectangleX = (50 * index) - 20;
                g2.setColor(Color.orange);
                g2.draw(new Rectangle2D.Float(rectangleX, rectangleY, rectangleWH, rectangleWH));
                g2.drawString(Integer.toString(value), rectangleX + 10, rectangleY + 25);
                rectangleX = rectangleX + linesDistance;

                rectangleY = 370;
                rectangleX = 30;
                for (int i = 0; i < newArr.length; i++) {
                    g2.setColor(Color.BLACK);
                    if (i == index - 1){
                        g2.setColor(Color.orange);
                    }
                    g2.draw(new Rectangle2D.Float(rectangleX, rectangleY, rectangleWH, rectangleWH));
                    g2.drawString(Integer.toString(newArr[i]), rectangleX + 10, rectangleY + 25);
                    rectangleX = rectangleX + linesDistance;
                }
            }
        });
        del_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = Integer.parseInt(del.getText());
                int [] arr = ownArray.getNums();
                int[] newArr = ownArray.deleteFromAnyPosition(arr, index);
                Graphics g = getGraphics();
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));

                rectangleY = 300;
                rectangleX = 30;
                for (int i = 0; i < newArr.length; i++) {
                    g2.draw(new Rectangle2D.Float(rectangleX, rectangleY, rectangleWH, rectangleWH));
                    g2.drawString(Integer.toString(newArr[i]), rectangleX + 10, rectangleY + 25);
                    rectangleX = rectangleX + linesDistance;
                }
            }
        });
        find_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(find.getText());
                int [] arr = ownArray.getNums();
                int index = ownArray.searchByValue(value);
                Graphics g = getGraphics();
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));

                rectangleY = 300;
                rectangleX = 30;
                if (index >= 0){
                    for (int i = 0; i < arr.length; i++) {
                        g2.setColor(Color.BLACK);
                        if (i == index){
                            g2.setColor(Color.orange);
                        }
                        g2.draw(new Rectangle2D.Float(rectangleX, rectangleY, rectangleWH, rectangleWH));
                        g2.drawString(Integer.toString(arr[i]), rectangleX + 10, rectangleY + 25);
                        rectangleX = rectangleX + linesDistance;
                    }

                }

            }
        });
    }
}
