package controller;

import java.util.ArrayList;

public class OwnArrayList extends OwnDataStructure{
    ArrayList<Integer> arrList;

    public ArrayList<Integer> getArrList() {
        return arrList;
    }

    public void setArrList(ArrayList<Integer> arrList) {
        this.arrList = arrList;
    }

    public void start(){
        arrList = new ArrayList<Integer>();
        arrList.add(15);
        arrList.add(22);
        arrList.add(30);
        arrList.add(40);
    }

    public void addAnyPosition(ArrayList<Integer> arrList, int number, int position){
        arrList.add(position-1, number);
    }

    public void deleteFromAnyPosition(ArrayList<Integer> arrList, int index){
        if (arrList != null
                && index - 1 >= 0
                && index - 1 <= arrList.size()) {
            arrList.remove(index - 1);
        }
    }

    public boolean searchByPosition(int index){
        if (arrList.get(index-1) != null){
            return true;
        };
        return false;
    }

    public int searchByValue(int target){
        if (arrList.indexOf(target) != -1){
            return arrList.indexOf(target); // found it!
        }
        return -1; // couldn’t find it
    }

    public void print(){
        for (Integer number : arrList) {
            System.out.println("Number = " + number);
        }
    }
}
