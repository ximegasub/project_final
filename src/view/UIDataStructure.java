package view;

import javax.swing.*;

public class UIDataStructure {
    JFrame frame ;

    public JFrame draw(String dataType){

        if(dataType == null){
            return null;
        }
        if(dataType.equalsIgnoreCase("ARRAY")) {
            frame = new UIArray();

        } else if(dataType.equalsIgnoreCase("ARRAYLIST")){
            frame = new UIArrayList();

        } else if(dataType.equalsIgnoreCase("LINKEDLIST")){
            frame = new UILinkedList();

        } else if(dataType.equalsIgnoreCase("HASHSET")) {
            frame = new UIHashSet();

        } else if(dataType.equalsIgnoreCase("BST")){
            frame = new UIBinarySearchTree();
        }

        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }
}
