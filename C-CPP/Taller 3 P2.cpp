/*
programacion avanzada
02/02/2022
Lab sesion 3
Santiago Mesa
Mateo Infante
Grupo 5
*/

#include <iostream>
#include <string>
#include <ostream>
#include <math.h>
#include <time.h>

void crearArreglos(int *arreglo_1, int *arreglo_2, int numElementos);
int * sumaArreglos(int arreglo1[], int arreglo2[], int numElementos);

using namespace std;

int main(){
    cout<<"------ PROGRAMA PARA SUMAR ARREGLOS ------"<<endl<<endl;
    cout<<"----- Ingrese tamano de los arreglos -----"<<endl<<endl;
    cout<<"-- Tamano: ";
    int numElementos;
    cin>>numElementos;
    fflush(stdin);
    cout<<endl<<endl;
    int arreglo1[100];
    int arreglo2[100];
    cout<<"---- A continuacion se crearan los dos arreglos aleatoriamente ----"<<endl<<endl;
    crearArreglos(arreglo1, arreglo2, numElementos);
    cout<<"---- Se continuara con la suma de los dos arreglos ----"<<endl<<endl;
    int *apuntadorRegreso;
    apuntadorRegreso=sumaArreglos(arreglo1, arreglo2, numElementos);
    cout<<"--- Se mostrara la ubicacion del apuntador regresado por la funcion ---"<<endl<<endl;
    cout<<"--- Apuntador: "<<apuntadorRegreso<<endl<<endl;
}

void crearArreglos(int *arreglo_1, int *arreglo_2, int numElementos){
    cout<<"---- Creacion arreglo 1 ----"<<endl<<endl;
    srand(time(NULL));
    for(int i=0; i<numElementos; i++){
        *arreglo_1= rand() % 100;
        cout<<"Posicion: "<<i<<": "<<*arreglo_1<<endl;
        arreglo_1++;
    }
    cout<<endl<<"---- Creacion arreglo 2 ----"<<endl<<endl;
    for(int j=0; j<numElementos; j++){
        *arreglo_2= rand() % 100;
        cout<<"Posicion: "<<j<<": "<<*arreglo_2<<endl;
        arreglo_2++;
    }
    cout<<endl;
}

int * sumaArreglos(int *arregloUno, int *arregloDos, int numElementos){
    static int sumaArreglos[100];
    cout<<"---- El arreglo resultante sera el siguiente ----"<<endl<<endl;
    for(int i=0; i<numElementos; i++){
        *(sumaArreglos+i)=*arregloUno + *arregloDos;
        cout<<"Posicion: "<<i<<"  Valor: "<<*(sumaArreglos+i)<<endl;
        arregloUno++;
        arregloDos++;
    }
    cout<<endl;
    return sumaArreglos;
}

