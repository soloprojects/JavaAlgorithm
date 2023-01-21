package Algo;
import java.util.*;

public class General {

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

    public int ceilingBinarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        if(target >= arr[arr.length - 1]) return arr[0];

        while(start <= end){
            int mid =  start + (end - start)/2;
            int pivot = arr[mid];

            if(target < pivot){
                end = mid - 1;
            }else{
                start = mid + 1;
            }


        }

        return arr[start];

    }

    public int floorBinarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        if(target <= arr[0]) return arr[arr.length - 1];

        while(start <= end){
            int mid =  start + (end - start)/2;
            int pivot = arr[mid];

            if(target > pivot){
                start = mid + 1;
            }else{
                end = mid - 1;
            }


        }

        return arr[end];

    }

    public int[] searchFirstLastIndex(int [] arr, int target){
        int[] result = {-1,-1};
        int first = searchIndex(arr, target, true);
        int last = searchIndex(arr, target, false);

        result[0] = first;
        arr[1] = last;

        return result;

    }

    public int searchIndex(int[] arr, int target, boolean boolBack){

        int start = 0;
        int end = arr.length - 1;
        int last = -1;

        while(start <= end){
            int mid =  start + (end - start)/2;
            int pivot = arr[mid];

            if(target > pivot){
                start = mid + 1;
            }
            if(target < pivot){
                end = mid - 1;
            }
            if(target == pivot){
                last = mid;
                if(boolBack){

                    end = mid - 1;

                }else{
                    start = mid + 1;
                }

            }


        }

        return last;

    }

    public static int mountainPeak(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int mid =  start + (end - start)/2;
            int pivot = arr[mid];

            if(arr[mid] < arr[mid + 1]){
                start = mid + 1;
            }
            if(arr[mid] > arr[mid + 1]){
                end = mid;
            }


        }

        return arr[start];

    }

    public int rotatedArrPeak(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int mid =  start + (end - start)/2;
            int pivot = arr[mid];

            if(pivot > arr[mid + 1]) return mid;
            if(start > arr[mid]){
                end = mid;
            }
            if(start < arr[mid]){
                start = mid;
            }


        }

        return start;

    }

    public int rotatedArr(int[] arr, int target){

        int peak = rotatedArrPeak(arr);

        BinarySearch search = new BinarySearch();

        int leftArr = search.binarySearch(arr, 0, peak, target);
        if(leftArr != -1){
            return leftArr;
        }else{
            return search.binarySearch(arr, peak + 1, arr.length - 1, target);
        }

    }


}
