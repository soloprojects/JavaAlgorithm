//import Algo.BinarySearch;
import Algo.*;
public class Algorithm {

    public static void main(String[] args){

        BinarySearch search = new BinarySearch();
        int [] arr = {-1,0,1,2,3,4,7,9,19,20};
        int val = search.binarySearch(arr, 0, 9, 4);
        System.out.println(val);

    }


}





