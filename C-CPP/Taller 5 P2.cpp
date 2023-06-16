#include <iostream>
#include <conio.h>
#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <time.h>

using namespace std;


void crearMatriz();
void llenar(int **matrizPtr, int filasM, int columnasM);
void sumar(int **matrizPtr, int filasM, int columnasM);

int filasM, columnasM;
int **matrizPtr;



int main(){
	
	crearMatriz();	
	for(int contador = 0;contador < filasM; contador++){
    	delete[] matrizPtr[contador];
    }	
    delete[] matrizPtr;
    return 0;
}


void crearMatriz(){
	
	printf("Por favor ingrese el numero de filas: ");
	//scanf("%d", filasM);
	cin>>filasM;
	printf("\nPor favor ingrese el numero de columnas: ");
	//scanf("%d", columnasM);
	cin>>columnasM;
	system("cls");
	
	matrizPtr = new int*[filasM];
	for(int contador = 0; contador < filasM; contador++){
		matrizPtr[contador] = new int[columnasM];
	}
	
	llenar( matrizPtr, filasM, columnasM);
}

void llenar(int **matrizPtr, int filasM, int columnasM){
	srand(time(NULL));
	for (int contador = 0; contador < filasM; contador++){
   		for (int contador2 = 0; contador2 < columnasM; contador2++){
		   //matrizPtr[contador][contador2] = (rand()%255)+1;
		   *(*(matrizPtr + contador) + contador2) = (rand()%99)+1; 
    	}
	}
	
    printf("Imprimiendo matriz:\n\n");
    for (int i=0;i<filasM;i++){
        for(int j=0;j<columnasM;j++){
            printf("  [%d] ",*(*(matrizPtr+i)+j)); //puntero_matriz[i][j]
        }
        printf("\n");
	}
	
	sumar(matrizPtr, filasM, columnasM);
	
}

void sumar(int **matrizPtr, int filasM, int columnasM){
	
	int suma = 0, vecAux[columnasM], mayor=0, filaMayor=0;
	
	for(int fila = 0;fila < filasM; fila++){
		suma=0;
    	for(int columna = 0; columna < columnasM; columna++){
			suma += *(*(matrizPtr + fila) + columna);
    	}
    	vecAux[fila] = suma;
	}

	printf("------------------------------------\n");
	for(int contador = 0; contador < filasM; contador++){
		printf("Fila %d = [%d]\n",contador + 1, vecAux[contador]);
	}	
	
	for (int contador = 0; contador < sizeof(vecAux) / sizeof(vecAux[0]); contador++){
		if (vecAux[contador] > mayor){
			mayor = vecAux[contador];
			filaMayor = contador;
		} 
	}
	printf("\n\nLa fila que tiene el mayor valor es la: %d con el valor de %d\n\n", filaMayor+1, mayor);	
}
