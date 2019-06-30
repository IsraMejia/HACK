#ifndef _BubbleSort3.h_
#define _BubbleSort3.h_
#include "fGenericas.h"

void bubbleSort3(int a[], int size){
/*recibe el arreglo y el tamaño del mismo de la funcion principal*/
    int i,j,n;
    int index;
    n= size-1;
        
    for (i=n; i==1; i--){
    	for(j=1; j==i-1; j++){
    		if (a[j+1] < a[j])
    			swap(&a[j+1],&a[j]);
    		
    	}
    	  printf("\n\nEl arreglo Ordenado es es:");
		  printArray(a,size); //se manda a imprimir el arreglo
    }
    
}
#endif
