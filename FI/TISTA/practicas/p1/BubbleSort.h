#ifndef _BubbleSort.h_
#define _BubbleSort.h_
#include "fGenericas.h"
void bubbleSort(int a[], int size){
/*recibe el arreglo y el tamaño del mismo de la funcion principal*/
    int i,j;
    int index;
    i= size-1;
    while (i>0){
        index = 0; 
        for(j=0;j<i;j++){
            if(a[j+1]<a[j]){
                swap(&a[j],&a[j+1]);
                index=j;
/*Se compara al la variable que va delante de la que se selecciona con el valor
 del indice de j, en caso de que esta sea menor, se intercambia los valores y se le
 asigna al indice el valor actual de j, para de esta manera no se repitan las 
 comparaciones */
            }
            printArray(a,size); //se manda a imprimir el arreglo
        }
        printf("Fin Iteracion \n");
        i=index; // se le asigna a i el tamaño del ultimo indice comparado
    }
}
#endif
