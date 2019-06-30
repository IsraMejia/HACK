#ifndef _fGenericas.h_
#define _fGenericas.h_

void swap(int *a, int *b){
/*En esta funcion se realiza los intercambios del contenido varibles cuando se mandan a
llamar, apoyandose de una variable temporal para no perder el valor de a, asi como
de los apuntadores para cambiar el contenido de las variables */
    int t = *a;
    *a = *b;
    *b = t;
}

void printArray(int arr[],int size){
/*imprime el arreglo cuando se manda a llamar la funcion, apoyandose de un ciclo for*/
    int i;
    for (i=0; i < size ; i++)
        printf("%d ", arr[i]);
    printf("\n");
}
#endif
