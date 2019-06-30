//Actividad 5
#include <omp.h>
#include <stdio.h>

int main(){
	int a[5],i;
	#pragma omp parallel
	{
		#pragma omp for
		for (i=0;i<5;i++)
			a[i]=i*i;
			
		#pragma omp master
			for(i=0; i<5; i++)
				printf("a[%d]= %d\n",i,a[i]);
		
		#pragma opm barrier
		
		#pragma omp for
		for(i=0;i<5;i++)
			a[i]+=i;	
	}	
	
	printf("----------------------------------------------------------");
	printf("\nQuitando la barrera\n");
	
	#pragma omp parallel
	{
		#pragma omp for
		for (i=0;i<5;i++)
			a[i]=i*i;
			
		#pragma omp master
			for(i=0; i<5; i++)
				printf("a[%d]= %d\n",i,a[i]);
		
	//	#pragma opm barrier
		
		#pragma omp for
		for(i=0;i<5;i++)
			a[i]+=i;	
	}
	/*Al quitar la barrera los hilos realizan sus operaciones sin fijarse 
	si el hilo maestro ya acabo de imprimir */
	
	printf("----------------------------------------------------------");
	printf("\nUsando el constructor single \n");	
		#pragma omp parallel
	{
		#pragma omp for
		for (i=0;i<5;i++)
			a[i]=i*i;
			
		#pragma omp single
			for(i=0; i<5; i++)
				printf("a[%d]= %d\n",i,a[i]);
		
	//	#pragma opm barrier
		
		#pragma omp for
		for(i=0;i<5;i++)
			a[i]+=i;	
	}
	/*Al usar el constructor single todos los demas hilos esperan que esté termine
	de imrpimir para continuar, es como si ya tuviera su propia barrera*/

}

