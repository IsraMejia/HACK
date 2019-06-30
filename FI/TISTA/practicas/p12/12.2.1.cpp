#include <stdio.h>
#include <omp.h>
#include <time.h>
 int buscarMaximo(int *a, int n);
 int main(){
	double a[10]={0,1,2,3,4,5,6,7,8,9};
	double b[10]={9,8,7,6,5,4,3,2,1,0};
 	int n=10;
 	clock_t t_inicio, t_fin;
	double seg;	
	t_inicio=clock();
 	printf("\nA continuacion se mostrara el producto punto realizado en serie:");
 		
 	double res=0;
 	int i; 	
 	for(i=0; i<n;i++)
 		res+=a[i]*b[i];
 		t_fin=clock();
 		seg=(double)(t_fin - t_inicio)/CLOCKS_PER_SEC;
	 printf("\n%lf ",res);	
	 printf("El tiempo de calculo del producto punto en serie es: %lf segundos ",seg);
	 
	 printf("\n\nA continuacion se mostrara el producto punto realizado en Paralelo:");
	res=0; double resp[4];
	int tid,nth;
	t_inicio=clock();
	#pragma omp parallel private (tid)
	#pragma omp nthreads(n_hilos)
	{
		tid= omp_get_thread_num();
		resp[tid]=0;
		#pragma omp for
			for(i=0;i<n;i++){
				resp[tid]+=a[i]*b[i];
			}
		if(tid==0){
			nth= omp_get_num_threads();
			for(i=0;i<n;i++){
				res+=resp[i];
			}
		}
	}
	printf("\n%lf ",res);
	t_fin=clock();
	seg=(double)(t_fin - t_inicio)/CLOCKS_PER_SEC;	
	printf("\nEl tiempo de calculo del producto punto en serie es: %lf segundos ",seg);
		
/*Se paraleliza las iteraciones del ciclo usasndo la directiva parallel for, 
cabe mencionar que se utilizo a resp[] para almacenar el resultado parcial de cada 
hilo, para que mas tarde sean sumandos y nos de el resultado total*/ 	
 

	printf("\n\n\nEntraste a la opcion en paralelo 2");
	t_inicio=clock();
 	res=0;
 	#pragma omp parllel for reduction(+,res)
 	for(i=0; i<n;i++){
 			res+=a[i]*b[i];
 	}
 	t_fin=clock();
 		seg=(double)(t_fin - t_inicio)/CLOCKS_PER_SEC;	 
	 printf("\nEl tiempo de calculo del producto punto en serie es: %lf segundos ",seg);
 	printf("\nEl resultado de paralelizacion 2 es: %lf",res);
 /* Esta funcion es una mas optimisada de prodpuntoParalelo1 ya que se evita todo lo 
 anterior usando unicamente la clausula reduction la cual almacena el resuldato 
 de cada hilo para que al final solo se sumen los valores quedando en una sola 
 variable, para ello se utilizo el operador de reduccion +*/	

 				
 	
 }
 
