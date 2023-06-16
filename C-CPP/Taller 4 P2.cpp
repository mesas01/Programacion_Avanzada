/*
programacion avanzada
16/02/2022
Lab sesion 4
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

void llenarMatriz(int *matriz[], int N);
void mostrarMatriz(int *matriz[], int N);
void validarTriangular(int *matriz[], int N);


int main(){
	cout<<"==== IDENTIFICACION DE MATRICES TRIANGULARES ===="<<endl;
	cout<<"=================================================";
	cout<<"=================================================";
	cout<<endl<<endl<<"== Ingrese el tamano de las filas y columnas de la matriz =="<<endl<<endl;
	cout<<"== Tamano : ";
	int N=0;
	cin>>N;
	cout<<"===== SE PROCEDERA A DIGITAR VALORES DE LA MATRIZ ===="<<endl;
	int matriz[N][N];
	int *matriz_ap[N];
	for(int i=0;i<N;i++){
		matriz_ap[i]=matriz[i];
	}
	llenarMatriz(matriz_ap, N);
	cout<<endl<<endl<<"==== SE PROCEDERA A MOSTRAR LA MATRIZ ===="<<endl<<endl;
	mostrarMatriz(matriz_ap, N);
	cout<<endl<<endl<<"==== SE PROCEDERA A CALCULAR EL TIPO DE MATRIZ ===="<<endl<<endl;
	validarTriangular(matriz_ap, N); 
	
}

void llenarMatriz(int *matriz[], int N){
	int aux=0;
	cout<<"== DATOS MATRIZ =="<<endl<<endl;
	for(int i=0; i<N; i++){
		for(int j=0; j<N; j++){
			cout<<"Digite valor de la posicion ["<<i+1<<"] ["<<j+1<<"]: ";
			cin>>aux;
			*(*(matriz+i)+j)=aux;
			aux=0;
		}
	}
}

void mostrarMatriz(int *matriz[], int N){
	for(int i=0; i<N; i++){
		for(int j=0; j<N; j++){
			cout<<"["<<*(*(matriz+i)+j)<<"]";
		}
		cout<<endl;
	}
}

void validarTriangular(int *matriz[], int N){
	int auxTriangularS=0;
	int auxTriangularI=0;
	int diagonal=0;
	int *auxMatriz[N];
	for(int i=0;i<N;i++){
		auxMatriz[i]=matriz[i];
	}
	for(int i=0; i<N; i++){
			for(int k=0; k<diagonal;k++){
				auxMatriz[i]++;	
			}
		for(int j=0; j<N; j++){
			if((*(matriz+i)+j)>auxMatriz[i]){
				auxTriangularS=auxTriangularS+(*(*(matriz+i)+j));
			}
			if((*(matriz+i)+j)<auxMatriz[i]){
				auxTriangularI=auxTriangularI+(*(*(matriz+i)+j));
			}				 
		}
		diagonal++;
	}
	if(auxTriangularS==0){
		cout<<endl<<endl<<"=== SU MATRIZ ES TRAINGULAR SUPERIOR ==="<<endl<<endl;
	}else if(auxTriangularI==0){
		cout<<endl<<endl<<"=== SU MATRIZ ES TRAINGULAR INFERIOR ==="<<endl<<endl;
	}else{
		cout<<endl<<endl<<"=== SU MATRIZ NO ES TRIANGULAR ==="<<endl<<endl;
	}
}






