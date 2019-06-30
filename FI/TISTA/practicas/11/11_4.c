#include <stdio.h>
#include <omp.h>

int main()
{
	#pragma omp parallel num_threads(3)
	{	
			int i;
			printf("Hola Mundo\n");
			for(i = 0; i<10;i++)
				printf("iteracion: %d\n", i);
	}
	printf("adios\n");
	return 0;
}
