/*Actividad 1: completar la version serie y paralela del ejemplo 
mayor de los elementos de un arreglo unidimensional de enteros*/
#include <stdio.h>
#include <omp.h>
 int buscarMaximo(int *a, int n);
 int buscarMaximoparalelo(int *a, int n);
 int main(){
 	printf("Actividad 1");
 	int a[10]={0,1,2,3,4,10,6,7,8,9};
 	int b=10;
 	printf("\n\nllamando a buscar maximo de forma en serie = %d", buscarMaximo(a, b));
 	printf("\n--------------------------------------------------");
 	printf("\n\nllamando a buscar maximo de forma paralela = %d", buscarMaximoparalelo(a, b));
 }

 int buscarMaximo(int *a, int n){
 	int max, i;
 	max=a[0];
  		for(i=1; i<n; i++){
 		if(a[i]>max)
 			max=a[i];
 		}
	return max; 		
 }

 int buscarMaximoparalelo(int *a, int n){
 	int max, i;
 	max=a[0];
 	#pragma omp parallel
 	{
 		#pragma omp parallel for 
//divide  las iteraciones del ciclo en distintos hilos
// haciendolos paralelos con parallel for
 		for(i=1; i<n; i++){
 		if(a[i]>max){
 				if(a[i]>max){
 					#pragma omp critical
 					{
 						if(a[i]>max)
 							max=a[i];
/*Se usa la directiva critical para que la variable max sea usada por un hilo a
 la vez y esta no se este actualizando de manera incesaria durante la paralelizacion
 cabe destacar que antes de actualizar a max se verifica si realmente se cumple esto 
 en esos momentos con el uso del con el ultimo if */
 					}
 				}
 					
 		}
 		}
 	}
	return max; 		
 }

