/*/En la primera version me equivoque al llamar los archivos 
y ciertos detallitos que ya corregi*/
#include <stdio.h>
#include "BubbleSort.h"
#include "QuickSort.h"
#include "BubbleSort2.h"
#include "BubbleSort3.h"

int main(){
    int arr[] = {1,29,6,3,99,3,44,2,7,225};
    int size = sizeof(arr)/sizeof(arr[0]);
    //Se verifica  el tamano del arreglo
    
    //QuickSort (arr, 0, size-1); 
    /*Se manda a llamar la funcion QuickSort de su archivo y se manda el arreglo,
	un cero y el tamaño del arreglo-1 (9)*/
	
    //bubbleSort(arr,size);
    /*Se manda a llamar la funcion bubbleSort de su archivo y se manda el arrego 
	asi como su tamaño*/
	
	//bubbleSort2(arr,size); 
	//para el BubbleSort Descendente
	
	bubbleSort3(arr,size);
	// para el psudocodigo hecho en clase
    
    printf("Arreglo ordenado: \n");
    printArray(arr,size); //Se manda a imprimir el arreglo ordenado
    return 0;
}
