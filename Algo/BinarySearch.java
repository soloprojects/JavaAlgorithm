package Algo;
import java.util.*;
import Algo.*;

import java.util.Stack;

public class BinarySearch {

    public static void main(String[] args){

        BinarySearch search = new BinarySearch();
        int [] arr = {-1,0,1,2,2,4,7,9,19,20};
//        int val = search.binarySearch(arr, 0, 9, 4);
//        System.out.println(val);

        General gen = new General();
        System.out.println(gen.findMultiple(arr,2, 0));

    }

    public int binarySearch(int[] arr, int start, int end, int numb){

        if(start > end) return -1;
        int split = (start+end)/2;
        if(arr[split] == numb ) return numb;

        if(arr[split] > numb) return binarySearch(arr, start, split-1, numb);
        if(arr[split] < numb) return binarySearch(arr, split+1,end, numb);
        return -1;
    }

    public void preOrderRecursive(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data+" ");
        preOrderRecursive(node.left);
        preOrderRecursive(node.right);

    }

    public void inOrderRecursive(Node node){
        if(node == null){
            return;
        }
        inOrderRecursive(node.left);
        System.out.print(node.data+" ");
        inOrderRecursive(node.right);

    }

    public void postOrderRecursive(Node node){
        if(node == null){
            return;
        }
        inOrderRecursive(node.left);
        inOrderRecursive(node.right);
        System.out.print(node.data+" ");

    }

    public void preOrderIterative(Node node){
        if(node == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            Node current = stack.pop();
            System.out.print(current.data+" ");

            if(current.right != null){
                stack.push(current.right);
            }
            if(current.left != null){
                stack.push(current.left);
            }

        }

    }

    public void inOrderIterative(Node node){
        if(node == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        Node current = stack.pop();
        while(!stack.isEmpty() || current != null){
            if(current != null){
                stack.push(current);
                current = current.left;
            }else{
                current = stack.pop();
                System.out.print(current.data+" ");
                current = current.right;
            }

        }

    }

    public static void postOrder(Node root) {

        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while(!stack.isEmpty() || current != null){
            if(current != null){
                stack.push(current);
                current = current.left;
            }else{
                current = stack.pop();

                if(current.right != null){
                    //stack.push(current.right);
                    Node holdRight = current.right;
                    current.right = null;
                    current.left = null;
                    stack.push(current);
                    current = holdRight;
                }else{

                    System.out.print(current.data+" ");
                    current = current.right;
                }

            }

        }

    }

}




