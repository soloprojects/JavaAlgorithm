package Algo;

import java.util.ArrayList;

public class Maze {

    public int mazePath(int row, int col){

        if(row == 1 || col == 1){
            return 1;
        }

        int rowPath = mazePath(row - 1, col);
        int colPath = mazePath(row, col - 1);

        return rowPath + colPath;

    }

    public int mazePathDiagonal(int row, int col){

        if(row == 1 || col == 1){
            return 1;
        }

        int rowPath = mazePath(row - 1, col);
        int colPath = mazePath(row, col - 1);
        int diagPath = mazePath(row - 1, col - 1);

        return rowPath + colPath + diagPath;

    }

    public int mazePathObstruction(int row, int col){

        if(row == 2 || col == 2){
            return 1;
        }

        if(col == 1 && row == 1){
            return 0;
        }

        int rowPath = mazePathObstruction(row + 1, col);
        int colPath = mazePathObstruction(row, col + 1);

        return rowPath + colPath;

    }

    public ArrayList<String> mazeDirections(String newStr, int row, int col){

        ArrayList<String> list = new ArrayList<>();

        if(col == 1 && row == 1){
            list.add(newStr);
            return list;
        }
        if(row >1){
            ArrayList<String> rowPath = mazeDirections(newStr + "D", row - 1, col);
            list.addAll(rowPath);
        }
        if(col > 1){
            ArrayList<String> colPath = mazeDirections(newStr + "R", row, col - 1);
            list.addAll(colPath);
        }

        return list;

    }

    public ArrayList<String> mazeDiagDirections(String newStr, int row, int col){

        ArrayList<String> list = new ArrayList<>();

        if(col == 1 && row == 1){
            list.add(newStr);
            return list;
        }
        if(row > 1){
            ArrayList<String> rowPath = mazeDiagDirections(newStr + "V", row - 1, col);
            list.addAll(rowPath);
        }
        if(col > 1){
            ArrayList<String> colPath = mazeDiagDirections(newStr + "H", row, col - 1);
            list.addAll(colPath);
        }
        if(row > 1 && col > 1){
            ArrayList<String> diagPath = mazeDiagDirections(newStr + "D", row -1, col - 1);
            list.addAll(diagPath);
        }



        return list;

    }

    public ArrayList<String> mazeAllPath(boolean[][] matrix, String newStr, int row, int col){

        ArrayList<String> list = new ArrayList<>();

        if(row == matrix.length - 1 && col == matrix[0].length - 1){
            list.add(newStr);
            return list;
        }

        if(!matrix[row][col]){
            return list;
        }

        matrix[row][col] = false;

        if(row < matrix.length -1){
            ArrayList<String> DPath = mazeAllPath(matrix,newStr + "D", row + 1, col);
            list.addAll(DPath);
        }
        if(col < matrix[0].length -1 ){
            ArrayList<String> RPath = mazeAllPath(matrix,newStr + "R", row, col + 1);
            list.addAll(RPath);
        }
        if(row > 0){
            ArrayList<String> UPath = mazeAllPath(matrix,newStr + "U", row -1, col);
            list.addAll(UPath);
        }

        if(col > 0){
            ArrayList<String> LPath = mazeAllPath(matrix,newStr + "L", row, col - 1);
            list.addAll(LPath);
        }


        matrix[row][col] = true;
        return list;

    }

}
