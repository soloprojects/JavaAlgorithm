package Algo;

import java.util.ArrayList;
import java.util.Arrays;

public class Sorting {

    public void recursiveSelection(int[] arr, int index, int count){
        if(count == (arr.length-1)) return;

        if(index == (arr.length - 1)){
            recursiveSelection(arr, 0, count + 1);
        }else{

            if(arr[index] > arr[index + 1]){
                int temp2 = arr[index + 1];
                int temp1 = arr[index];
                arr[index] = temp2;
                arr[index + 1] = temp1;
                recursiveSelection(arr, index + 1, count);
            }else{
                recursiveSelection(arr, index + 1, count);
            }

        }


    }

    public void iterativeSelection(int[] arr){
        for(int i = 0; i < arr.length; i++){

            for(int j = i+1; j< arr.length; j++){
                if(arr[i] > arr[j]){
                    int temp1 = arr[i];
                    int temp2 = arr[j];
                    arr[i] = temp2;
                    arr[j] = temp1;
                }
            }
        }
    }

    public void iterativeBubble(int[] arr){
        boolean isSwapped;
        for(int i = 0; i < arr.length; i++){
            isSwapped = false;
            for(int j = 0; j< arr.length -1; j++){
                if(arr[j] > arr[j+1]){
                    int temp1 = arr[j];
                    int temp2 = arr[j+1];
                    arr[j] = temp2;
                    arr[j+1] = temp1;
                    isSwapped = true;
                }
            }
            if(isSwapped == false) break;
        }
    }

    public void iterativeInsertion(int[] arr){
        for(int i = 1; i< arr.length; i++){
            int temp = arr[i];
            int j = i - 1;
            while(j>=0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j = j -1;
            }
            arr[j+1] = temp;
        }
    }

    public void recursiveQuickSort(int[] arr, int low, int high){

        if(low >= high) return;

        int s = low;
        int e = high;

        int mid = s + (e - s)/2;
        int num = arr[mid];

        while(s <= e){
            while(arr[s] < num){
                s++;
            }
            while(arr[e] > num){
                e--;
            }

            if(s <= e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }

        }
        recursiveQuickSort(arr,low, e);
        recursiveQuickSort(arr, s, high);

    }

    public void cycleSort(int[] arr){
        int i = 0;
        while (i < arr.length){
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]){
                int temp = arr[i];
                int temp2 = arr[correct];
                arr[correct] = temp;
                arr[i] = temp2;
            }else{
                i++;
            }

        }

    }

    public int cycleSortDuplicateNumber(int[] arr){
        int i = 0;
        while (i < arr.length){
            int correct = arr[i] - 1;
            int temp = arr[i];
            int temp2 = arr[correct];
            if(temp == temp2) return temp;
            if(arr[i] != arr[correct]){
                arr[correct] = temp;
                arr[i] = temp2;
            }else{
                i++;
            }

        }
        return 0;

    }

    public ArrayList<Integer> cycleSortDuplicateNumberArr(int[] arr){
        int i = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (i < arr.length){
            int correct = arr[i] - 1;
            int temp = arr[i];
            int temp2 = arr[correct];
            if(temp == temp2 && (arr[i] - 1) != i){
                boolean check = list.contains(temp);
                if(!check) {
                    list.add(temp);
                }
                i++;

            }else
            if(arr[i] != arr[correct]){
                arr[correct] = temp;
                arr[i] = temp2;
            }else{
                i++;
            }

        }
        System.out.println(Arrays.toString(arr));
        return list;

    }


}
