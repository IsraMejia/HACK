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
	
		for(i=0; i<N;i++)
			a[i]=b[i]=i*1.0;
			empezar=omp_get_wtime();	
		
		for(i=0;i<N;i++)
		c[i]=a[i]+b[i];	
	
		for(j=0;j<N;j++)
			d[j]=e[j]+f[j];		
		
	
	
			
	terminar=omp_get_wtime();
	printf("TIEMPO=%lf\n",empezar-terminar); 
	
}
