#ifndef _QuickSort.h_
#define _QuickSort.h_
#include "fGenericas.h"

void printSubArray (int arr[], int low, int high){
    int i;
    for (i=low;i<=high;i++)
            printf("%d ", arr[i]);
        printf("\n");
/*Funcion para imprimir los subarreglos que le manden*/
}

int partition (int arr[],int low, int high){
    int pivot = arr[high];
    //Se define al privote como la ultima posicion del arreglo
    printf("Pivote: %d \n ", pivot);
    int j,i = (low - 1);
    for (j = low; j <= high - 1; j++){
        if (arr[j] <= pivot){ 
            i++;
            swap(&arr[i],&arr[j]);
    /*De ser menor o igual el valor de la variable a comparar con 
	la del pivote, realizar el intercambio de posicion*/
        }
    }
    swap(&arr[i+1], &arr[high]); 
    return (i+1);
}

void QuickSort(int arr[],int low, int high){
/*Dentro de esta funcion se mandan a llamar las necesarias para realizar el ordenamiento, recibe
 el arreglo, un cero y el tamaño del arreglo-1 (9)*/
    if(low < high){  //si hay mas de un elemeto
    	int pi = partition(arr, low, high); 
// se manda a llamar la funcion partition, mandando los parametros recibidos en QuickSort
        printf("Sub array 1 (de %d): \t ",arr[pi]);
        printSubArray(arr,low,pi-1); 
        QuickSort(arr,low,pi-1);
        printf("Sub array 2: (de %d): \t ",arr[pi]);
        printSubArray(arr,pi+1,high);
        QuickSort(arr,pi + 1, high);
/*Se manda a imrpimir el subarreglo uno y dos con la posicion del ultimo indice uno menor al pivote 
respectivamente, de igual manera se vuelve a realizar la funcion QuickSort en estos subarreglos, para poder
ordenar todos los elementos del mismo*/
    }
}
#endif

