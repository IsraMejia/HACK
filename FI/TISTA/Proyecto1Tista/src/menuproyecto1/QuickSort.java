/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuproyecto1;

import java.util.LinkedList;

/**
 *
 * @author Edgar
 */
public class QuickSort {

    public static int partition(LinkedList<Integer> list, int low, int high){
        int pivot = list.get(high); 
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++){
            // If current element is smaller than or
            // equal to pivot
            if (list.get(j) <= pivot)
            {
                i++;
                 // swap arr[i] and arr[j]
                int temp = list.get(i);
                list.add(i,list.get(j));
                list.add(j,temp);
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = list.get(i+1);
        list.add(i+1,list.get(high));
        list.add(high,temp);
        return i+1;
    }
  
    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public static void sort(LinkedList<Integer> arr, int low, int high){
        if (low < high){
            /* pi is partitioning index, arr[pi] is 
              now at right place */
            int pi = partition(arr, low, high);
            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
     /* A utility function to print array of size n */
    static void printArray(LinkedList<Integer> arr)
    {
        
        for(Integer node : arr){
                System.out.print(""+node+",");}
                System.out.println(" ");
                
            
        System.out.println();
    }
 
    // Driver program
    public static void main(String args[])
    {
        LinkedList<Integer> arr = new LinkedList<> ();
        int n = arr.size();
        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n);
        System.out.println("sorted array");
        printArray(arr);
    }

}
