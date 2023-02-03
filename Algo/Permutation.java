package Algo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Permutation {

    public ArrayList<String> permutate(String newStr, String str){

        ArrayList<String> list = new ArrayList<>();
        if(str.length() == 0){
            list.add(newStr);
            return list;
        }
        char subStr = str.charAt(0);

        for (int i = 0; i <= newStr.length(); i++) {

            String start = newStr.substring(0,i);
            String end = newStr.substring(i,newStr.length());
            String shape = start + subStr + end;

            ArrayList<String> perm = permutate(shape, str.substring(1));
            list.addAll(perm);
        }

        return list;

    }

    public ArrayList<String> phonePad(String newStr, String str){

        ArrayList<String> list = new ArrayList<>();
        if(str.length() == 0){
            list.add(newStr);
            return list;
        }
        int subStr = str.charAt(0) - '0';

        for (int i = (subStr - 1) * 3; i < (subStr * 3); i++) {

            char start = (char)(i + 'a');
            String shape = newStr + start;

            ArrayList<String> perm = phonePad(shape, str.substring(1));
            list.addAll(perm);
        }

        return list;

    }

    public ArrayList<String> diceRoll(String newStr, int target){

        ArrayList<String> list = new ArrayList<>();
        if(target == 0){
            list.add(newStr);
            return list;
        }

        for (int i = 1; i <= target; i++) {

            String shape = newStr + i;

            ArrayList<String> perm = diceRoll(shape, target - i);
            list.addAll(perm);
        }

        return list;

    }

}
