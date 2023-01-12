package Algo;

import java.util.ArrayList;

public class General {

    public static void main(){
        General gen = new General();
        gen.reduce(14);
    }

    public int reduce(int numb){
        if(numb < 1){
            return 0;
        }
        int hold;
        int count;
        int rem = numb%2;
        int mid = numb/2;
        hold = numb - 1;
        if(rem == 0){
            hold = mid;
        }
        //System.out.println(count);
        return reduce(hold) + 1;

    }

    public boolean sorted(int [] arr, int index){

        if(index == (arr.length -1)){
            return true;
        }

        if(arr[index] < arr[index +1]){
            return sorted(arr, index +1);
        }
        return false;

    }

    public ArrayList<Integer> findMultiple(int [] arr, int target, int index){

        ArrayList<Integer> list = new ArrayList<>();

        if(index == arr.length){
            return list;
        }

        if(arr[index] == target){
            list.add(target);
        }

        ArrayList<Integer> find = findMultiple(arr, target, index + 1);

        list.addAll(find);
        return list;

    }

    public Integer countMultiple(int [] arr, int target, int index){

        ArrayList<Integer> list = new ArrayList<>();

        if(index == arr.length){
            return list.size();
        }

        if(arr[index] == target){
            list.add(target);
        }

        Integer find = list.size() + countMultiple(arr, target, index + 1);

        return find;

    }



}
