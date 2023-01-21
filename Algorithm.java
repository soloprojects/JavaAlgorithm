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
        Sorting sort = new Sorting();
        //sort.bubble(arr2, 0, 0);
        //sort.recursiveQuickSort(arr2, 0, arr2.length - 1);
        //System.out.print(Arrays.toString(arr2));
        General general = new General();
        //System.out.println(general.rotatedArrPeak(arr3));
        System.out.println(general.rotatedArr(arr3, 5));
       //System.out.println(general.floorBinarySearch(arr,-1));


    }


}





