package Algo;

public class DynamicProgramming {

    public int houseRobber(int[] houseFunds){

        if(houseFunds.length == 2){
            return Math.max(houseFunds[0], houseFunds[1]);
        }

       int formerMax = houseFunds[0];
       int currentMax = Math.max(houseFunds[0], houseFunds[1]);

       for(int i = 2; i < houseFunds.length; i++){

           int temp = currentMax;
           currentMax = Math.max(formerMax + houseFunds[i], temp);
           formerMax = temp;

       }

        return currentMax;

    }

    public int knapSack(int[] mainValue, int[] mainWeight, int maxWt){

        int n = mainValue.length;

        int[][] table = new int[mainValue.length + 1][maxWt + 1];
        int[] value = addZeroToBeginOfArray(mainValue);
        int[] weight = addZeroToBeginOfArray(mainWeight);

        for(int i = 0; i <= n; i++){

            for(int w = 0; w <= maxWt; w++){

                if(i == 0 || w == 0){
                    table[i][w] = 0;
                }
                else if(weight[i] <= w){
                    table[i][w] = Math.max(value[i] + table[i - 1][w - weight[i]], table[i - 1][w]);
                }
                else if(weight[i] > w){
                    table[i][w] = table[i - 1][w];
                }
                System.out.print(table[i][w]+", ");

            }
            System.out.println("");

        }

        return table[n][maxWt];

    }

    public int[] addZeroToBeginOfArray(int[] arr){
        int[] newArr = new int[arr.length + 1];
        newArr[0] = 0;
        for(int i = 0; i < arr.length; i++){

            newArr[i + 1] = arr[i];

        }
        return newArr;
    }

}
