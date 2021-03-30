package common;

//public class common.Node {  //standard Binary Tree node
//    Object data;
//    common.Node left;
//    common.Node right;
//    int xpos;  //stores x and y position of the node in the tree
//    int ypos;
//
//    common.Node(String x, common.Node l, common.Node r) {
//        left = l;
//        right = r;
//        data = (Object) x;
//    }
//}
public class Node{
    public Node left = null;
    public Node right = null;
    public int value;

    public Node(int val){
        this.value = val;
    }
}