/*
programacion avanzada
02/03/2022
Lab sesion 6
Santiago Mesa
Mateo Infante
Grupo 5
*/

#include <cstring>
#include <iostream>
#include <stdio.h>
#include <string.h>
#include <conio.h>

using namespace ::std;

int split (string cadena, string *&cad);

int main() {
  	string cadena;
	cout<<"=== PROGRAMA QUE DIVIDE UNA FRASE EN SUS PALABRAS ==="<<endl<<endl;
  	cout<<"=== Por favor ingrese frase: ";
  	getline(cin, cadena);
    string *cad = &cadena;
    int number;
    number=split(cadena, *&cad);
}

int split (string cadena, string *&cad){
	char *arrayNuevo;
    string stringAux = cadena;
    arrayNuevo = &stringAux[0];
    char *ptr = arrayNuevo;
    int contador=0;
    size_t posicion;
    string palabras[100];
    
    
     while( *ptr != '\0' ){
        while( (posicion=cadena.find(" ")) !=string::npos ) {
        	palabras[contador]=cadena.substr(0, posicion);
			cout<<endl<<contador<<": "<<palabras[contador];
			cadena.erase(0, posicion+1);
			contador++;
        	
        }
        
    }
    
}
