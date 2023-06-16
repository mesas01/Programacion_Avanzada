/*
programacion avanzada
02/02/2022
Lab sesion 2
Santiago Mesa
Mateo Infante
Grupo 5
Nota: 4.8, el archivo no hace salto de linea. La salida queda así (en el 25 debio saltar de linea)
11001, 25100, 1100100   
*/
#include <iostream>
#include <string>
#include <istream>
#include <ostream>
#include <math.h>
#include <sstream>

using namespace std;


string returnBinario (long decimal);
long returnDecimal (string binario);
void opciones(), binarioConvertido();

int main(){

    printf("============================================================================\n");
    printf("==                                                                        ==\n");
    printf("== Bienvenido al sistema para conversion de archivos Binarios-Decimales   ==\n");
    printf("==                                                                        ==\n");
    printf("============================================================================\n");
    printf("============================================================================\n");
    printf("\n======= Las opciones para el programa son las siguientes: ==================\n");
    printf("============================================================================\n");
    printf("=======================|Acciones de administrador|==========================\n");
    printf("============================================================================\n");
    printf("========= 1. Convertir Binario a Decimal     ('BD')                  =======\n");
    printf("========= 2. Convertir Decimal a Binario     ('DB')                  =======\n");
    printf("========= 3. Salir                           ('FIN')                 =======\n");
    printf("============================================================================\n");
    printf("============================================================================\n");

    opciones();

    cout<<"=========================== FIN DEL PROGRAMA ==========================="<<endl;
}


void opciones(){

    string opcion;

    while(opcion != "FIN"){
        cout<<endl<<"Ingresar opcion deseada: ";
        cin>>opcion;

        if(opcion=="DB"){
            binarioConvertido();
        }

        if(opcion=="BD"){

            string binario="";

            cout<<"=== Ingresar binario de interes: ";
            cin>> binario;
            long int binario2 = stoi(binario);
            long decimalConvertido=0;
            decimalConvertido=returnDecimal(binario);
            cout<<"Binario: "<<binario<<"  Decimal: "<<decimalConvertido<<endl;

            FILE *conversiones;
            conversiones = fopen("conversiones", "a+");
            if(conversiones == NULL){
                printf("no se ha podido abrir el archivo.");
                exit(1);
            }
            fprintf(conversiones,"%d, %d",binario2,decimalConvertido);
            fclose(conversiones);

        }
    }
}


void binarioConvertido(){
    int decimalUsuario, numeroFinal[50];
    int contador = 0;
    int decimalinicial;

    FILE *conversiones;
    conversiones = fopen("conversiones", "a+");

    if(conversiones == NULL){
        printf("no se ha podido abrir el archivo.");
        exit(1);
    }

    printf ("\nIngrese el numero decimal: ");
    scanf("%d", &decimalUsuario);
    decimalinicial = decimalUsuario;

    while (decimalUsuario>0)
    {
        numeroFinal[contador] = decimalUsuario % 2;
        contador = contador + 1;
        decimalUsuario = decimalUsuario / 2;
    }

    printf("El numero %d en binario es:",decimalinicial);
    fprintf(conversiones,"%d, ",decimalinicial);

    for (contador--; contador >= 0; contador--){

        printf("%d", numeroFinal[contador]);
        fprintf(conversiones,"%d",numeroFinal[contador]);

    }
    fprintf(conversiones,"   ");
    printf("\n============================================================");
    fclose(conversiones);

}

long returnDecimal (string binario){
    long auxiliar=0;
    int potencia=0;
    long adicion=0;
    for(int i=(binario.length()-1); i>=0;i--){
        if(binario[i]=='1'){
            adicion= pow(2,potencia);
            auxiliar=auxiliar+adicion;
            cout<<auxiliar<<" "<<potencia<<" "<<adicion<<endl;
            adicion=0;
            potencia++;
        }
        if(binario[i]=='0'){
            potencia++;
        }
    }
    return auxiliar;
}


