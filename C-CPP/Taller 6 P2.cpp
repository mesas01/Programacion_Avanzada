/*
programacion avanzada
02/03/2022
Lab sesion 6
Santiago Mesa
Mateo Infante
Grupo 5
*/

#include <stdio.h>
#include <iostream>
#include <istream>
#include <string>
#include <algorithm>
#include <cstring>
using std::cout; using std::endl;
using std::string; using std::reverse;
using namespace std;

void introduccion();
string mixed(string cadena);

int main(){
    introduccion();

}


string mixed(string cadena) {
    
    
    char *arrayNuevo;
    string stringAux = cadena;
    arrayNuevo = &stringAux[0];

    

    char *ptr = arrayNuevo;

    while( *ptr != '\0' ){
        while( !isalpha(*ptr) && (*ptr != '\0') ) {
            ptr++;
        }

        if( isalpha(*ptr)){
            if( *ptr >= 'a' ){
                *ptr = toupper(*ptr);
            }
            ptr++;
        }

        while( isalpha(*ptr)){
            *ptr = tolower(*ptr);
			ptr++;
        }
    }
    
    printf("Cadena corregida: ");
    puts(arrayNuevo);
    
    
}

void introduccion(){

    string cadena;

    printf("Bienvenido al programa Mixed Case\n\n");
    printf("Por favor ingrese su frase: ");
    getline(cin,cadena);
    //cout<<"\n\nstring: "<<cadena<<endl;

    string cadenaCorregida = mixed(cadena);
    


}

