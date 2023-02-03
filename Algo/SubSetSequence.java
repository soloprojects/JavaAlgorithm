package Algo;

import java.util.ArrayList;
import java.util.List;

public class SubSetSequence {

    public ArrayList<String> subSequence(String str, String word){

        ArrayList<String> list = new ArrayList<>();
        if(word.isEmpty()){
            list.add(str);
            return list;
        }

        char extract = word.charAt(0);

        ArrayList<String> list1 = subSequence(str + extract, word.substring(1));
        ArrayList<String> list2 =subSequence(str, word.substring(1));

        list.addAll(list1);
        list.addAll(list2);

        return list;

    }

    public ArrayList<String> subSequenceAscii(String str, String word){

        ArrayList<String> list = new ArrayList<>();
        if(word.isEmpty()){
            list.add(str);
            return list;
        }

        char extract = word.charAt(0);

        ArrayList<String> list1 = subSequenceAscii(str + extract, word.substring(1));
        ArrayList<String> list2 = subSequenceAscii(str, word.substring(1));
        ArrayList<String> list3 = subSequenceAscii(str+(extract + 0), word.substring(1));

        list.addAll(list1);
        list.addAll(list2);
        list.addAll(list3);

        return list;

    }

    public List<List<Integer>> subSequenceArr(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        ArrayList<Integer> empty = new ArrayList<>();
        outer.add(empty);

        for(int num : arr){

            int n = outer.size();

            for (int i = 0; i < n; i++) {
                ArrayList<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }

        }

        return outer;

    }

}
