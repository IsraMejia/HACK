#ifndef _BubbleSort2.h_
#define _BubbleSort2.h_
#include "fGenericas.h"

void bubbleSort2(int a[], int size){
/*recibe el arreglo y el tamaño del mismo de la funcion principal*/
    int i,j;
    int index;
    i= size-1;
    while (i>0){
        index = 0; 
        for(j=0;j<i;j++){
            if(a[j+1]>a[j]){
//AQUI se cambio la comparacion para que se haga en forma DESCENDETE
//al cambiar el menor que a mayor que, el cambio se hace al lado contrario, por
//lo que termina en descente
                swap(&a[j+1],&a[j]);
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

