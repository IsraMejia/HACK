#include <stdio.h>
#include <omp.h>

double prodpuntoSerie(double *a, double *b, int n);
double prodpuntoParalelo1(double *a, double *b, int n);
double prodpuntoParalelo2(double *a, double *b, int n);

 int buscarMaximo(int *a, int n);
 int main(){
 	printf("\n\tActividad 2 - producto punto de dos vectores de n elementos");
 	int x=0; 	
 	do{
 		printf("\n Escoja la actividad que quiera ver:\t");
 		printf("1)	Serie");
 		printf("2)	paralela 1");
 		printf("3)	paralela 2");
 		printf("4)Salir	");
 		scanf("%d",&x);
 		switch(x){
 			case 1:
 				printf("\Entraste a la opcion en Serie");
 				double a[10]={0,1,2,3,4,5,6,7,8,9};
 				double b[10]={9,8,7,6,5,4,3,2,1,0};
 				int f=10;
 				double xD=prodpuntoSerie(*a,*b,f);
 				printf("%d",xD);
 				//printf("El resultado es ",prodpuntoSerie(*a,*b,f));
 			break;
 			
 			case 2:
 				printf("\Entraste a la opcion en paralelo 1");
 				double c[10]={0,1,2,3,4,5,6,7,8,9};
 				double d[10]={9,8,7,6,5,4,3,2,1,0};
 				int e=10;
 				printf("\n El reslultado en paralelo 1 es: %lf",prodpuntoParalelo1(*c,*d,e));
 			break;
 			
 			case 3:
 				printf("\Entraste a la opcion en paralelo 2");
 				double f[10]={0,1,2,3,4,5,6,7,8,9};
 				double g[10]={9,8,7,6,5,4,3,2,1,0};
 				int h=10;
 				printf("\n El reslultado en paralelo 2 es: %lf",prodpuntoParalelo2(*f,*g,h));
 			break;
 			
 			case 4:printf("\n Ha salido ;D");break;
 			
 		}
 		
 	}while (x!=4);
 }
 
 double prodpuntoSerie(double *a, double *b, int n){
 	double res=0;
 	int i; 	
 	for(i=0; i<n:i++){
 		res+=a[i]*b[i];
 	}
 	return res;
 }
 
  double prodpuntoParalelo1(double *a, double *b, int f){
 	double res=0, resp[n_hilos];
 	int i,tid,nth;
 	#pragma omp parallel private (tid) nthreads(n_hilos)
 	{
 		tid= omp_get_thread_num();
 		resp[tid]=0;
 		#pragma omp for
 			for(i=0; i<f:i++){
 				resp[tid]+=a[i]*b[i];
 			}	
 			
 		if(tid==0){
 			nth= omp_get_num_threads();
 			for(i=0;i<nth;i++){
 				res+=resp[i];
 			}
 		}
 	}
 	
 	return res;
/*Se paraleliza las iteraciones del ciclo usasndo la directiva parallel for, 
cabe mencionar que se utilizo a resp[] para almacenar el resultado parcial de cada 
hilo, para que mas tarde sean sumandos y nos de el resultado total*/ 	
 }
 
 
 double prodpuntoParalelo2(double *a, double *b, int n){
 	double res=0;
 	int i;
 	#pragma omp parllel for reduction(+,res)
 	for(i=0; i<n;i++){
 			res+=a[i]*b[i];
 	}
 	return res;
 /* Esta funcion es una mas optimisada de prodpuntoParalelo1 ya que se evita todo lo 
 anterior usando unicamente la clausula reduction la cual almacena el resuldato 
 de cada hilo para que al final solo se sumen los valores quedando en una sola 
 variable, para ello se utilizo el operador de reduccion +*/	
}
 
