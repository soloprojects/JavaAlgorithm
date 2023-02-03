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

    public int splitArrayLargestSum(int[] arr){

        int start = 0;
        int end = 1;
        int tempF = 0;
        int tempS = 0;
        int ans = 0;
        int max = 0;

        while(end < arr.length){
            //int tempStart = start;
            while(start < end){
                tempF+= arr[start];
                start ++;
            }

            while(start < arr.length){
                tempS+= arr[start];
                start ++;
            }

            max = (tempF > tempS) ? tempF : tempS;

            if(ans > 0){
                ans = (max < ans) ? max : ans;
            }else{
                ans = max;
            }
            start = 0;
            end += 1;
            tempF = 0;
            tempS = 0;

        }
        return ans;

    }

    public int[] binarySearchMatrixSorted(int[][] matrix, int target){



        int rowS = 0, rowE = matrix.length - 1;
        int colS = 0, colE = matrix[0].length - 1;
        int colM = (colS + colE)/2;
        if(matrix.length == 1) return binarySearchMatrix(matrix, 0, 0, colE, target);
        while(rowS < (rowE - 1)){
            int rowM = rowS + (rowE - rowS)/2;

            if(matrix[rowM][colM] == target){
                return new int [] {rowM, colM};
            }

            if (target < matrix[rowM][colM]) {
                rowE = rowM;
            }else{
                rowS = rowM;
            }

        }

        if(matrix[rowS][colM] == target){
            return new int[] {rowS, colM};
        }

        if(matrix[rowE][colM] == target){
            return new int[] {rowE, colM};
        }


        if(target < matrix[rowS][colM]){
            return binarySearchMatrix(matrix, rowS, 0, colM - 1, target);
        }

        if(target > matrix[rowS][colM] && target <= matrix[rowS][colE]) {
            return binarySearchMatrix(matrix, rowS, colM+1, colE, target);
        }


        if(target < matrix[rowE][colM]){
            return binarySearchMatrix(matrix, rowE, 0, colM - 1, target);
        }else{
            return binarySearchMatrix(matrix, rowE, colM+1, colE, target);
        }

    }

    public static int[] binarySearchMatrix(int[][] matrix, int row, int colS, int colE, int target){

        while(colS <= colE){
            int mid =  colS + (colE - colS)/2;
            int pivot = matrix[row][mid];

            if(pivot == target) return new int[] {row, mid};

            if(target > pivot){
                colS = mid + 1;
            }else{
                colE = mid - 1;
            }


        }

        return new int[] {-1, -1};

    }

    public void gun(int numb, int start){ //start 0, numb = 4

        if(numb == 0) return;

        if(start < numb){
            start++;
            System.out.print(start+" ");
            step(numb,start);


        }else{

            System.out.println("");
            step(numb - 1, 0);
        }


    }

    public void step(int numb, int start){ //start = 0, numb = 1

        if(numb > 4) return;

        if(start < numb){
            start++;
            System.out.print(start+" ");
            step(numb,start);


        }else{

            System.out.println("");
            step(numb + 1, 0);
        }


    }


}
