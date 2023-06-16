/*
programacion avanzada
02/02/2022
Lab sesion 3
Santiago Mesa
Mateo Infante
Grupo 5   
*/


#include <iostream>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

void intro();
void llenarDatos();
void multiplicar(int *matriz1[], int f1, int c1,int *matriz2[], int f2, int c2);

int main(){
    intro();
    llenarDatos();

}

void intro(){

    printf("==============================================================\n");
    printf("=====  Bienvenido al programa multiplicador de matrices  =====\n");
    printf("==============================================================\n\n");
    printf("En este programa podra multiplicar 2 matrices de M * N y N * P");
    printf("\nDebe tener en cuenta que si la matriz no es valida tendra que"
           "\ningresar los datos de nuevo\n\n");
    system("pause");
    system("cls");
}

void llenarDatos(){

    int filas1 = 0, columnas1 = 0, filas2 = 0, columnas2 = 0;


    printf("\nPor favor ingrese las dimensiones de la primera matriz\n");
    printf("\nNumero de filas: ");
    scanf("%d", &filas1);
    printf("\nNumero de columnas: ");
    scanf("%d",&columnas1);

    system("cls");

    printf("\nPor favor ingrese las dimensiones de la segunda matriz\n");
    printf("\nNumero de filas: ");
    scanf("%d", &filas2);
    printf("\nNumero de columnas: ");
    scanf("%d",&columnas2);
    system("cls");

    int matrizUsuario1[filas1][columnas1];
    int matrizUsuario2[filas2][columnas2];
    int *matriz1[filas1];
    int *matriz2[filas2];

    for (int i = 0; i < filas1; ++i) {
        matriz1[i] = matrizUsuario1[i];
    }
    for (int i = 0; i < filas2; ++i) {
        matriz2[i] = matrizUsuario2[i];
    }

    int f1 = filas1;
    int c1 = columnas1;
    int f2 = filas2;
    int c2 = columnas2;

    if(columnas1 != filas2){
        system("cls");
        printf("\nNo es posible multiplicar las matrices");
        printf("\nPor favor intente nuevamente");
        exit(-1);
    }

    printf("Por favor ingrese los datos de la primera matriz\n\n");
    for (int contador = 0; contador < filas1; contador++) {
        for (int contador2 = 0; contador2 < columnas1; contador2++){
            printf ("Ingrese el valor para la posicion [%d][%d]: ", contador + 1, contador2 + 1);
            scanf ("%d", &matrizUsuario1[contador][contador2]);
        }
    }

    printf("\n\nPor favor ingrese los datos de la segunda matriz\n\n");

    for (int contador = 0; contador < filas2; contador++) {
        for (int contador2 = 0; contador2 < columnas2; contador2++) {
            printf ("Ingrese el valor para la posicion [%d][%d]: ", contador + 1, contador2 + 1);
            scanf ("%d", &matrizUsuario2[contador][contador2]);
        }
    }
    system("cls");

    multiplicar( matriz1, f1, c1, matriz2, f2, c2);

}

void multiplicar(int *matriz1[], int f1, int c1,int *matriz2[], int f2, int c2){

    int matrizMultiplicada[f1][c2];

    for (int a = 0; a < c2; a++) {
        for (int i = 0; i < f1; i++) {
            int suma = 0;
            for (int j = 0; j < c1; j++) {
                //suma += matriz1[i][j] * matriz2[j][a];
                suma += (*(*(matriz1+i)+j)) * (*(*(matriz2+j)+a));
            }
            matrizMultiplicada[i][a] = suma;
        }
    }

    printf("Las matrices originales son: \n\n");
    printf("//// MATRIZ 1////\n\n");

    for (int i=0;i<f1;i++){
        for (int j=0;j<c1;j++){
            printf("\t[%d] ", *(*(matriz1+i)+j));
        }
        printf("\n");
    }

    printf("\n\n//// MATRIZ 2////\n\n");

    for (int i=0;i<f2;i++){
        for (int j=0;j<c2;j++){
            printf("\t[%d] ", *(*(matriz2+i)+j));
        }
        printf("\n");
    }


    printf("\n\n///////////////////////////////////////////////////////\n\n");

    printf("La matriz multiplicada es: \n\n");
    for (int i = 0; i < f1; i++) {
        for (int j = 0; j < c2; j++) {
            printf("\t[%d] ", matrizMultiplicada[i][j]);
        }
        printf("\n");
    }


}