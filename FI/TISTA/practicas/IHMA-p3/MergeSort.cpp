#include <stdio.h>
#include "merge.h"

void printArray(int A[], int size){
	int i;
	for(i=0; i<size ; i++)
		printf("%d \t", A[i]);
	printf("\n");
}

int main(){
	int arr[]= {1,5,3,4,7,9,11};
	int arr_size= sizeof(arr) / sizeof (arr[0]);
	
	printf("Arreglo Original \n");
	printArray(arr, arr_size);
	
	mergeSort(arr, 0 , arr_size-1); 
	/*Se tiene que mandar el tamaño del arreglo menos uno para 
	que no se desborde en las operaciones de margeSort por tener unicamente los 
	espacios necesarios para los subarreglos que se crean en esta funcion
	en este arreglo */
	printf("\n Arreglo ordenado \n");
	printArray(arr, arr_size);
	return 0;
	
}
