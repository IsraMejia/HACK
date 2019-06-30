void merge(int arr[], int l, int m, int r)//arr, 0, 3, 7
{ //arr[] = arr, l=0, m=3, r=7
    int i, j, k;
    int n1 = m - l + 1; //3-0+1 -> n1=4
    int n2 =  r - m;// 7-3 -> n2=4
 
    int L[n1], R[n2]; //se declaran los dos subarreglos left right
 
    for (i = 0; i < n1; i++)// i<4
        L[i] = arr[l + i]; //0+1
    for (j = 0; j < n2; j++)// i<4
        R[j] = arr[m + 1+ j]; //3+1+j -> 4+j
 
   	i = 0; 
    j = 0; 
	k = l; //k=0
    
	while (i < n1 && j < n2) //0<4 y 0<4, mientras no sea menor a 0 los indices
    {
        if (L[i] <= R[j])
        { //L[0] <= R[0]
            arr[k] = L[i]; //arr[0] = L[0]
            i++;//i=1;
        }
        else
        {
            arr[k] = R[j];//arr[0] = R[0]
            j++; //j=1;
        }
        k++; //k=1; para aumentar el incide en la funcion original
        //De esta manera se reacomodan en el arreglo original los dos subarreglos
    }
 

    while (i < n1)  //4<4 las une en una lista
    {
        arr[k] = L[i];
        i++;
        k++;
    }
 
  
    while (j < n2) // las une en una lista
    {
        arr[k] = R[j];
        j++;
        k++;
    }
   
}
 

void mergeSort(int arr[], int l, int r)// recibe el arreglo, 0, tamaño del arreglo
{// arr[]= el arreglo, l=0, r= tamaño del arreglo
    if (l < r) //0<7
    {
        
        int m = l+(r-l)/2; //m= 0+(7-0)/2
 		//m=3
        
        mergeSort(arr, l, m); //arr, 0, 3
        mergeSort(arr, m+1, r); //arr, 4, 7 
 
        merge(arr, l, m, r); //arr, 0, 3, 7
    }
}

