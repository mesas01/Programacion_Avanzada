/*
programacion avanzada
16/02/2022
Lab sesion 5
Santiago Mesa
Mateo Infante
Grupo 5
*/

#include <iostream>
#include <string>
#include <ostream>
#include <math.h>
#include <time.h>

using namespace std;

struct persona{
	char Nombre[20];
	char Direccion[20];
	float Sueldo;
	short Edad;
};

void llenar(persona *p, int registros);
void mostrar(persona *p, int registros);

int main(){
	cout<<"===== INGRESO DE DATOS DE REGISTROS ====="<<endl<<endl;
	cout<<"==== Por favor ingrese la cantidad de registros a anadir ===="<<endl<<endl;
	int registros=0;
	cout<<"==== Registros: ";
	cin>>registros;
	persona *p= new persona[registros];
	cout<<"==== SE PROCEDERA A PEDIR DATOS POR CADA REGISTRO ===="<<endl<<endl;
	llenar(p, registros);
	cout<<endl<<"==== SE PROCEDERA A MOSTRAR DATOS DE LOS REGISTROS ===="<<endl<<endl;
	mostrar(p, registros);
	delete []p;
	cout<<endl<<"======= FIN PROGRAMA ======="<<endl<<endl;	
}

void llenar(persona *p, int registros){
	for(int i=0; i<registros; i++){
		cout<<endl<<"INGRESO DATOS DEL REGISTRO #"<<i+1<<" :"<<endl;
		cout<<"NOMBRE: ";
		cin>>p[i].Nombre;
		fflush(stdin);
		cout<<"DIRECCION: ";
		cin.getline(p[i].Direccion, 20);
		fflush(stdin);
		cout<<"Sueldo: ";
		cin>>p[i].Sueldo;
		fflush(stdin);
		cout<<"Edad: ";
		cin>>p[i].Edad;
		fflush(stdin);
	}
}

void mostrar(persona *p, int registros){
	for(int i=0; i<registros; i++){
		cout<<endl<<"DATOS DEL REGISTRO #"<<i+1<<" :"<<endl;
		cout<<"NOMBRE: "<<p[i].Nombre<<endl;
		cout<<"DIRECCION: "<<p[i].Direccion<<endl;
		cout<<"Sueldo: "<<p[i].Sueldo<<endl;
		cout<<"Edad: "<<p[i].Edad<<endl;
	}
}