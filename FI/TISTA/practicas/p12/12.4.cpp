//Actividad 4
#include <omp.h>
#include <stdio.h>
#define N 100000
int main(int argc, char *argv[]){
	printf("\n\t\t Actividad 4\nSuma de arreglos ");
	printf("\n\n A continuacion se mostrara el tiempo que se tarda en realizar ");
	printf("\n los calculos de forma paralela usando el constructor section"); 
	
	double empezar, terminar;
	int i,j;
	float a[N], b[N], c[N], d[N], e[N], f[N];
	#pragma omp parllel for 
	for(i=0; i<N;i++)
		a[i]=b[i]=i*1.0;
	
	empezar=omp_get_wtime();	
	
	#pragma omp parllel for 
	for(i=0;i<N;i++)
		c[i]=a[i]+b[i];	
	
	/*for(j=0;j<N;j++)
			d[j]=e[j]+f[j];	*/	
	
	terminar=omp_get_wtime();
	printf("TIEMPO=%lf\n",empezar-terminar); 
	
	printf("\n---------------------------------------------------");
	printf("\nA continuacion se realizara de forma paralela ");
	#pragma omp parallel sections
	{
		#pragma omp sections
		{
		for(i=0; i<N;i++)
			a[i]=b[i]=i*1.0;
			empezar=omp_get_wtime();	
		}		
		
	
		#pragma omp sections
		{
		for(i=0;i<N;i++)
		c[i]=a[i]+b[i];	
		}
		
		/*#pragma omp sections
		{
		for(j=0;j<N;j++)
			d[j]=e[j]+f[j];		
		}*/
	
	}
			
	terminar=omp_get_wtime();
	printf("TIEMPO=%lf\n",empezar-terminar); 
	
}

