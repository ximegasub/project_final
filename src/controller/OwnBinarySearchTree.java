package controller;

import common.Node;

public class OwnBinarySearchTree {
    static String p = " ";

    public static String insertNode(int value, Node nodeMain, int left, int down) {
        Node newNode = new Node(value);
        if (nodeMain.value > newNode.value && nodeMain.left != null) {
            if (left == 400 && down == 200)
                insertNode(newNode.value, nodeMain.left, left - 100, down + 60);
            else
                insertNode(newNode.value, nodeMain.left, left - 30, down + 30);
        }

        else if (nodeMain.value < newNode.value && nodeMain.right != null) {
            if (left == 400 && down == 200)
                insertNode(newNode.value, nodeMain.right, left + 100, down + 60);
            else
                insertNode(newNode.value, nodeMain.right, left + 30, down + 30);
        }

        else if (nodeMain.left == null && nodeMain.value > newNode.value) {
            nodeMain.left = newNode;

            if (left == 400 && down == 200)
                p = String.valueOf(left - 100) + " " + String.valueOf(down + 60) + " " + String.valueOf(left) + " "
                        + String.valueOf(down);
            else
                p = String.valueOf(left - 30) + " " + String.valueOf(down + 30) + " " + String.valueOf(left) + " "
                        + String.valueOf(down);
            return p;

        } else if (nodeMain.right == null && nodeMain.value < newNode.value) {
            nodeMain.right = newNode;

            if (left == 400 && down == 200)
                p = String.valueOf(left + 100) + " " + String.valueOf(down + 60) + " " + String.valueOf(left) + " "
                        + String.valueOf(down);

            else
                p = String.valueOf(left + 30) + " " + String.valueOf(down + 30) + " " + String.valueOf(left) + " "
                        + String.valueOf(down);
            return p;

        }
        return p;
    }
}
