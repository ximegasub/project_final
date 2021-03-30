package controller;

import java.util.LinkedList;

public class OwnLinkedList extends OwnDataStructure{
    LinkedList<Integer> linkedList;

    public LinkedList<Integer> getLinkedList() {
        return linkedList;
    }

    public void setLinkedList(LinkedList<Integer> linkedList) {
        this.linkedList = linkedList;
    }

    public void start(){
        linkedList = new LinkedList<Integer>();
        linkedList.add(22);
        linkedList.add(42);
        linkedList.add(7);
        linkedList.add(14);
    }

    public void addAnyPosition(int number, int position){
//        LinkedList<Integer> newLinkedListist = (LinkedList<Integer>) linkedList.clone();
        if (linkedList.isEmpty()){
            if (position == 1){
                linkedList.addFirst(number);
            }else{
                linkedList.addLast(number);
            }
        }else if(position - 1 >= linkedList.size()){
            linkedList.addLast(number);
        }else{
            linkedList.add(position - 1, number);
        }
//        return newLinkedListist;
    }

    public LinkedList<Integer> deleteFromAnyPosition(int index){
//        LinkedList<Integer> newLinkedListist = (LinkedList<Integer>) linkedList.clone();
        if (!linkedList.isEmpty()
                && index - 1 >= 0
                && index - 1 <= linkedList.size()) {

//            return newLinkedListist;
            System.out.println(index);
            if (index == 1) {
                System.out.println("1");
                linkedList.removeFirst();
            } else if (index == linkedList.size()) {
                System.out.println("last");
                System.out.println(linkedList.removeLast());
            } else {
                System.out.println("any");
                linkedList.remove(index - 1);
            }
        }
        return linkedList;
    }

    public boolean searchByPosition(int index){
        if (linkedList.get(index-1) != null){
            return true;
        };
        return false;
    }

    public int searchByValue(int target){
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i) == target) {
                return i + 1; // found it!
            }
        }
        return -1; // couldn’t find it
    }

    public void print(){
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " ");
        }
    }

}
