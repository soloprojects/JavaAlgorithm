package Algo;

public class Patterns {

    //GUN PATTERN
    public void gun(int row, int col){
        if(row == 0) return;

        if(col < row){
            if(col > 0){
                System.out.print(col);
            }

            gun(row, col + 1);
        }else{
            System.out.println(row);
            gun(row-1, 0);
        }

    }

    //STEP PATTERN
    public void step(int row, int col){
        if(row == 5) return;

        if(col < row){
            if(col > 0){
                System.out.print(col);
            }
            step(row, col + 1);
        }else{
            System.out.println(row);
            step(row+1, 0);
        }

    }

}
