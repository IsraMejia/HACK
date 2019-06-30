#include <stdio.h>

void radixsort(int arr[], int n);
int ElementoMax(int arr[], int n);
void Radix(int arr[], int n, int exp);
void print(int arr[], int n);

int main (){
	
	int arr[] = {170, 45, 75, 90,4001, 802, 24, 2, 66,234};
    int n = sizeof(arr)/sizeof(arr[0]);
    radixsort(arr, n);
   // print(arr, n);
	
	return 0;
}

void radixsort(int arr[], int n){
    //Encuentra al numero maximo para saber el numero de digitos
    int m = ElementoMax(arr, n);
    printf("\nEl elemento maximo es %d\n",m);
 
    /*Realiza counting sort para cada digito, tomando en cuenta
	que al pasar cada digito su exp=10^i, con su valor en el ciclo*/
    for (int exp = 1; m+1/exp > 0; exp *= 10)
        Radix(arr, n, exp);//exp-1 ya acomoda al 4001
}
 
 int ElementoMax(int arr[], int n){
//compara uno a uno todos los elementos y se coloca al final del arreglo el 
//mayor elemento
    int mx = arr[0];
    for (int i = 1; i < n+1; i++)
        if (arr[i] > mx)
            mx = arr[i];
    return mx;
}
 	

void Radix(int arr[], int n, int exp){
//realiza Radix sort deacuerdo al digito del exponente de esta forma se comparan
//las unidades entre ellas
    int output[n]; // arreglo de salida
    int i,it=0, count[10] = {0};
 
    // Store count of occurrences in count[]
    for (i = 0; i < n; i++){ 	
    	count[ (arr[i]/exp)%10 ]++;
		printf("%d ",arr[i]);
    } printf("Iteracion \n"); //ITERACIONES uno a uno (una por linea)
        
 /*Cambia al arreglo count[i] para que tenga la posicion actual
 de su digito en el de output[], Se suman el num de veces repetidas */
    for (i = 1; i < 10; i++){
    	count[i] += count[i - 1];
    	//printf("%d", count[i]);
	}
        

    // construye el arreglo de salida, para mas tarde asignarselo al original
    for (i = n - 1; i >= 0; i--)
    {
        output[count[ (arr[i]/exp)%10 ] -1] = arr[i];
        count[ (arr[i]/exp)%10 ]--;
       
    }
 
    /*Se le asigna los valores del arreglo de salida al original*/
    for (i = 0; i < n; i++)
        arr[i] = output[i];
}
	
void print(int arr[], int n){
	//imprime los elementos del arreglo con ayuda de un ciclo for
    for (int i = 0; i < n; i++)
        printf("%d ",arr[i]);
}
 
 
 
