public class InsertionSort{  
    public static void insertionSort(int array[]) {  
        int n = array.length;  
        for (int j = 1; j < n; j++) {  
            int key = array[j];  
            int i = j-1;  
            while ( (i > -1) && ( array [i] > key ) ) {  
               // i>-1 y ar[j-1]> ar[j]
                array [i+1] = array [i];//ar[j]=ar[j-1] 
                i--;  
            }  
            array[i+1] = key; //ar[j] = llave 
        }  
    } 
}