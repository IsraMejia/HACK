#include <stdio.h>
#include <omp.h>

int main()
{	int i;
	#pragma omp parallel
	{	
			
			printf("Hola Mundo\n");
			for(i = 0; i<10;i++)
				printf("iteracion: %d\n", i);
	}
	printf("adios\n");
	return 0;
}
