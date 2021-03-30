package controller;

import java.util.LinkedList;

public class OwnHashSet extends OwnDataStructure{
    LinkedList<String>[] buckets;

    public LinkedList<String>[] getBuckets() {
        return buckets;
    }

    public void setBuckets(LinkedList<String>[] buckets) {
        this.buckets = buckets;
    }

    public void start(){
        buckets = new LinkedList[5];
        for (int i= 0; i< 5; i++) {
            buckets[i] = new LinkedList<String>();
        }
    }

    public void start(int size){
        buckets = new LinkedList[size];
        for (int i= 0; i< 5; i++) {
            buckets[i] = new LinkedList<String>();
        }
    }

    public LinkedList<String>[] addAnyPosition(String value){
        if (!contains(buckets, value)) {
            int index = hashCode(value) % buckets.length;
            LinkedList<String> bucket = buckets[index];
            bucket.addFirst(value);
            return buckets;
        }
        return buckets;
    }

    private int hashCode(String value) {
        return value.length();
    }

    public boolean contains(LinkedList<String>[] buckets, String value) {
        int index = hashCode(value) % buckets.length;
        LinkedList<String> bucket = buckets[index];
        return bucket.contains(value);
    }

    public LinkedList<String>[] deleteFromAnyValue(LinkedList<String>[] buckets, String value) {
        if (!contains(buckets, value)) {
            int index = hashCode(value) % buckets.length;
            System.out.println("index" +index);
            LinkedList<String> bucket = buckets[index];
            bucket.remove(value);
            return buckets;
        }
        return buckets;
    }

    public void print(){
        for (int i = 0; i < buckets.length; i++) {
            System.out.println(buckets[i]);
        }
    }

    public boolean searchByPosition(int index){
        if (buckets[index - 1] != null){
            return true;
        };
        return false;
    }

    public int searchByValue(int target){
        return -1;
    }

//    public boolean searchByValue(int target){
//        for (int i = 0; i < buckets.length; i++) {
//            for (int j = 0; j < buckets[i].size(); j++) {
//                if (buckets[i].get(j) == target) {
//                    return true; // found it!
//                    break;
//                }
//            }
//        }
//        return false;
//    }
}
