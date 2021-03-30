package controller;

import java.util.stream.IntStream;

public class OwnArray extends OwnDataStructure{
    int nums[];

    public int[] getNums() {
        return nums;
    }

    public void setNums(int[] nums) {
        this.nums = nums;
    }

    public void start(){
        nums = new int[4];
        nums[0] = 28;
        nums[1] = 14;
        nums[2] = 17;
        nums[3] = 30;
    }

    public int[] addAnyPosition(int[] nums, int number, int position){
        int n = nums.length;
        int newArr[] = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            if (i < position - 1)
                newArr[i] = nums[i];
            else if (i == position - 1)
                newArr[i] = number;
            else
                newArr[i] = nums[i - 1];
        }
        return newArr;
    }

    public int[] deleteFromAnyPosition(int[] nums, int index){
        if (nums == null
                || index - 1 < 0
                || index - 1 >= nums.length) {

            return nums;
        }

        return IntStream.range(0, nums.length)
                .filter(i -> i != index - 1)
                .map(i -> nums[i])
                .toArray();
    }

    public int searchByValue(int target){
        for (int i= 0; i< nums.length; i++) {
            if (nums[i] == target) {
                return i; // found it!
            }
        }
        return -1; // couldn’t find it
    }

    public boolean searchByPosition(int index){
        if (nums[index] != 0){
            return true;
        };
        return false;
    }

    public void print(){
        for (int i= 0; i< nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}

