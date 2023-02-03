//import Algo.BinarySearch;
import Algo.*;
import java.util.*;

public class Algorithm {

    public static void main(String[] args){

        BinarySearch search = new BinarySearch();
        int [] arr = {-1,0,1,2,3,4,7,9,19,20};
//        int val = search.binarySearch(arr, 0, 9, 4);
        //System.out.println(val);

//        Patterns patterns = new Patterns();
//        patterns.gun(4,0);
//        patterns.step(1,0);

        int [] arr2 = {4,7,3,9,5,2,1};
        int [] arr3 = {3,4,5,6,7,0,1,2};
        int [] arr4 = {1,2,3,4,5};
        int [][] arr5 = {{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}};
        int [] arr6 = {4,6,3,7,5,2,1};
        int [] arr7 = {4,6,3,0,5,2,1};
        int [] arr8 = {4,6,3,3,5,2,1};
        int [] arr9 = {4,6,3,3,5,2,1,1};
        int [] arr10 = {1,2,3,4};

        Sorting sort = new Sorting();
        //sort.bubble(arr2, 0, 0);
        //sort.recursiveQuickSort(arr2, 0, arr2.length - 1);
        //System.out.print(Arrays.toString(arr2));
        General general = new General();
        //System.out.println(general.rotatedArrPeak(arr3));
        //System.out.println(Arrays.toString(general.binarySearchMatrixSorted(arr5, 16)));
       //System.out.println(general.floorBinarySearch(arr,-1));
        //sort.cycleSort(arr6);

        //System.out.println(sort.cycleSortDuplicateNumberArr(arr9));
        //general.step(0,1);

        SubSetSequence sub = new SubSetSequence();
        //System.out.println(sub.subSequence("","abc"));
        //System.out.println(sub.subSequenceAscii("","abc"));
        //System.out.println(sub.subSequenceArr(arr10));

        Permutation perm = new Permutation();
        System.out.println(perm.diceRoll("", 4));




    }


}





