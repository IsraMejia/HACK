#include <stdio.h>
#define LENGTH 10

int heapSize;

void printArray(int arr[],int size){
int i;
  	for (i=0; i < size; i++)
       	printf("%d ", arr[i]);
    	printf("\n");
/*Con ayuda de un ciclo for imprime el arreglo que le mandan  
apoyandose del tamaño que igual recibe */
}

void Heapify(int* A, int i){
  int l = 2 * i + 1;
  //para saber el nodo hoja de padre par
  int r = 2 * i + 2;
  //para saber el nodo hoja de padre par
  int smaller;

  if(l <= heapSize && A[l] < A[i])
     smaller = l;
/*Si no se sale el indice y el hijo es MENOR al padre se le
asigna a smaller (indice de comparacion) el hijo*/
  else
    smaller = i;
//caso contrario el padre conserva el indice de comparacion
  if(r <= heapSize && A[r] < A[smaller])
    smaller = r;
/*Si no se sale el indice y el hijo es MENOR al padre se le
asigna a smaller el hijo*/
  if(smaller != i)
  //si el indice de comparacion no es par
    {
      printArray(A,LENGTH);
      int temp = A[i];
      A[i] = A[smaller];
      A[smaller] = temp;
/*manda a imprimir el arreglo e intercambia, para despues intercambiar la 
posicion el valor del ultimo indice de comparacion con el indice que sera igual 
a la ultima comparacion por lo que se entiende que lo que queda a la izquierda ya 
esta ordenado*/
      Heapify(A, smaller);
      //se vuelve hacer lo anterior
     }
}

void BuildHeap(int* A){
  heapSize = LENGTH - 1; 
  int i; 
  for(i = (LENGTH - 1) / 2; i >= 0; i--)
    Heapify(A, i);
/*Las iteraciones necesarias para el heap y las hace sobre heapify*/    
  printf("Termino de construir el HEAP \n\n");
}

void HeapSort(int* A){
  BuildHeap(A); 
  /*manda a llamar la funcion BuildSort para recibir el heap*/
  int i,d=0;
  //for(i = LENGTH - 1; i > 0; i--){
	for(i=0; i<LENGTH-1; i++){	          
      int temp = A[d];
      A[d] = A[0];
      A[0] = temp;
      heapSize--;
      
      printf("Iteracion HS: \n");
	  Heapify(A, 0);
/*Elimina la raiz asignandola al arreglo ordenado y lo demas lo manda a 
que se vuelva a hacer el heap */
 			
    }
}

int main(){
  int prueba[LENGTH] = {10,4,12,6,70,5,8,23,31,38};
  HeapSort(prueba);
  //manda a realizar el heapsort
  int i;
  //for(i = 0; i < LENGTH; i++)
  for(i=LENGTH-1; i>-1;i--) 
/*Para cambia a orden descendente de la impresion del arreglo ordenado*/
    printf("%d ",prueba[i]);
//imprime el arreglo ordenado
  return 0;
}



