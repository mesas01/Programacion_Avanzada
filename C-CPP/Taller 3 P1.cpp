/*
programacion avanzada
09/02/2022
Lab sesion 3
Santiago Mesa
Mateo Infante
Grupo 5
*/


#include <stdio.h>
#include <string.h>
#include <stdlib.h>


int longitud  (char *palabraUsuario){
    int largo=0;
    while (*palabraUsuario!='\0'){
        largo++;
        palabraUsuario++;
    }
    return largo;
}

char *reverse(char *palabraUsuario){

    int largo = longitud(palabraUsuario);
    char prueba[50];

    for (int contador = 0; contador < largo / 2; contador++){

        char temporal = palabraUsuario[contador];
        palabraUsuario[contador] = palabraUsuario[largo - contador - 1];
        palabraUsuario[largo - contador - 1] = temporal;
    }

    return palabraUsuario;
}

void intro(){

    static char palabraUsuario[50];
    char palabraOriginal[50]="";


    printf("===========================================================\n");
    printf("=====  Bienvenido al programa inversor de caracteres  =====\n");
    printf("===========================================================\n\n");
    printf("Por favor ingrese la palabra que desea invertir: ");
    gets(palabraUsuario);
    strcat(palabraOriginal,palabraUsuario);

    char *palabraInvertida = reverse(palabraUsuario);

    system("cls");
    printf("\nla palabra original  es: %s",palabraOriginal);
    printf("\nla palabra invertida es: %s\n", palabraInvertida);


}

int main(){
    intro();

}