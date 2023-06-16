/*
programación avanzada
14/03/2022
Proyecto
Santiago Mesa
Mateo Infante
Grupo 5


Nota: 3.8

Ítem    Porcentaje de la nota
Creación de estructura de clientes    5% -> 5%
Creación de estructura de cuentas    5% -> 5%
Creación de estructura de movimientos    5% ->5%

Registro correcto de clientes en el archivo 
( cuando se cierra el programa y se abre nuevamente, la información no se debe perder)    10%->10%

Registro correcto de cuentas en el archivo 
( cuando se cierra el programa y se abre nuevamente, la información no se debe perder)    10%->10%

Registro correcto de movimientos en el archivo 
( cuando se cierra el programa y se abre nuevamente, la información no se debe perder)    10%->5%. Solo almacena el 1er movimiento (saliendo del programa y entrando nuevamente)

Actualización del saldo del cliente después de un movimiento    15% -> 0% : Observacion: El saldo no se actualiza, hice varios movientos y no se refleja despues de salir y entrar

Opción de consulta de cuentas    12% : 12%
Opción de consulta de movimientos    13% : 8% (no guarda todos los movimientos)
Reporte General por cliente    15% : 15% (tener en cuenta que no guarda todos los movimientos)

Acumulado: 75%
*/

#include <fstream>
#include <iostream>
#include <vector>
#include <string>
#include <conio.h>
#include <ostream>
#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <iomanip>

using namespace std;

typedef struct{
    int tipoID; // se manejara por numeros 1=cc 2=ce 3=ti
    int ID;//este podria ser char de 10
    char nombres[20];
    char apellidos[20];
    char ciudad[20];
}Cliente;

typedef struct{
    long int ID;
    int nroCuenta;//cambiar a int
    int tipoCuenta;//1. ahorro 2. corriente
    unsigned long int saldoApertura;
    unsigned long int saldoActual;
    int movimientosTotales=0;
}Cuenta;

typedef struct {
    long int ID;
    int consecutivoMov=0;
    char tipoMov; //R=Retiro y C=ConsignaciÃ³n
    int valorMov;
}Movimiento;

FILE *archivoDeID;
FILE *baseDeDatosClientes;
FILE *infoCuentasClientes;
FILE *baseDeDatosMovimientos;
int idPersona;
int clientesTotales = 0;
int buscarID();
void consultaPorID();
void consultaPorCuenta();
void consultaMovimientosPorID();
void consultaMovimientosPorCuenta();
void menu();
int registroClientes();
void creacionCuentas();
void consultaCuentas();
void registroMovimientos();
void consultaMovimientos();
void reporteCliente();
bool buscarID(int &numIDayuda);


void reporteCliente(){
    int opcion;
    printf("Por favor indique por donde quiere ver el movimiento\n 1. ID\n 2. Nro cuenta");
    printf("\n\nOpcion: ");
    scanf("%d",&opcion);
    if(opcion==1){
        system("cls");
        printf("Informacion General: \n\n");
        consultaPorID();
        printf("Informacion de movimientos: \n\n");
        consultaMovimientosPorID();

    } else if(opcion == 2){
        system("cls");
        printf("Informacion General: \n\n");
        consultaPorCuenta();
        printf("Informacion de movimientos: \n\n");
        consultaMovimientosPorCuenta();

    } else{
        system("cls");
        printf("Opcion invalida, por favor digite otra opcion...");
        system("pause");
        return;
    }
}

void consultaMovimientos(){
    cout<<"Decida como quiere hacer su consulta:"<<endl<<endl;
    int opcion=0;
    cout<<"1. Buscar por numero de identificacion "<<endl;
    cout<<"2. Buscar por numero de cuenta "<<endl<<endl;
    cout<<"Opcion: ";
    cin>>opcion;
    system("cls");
    if(opcion==1){
        consultaMovimientosPorID();

    }else if(opcion==2){
        consultaMovimientosPorCuenta();

    }else{
        system("cls");
        printf("Opcion invalida, por favor digite otra opcion...");
        system("pause");
        return;
    }
}

void consultaMovimientosPorID(){

    
    printf("Ingrese el numero de ID del cliente: ");
    int IDBuscar;
    scanf("%d", &IDBuscar);
    int existe = 0;
    int numeroMovimientos=0;

    existe = 0;

    infoCuentasClientes = fopen("infoCuentasClientes.dat", "rb");
    Cuenta cuentaReg;
    int cuentaMostrar=0;

    fread(&cuentaReg, sizeof(Cuenta), 1, infoCuentasClientes);
    while (!feof(infoCuentasClientes) && existe==0) {
        if (IDBuscar == cuentaReg.ID) {
            cuentaMostrar=cuentaReg.nroCuenta;
            fread(&cuentaReg, sizeof(Cuenta), 1, infoCuentasClientes);
            existe=1;
        }
        fread(&cuentaReg, sizeof(Cuenta), 1, infoCuentasClientes);
    }
    fclose(infoCuentasClientes);

    baseDeDatosClientes = fopen("baseDeDatosClientes.dat", "rb");
    Cliente clienteReg;

    char nombresMostrar[20];
    char apellidosMostrar[20];

    fread(&clienteReg, sizeof(Cliente), 1, baseDeDatosClientes);
    while (!feof(baseDeDatosClientes)) {
        if (IDBuscar == clienteReg.ID) {
            for (int i = 0; i < 20; ++i) {
                nombresMostrar[i]=clienteReg.nombres[i];
                apellidosMostrar[i]=clienteReg.apellidos[i];
            }
            fread(&clienteReg, sizeof(Cliente), 1, baseDeDatosClientes);
            system("pause");
        }
        fread(&clienteReg, sizeof(Cliente), 1, baseDeDatosClientes);
    }
    fclose(baseDeDatosClientes);

    baseDeDatosMovimientos = fopen("baseDeDatosMovimientos.dat", "rb");
    Movimiento movimientoReg;

    cout <<" Consecutivo de movimientos  "<<"Cliente  "<<"Cuenta  "<<"Tipo de Movimiento  "<<"Valor  "<<endl;
    fread(&movimientoReg, sizeof(Movimiento), 1, baseDeDatosMovimientos);
    while (!feof(baseDeDatosMovimientos)) {
        if (IDBuscar == movimientoReg.ID && numeroMovimientos==movimientoReg.consecutivoMov) {
            cout <<setw(12)<<movimientoReg.consecutivoMov<<setw(35);
            cout<<nombresMostrar<<"  "<<apellidosMostrar<<"  "<<cuentaMostrar<<"  "<<movimientoReg.tipoMov<<"  "<<movimientoReg.valorMov<<"  "<<endl;
            fread(&movimientoReg, sizeof(Movimiento), 1, baseDeDatosClientes);
            system("pause");
            numeroMovimientos++;
            existe=1;
        }
        fread(&movimientoReg, sizeof(Movimiento), 1, baseDeDatosClientes);
    }
    fclose(baseDeDatosClientes);
    if (existe == 0){
        printf("No existe un cliente con este ID...\n\n");
        return;
    }
}

void consultaMovimientosPorCuenta(){


    printf("Ingrese el numero de cuenta del cliente: ");
    int CuentaBuscar;
    scanf("%d", &CuentaBuscar);
    int existe = 0;
    int IDBuscar=0;
    int numeroMovimientos=0;

    existe = 0;

    infoCuentasClientes = fopen("infoCuentasClientes.dat", "rb");
    Cuenta cuentaReg;

    fread(&cuentaReg, sizeof(Cuenta), 1, infoCuentasClientes);
    while (!feof(infoCuentasClientes) && existe==0) {
        if (CuentaBuscar == cuentaReg.nroCuenta) {
            IDBuscar=cuentaReg.ID;
            fread(&cuentaReg, sizeof(Cuenta), 1, infoCuentasClientes);
            existe=1;
        }
        fread(&cuentaReg, sizeof(Cuenta), 1, infoCuentasClientes);
    }
    fclose(infoCuentasClientes);
    

    baseDeDatosClientes = fopen("baseDeDatosClientes.dat", "rb");

    Cliente clienteReg;

    char nombresMostrar[20];
    char apellidosMostrar[20];

    fread(&clienteReg, sizeof(Cliente), 1, baseDeDatosClientes);
    while (!feof(baseDeDatosClientes)) {
        if (IDBuscar == clienteReg.ID) {
            for (int i = 0; i < 20; ++i) {
                nombresMostrar[i]=clienteReg.nombres[i];
                apellidosMostrar[i]=clienteReg.apellidos[i];
            }
            fread(&clienteReg, sizeof(Cliente), 1, baseDeDatosClientes);
            system("pause");
        }
        fread(&clienteReg, sizeof(Cliente), 1, baseDeDatosClientes);
    }
	fclose(baseDeDatosClientes);
	
    baseDeDatosMovimientos = fopen("baseDeDatosMovimientos.dat", "rb");
    Movimiento movimientoReg;
    cout <<" Consecutivo de movimientos  "<<"Cliente  "<<"Cuenta  "<<"Tipo de Movimiento  "<<"Valor  "<<endl;
    fread(&movimientoReg, sizeof(Movimiento), 1, baseDeDatosMovimientos);
    while (!feof(baseDeDatosMovimientos)) {
        if (IDBuscar == movimientoReg.ID && numeroMovimientos==movimientoReg.consecutivoMov) {
            cout <<movimientoReg.consecutivoMov++<<"  ";
            cout<<nombresMostrar<<"  "<<apellidosMostrar<<"  "<<CuentaBuscar<<"  "<<movimientoReg.tipoMov<<"  "<<movimientoReg.valorMov<<endl;
            fread(&movimientoReg, sizeof(Movimiento), 1, baseDeDatosMovimientos);
            system("pause");
            numeroMovimientos++;
            existe=1;
        }
        fread(&movimientoReg, sizeof(Movimiento), 1, baseDeDatosMovimientos);
    }
    fclose(baseDeDatosMovimientos);

    if (existe == 0){
        printf("No existe un cliente con este ID...\n\n");
        return;
    }

}

void registroMovimientos(){
    

    Movimiento movimientoReg;

    fflush(stdin);
    printf("\nPor favor ingrese el numero de cuenta para realizar movimiento: ");
    int nroCuenta=0;
    cin>>nroCuenta;
    cout<<endl;

    
    int IDBusqueda=0;
    long int SaldoActual=0;
    int existe=0;



    cout<<"Indique por favor el tipo de Movimiento"<<endl<<endl;
    cout<<"R = Retiro"<<endl;
    cout<<"C = Consignacion"<<endl;
    cout<<"Tipo de Movimiento:";
    cin>>movimientoReg.tipoMov;
    cout<<endl<<endl<<"Indique el monto total del movimiento: ";
    long int movimientoActual=0;
    cin>>movimientoActual;
    movimientoReg.valorMov=movimientoActual;

	infoCuentasClientes = fopen("infoCuentasClientes.dat", "rb");
    Cuenta cuentaReg;
    fread(&cuentaReg, sizeof(Cuenta), 1, infoCuentasClientes);
    while (!feof(infoCuentasClientes) && existe==0) {
        if (nroCuenta == cuentaReg.nroCuenta) {
            SaldoActual=cuentaReg.saldoActual;
            if(SaldoActual-movimientoActual<0 && movimientoReg.tipoMov=='R'){
                system("cls");
                cout<<"Cantidad de dinero solicitada no se puede retirar"<<endl;
                return;
            }else if(SaldoActual-movimientoActual>=0 && movimientoReg.tipoMov=='R'){
                cuentaReg.saldoActual=SaldoActual-movimientoActual;
            }else if(movimientoReg.tipoMov=='C'){
                cuentaReg.saldoActual=SaldoActual+movimientoActual;
            }
            IDBusqueda=cuentaReg.ID;
            SaldoActual=cuentaReg.saldoActual;
            movimientoReg.consecutivoMov=cuentaReg.movimientosTotales;
            cuentaReg.movimientosTotales++;
            fread(&cuentaReg, sizeof(Cuenta), 1, infoCuentasClientes);
            system("pause");
            cout<<"Llegamos";
            existe=1;
        }
        fread(&cuentaReg, sizeof(Cuenta), 1, infoCuentasClientes);
    }

    if (existe == 0){
        printf("No existe un cliente con este ID...\n\n");
        system("pause");
        return;
    }

    fclose(infoCuentasClientes);

    movimientoReg.ID=IDBusqueda;
    system("cls");
    cout<<"RESUMEN MOVIMIENTO"<<endl<<endl<<endl;

    baseDeDatosClientes = fopen("baseDeDatosClientes.dat", "rb");
    Cliente clienteReg;

    existe = 0;

    fread(&clienteReg, sizeof(Cliente), 1, baseDeDatosClientes);
    while (!feof(baseDeDatosClientes)) {
        if (IDBusqueda == clienteReg.ID) {
            printf("Cliente: Nombre: %s\n Apellido: %s\n", clienteReg.nombres, clienteReg.apellidos);
            fread(&clienteReg, sizeof(Cliente), 1, baseDeDatosClientes);
            existe = 1;
        }
        fread(&clienteReg, sizeof(Cliente), 1, baseDeDatosClientes);
    }
    fclose(baseDeDatosClientes);
    if (existe == 0){
        printf("No existe un cliente con este ID...\n\n");
        return;
    }
    cout<<endl<<"Cuenta: "<<nroCuenta<<endl;
    cout<<"Tipo de Movimiento: "<<movimientoReg.tipoMov<<endl<<"R = Retiro  C = Consignacion"<<endl;
    cout<<"Valor movimiento: $"<<movimientoReg.valorMov<<endl;
    cout<<"Saldo Actual: $"<<SaldoActual<<endl<<endl;
    system("pause");

	baseDeDatosMovimientos = fopen("baseDeDatosMovimientos.dat","ab");
    if (baseDeDatosMovimientos == NULL)
        exit(-1);
    printf("Guardando los datos del movimiento en el archivo binario\n\n");
    system("pause");
    fwrite(&movimientoReg, sizeof(Movimiento), 1, baseDeDatosMovimientos);
    fclose(baseDeDatosMovimientos);
    

}

void consultaCuentas(){
    cout<<"Decida como quiere hacer su consulta:"<<endl<<endl;
    int opcion=0;
    cout<<"1. Buscar por numero de identificacion "<<endl;
    cout<<"2. Buscar por numero de cuenta "<<endl<<endl;
    cout<<"Opcion: ";
    cin>>opcion;
    system("cls");
    if(opcion!=1 && opcion !=2){
        cout<<"Por favor ingrese una opcion vÃ¡lida"<<endl;
        system("pause");
    }
    if(opcion==1){
        consultaPorID();

    }else if(opcion==2){
        consultaPorCuenta();

    }
}

void consultaPorID() {

    baseDeDatosClientes = fopen("baseDeDatosClientes.dat", "rb");
    Cliente clienteReg;


    printf("Ingrese el numero de ID del cliente: ");
    int IDBuscar;
    scanf("%d", &IDBuscar);
    int existe = 0;

    fread(&clienteReg, sizeof(Cliente), 1, baseDeDatosClientes);
    while (!feof(baseDeDatosClientes)) {
        if (IDBuscar == clienteReg.ID && existe==0) {
            printf(" Nombre: %s\n Apellido: %s\n", clienteReg.nombres, clienteReg.apellidos);
            fread(&clienteReg, sizeof(Cliente), 1, baseDeDatosClientes);
            existe = 1;
        }
        fread(&clienteReg, sizeof(Cliente), 1, baseDeDatosClientes);
    }
    fclose(baseDeDatosClientes);
    if (existe == 0){
        printf("No existe un cliente con este ID...\n\n");
        return;
    }

    infoCuentasClientes = fopen("infoCuentasClientes.dat", "rb");
    Cuenta cuentaReg;

    existe = 0;
    fread(&cuentaReg, sizeof(Cuenta), 1, infoCuentasClientes);
    while (!feof(infoCuentasClientes)) {
        if (IDBuscar == cuentaReg.ID && existe == 0) {

            cout<<"Numero de cuenta: "<<cuentaReg.nroCuenta<<endl<<endl;
            cout<<"Tipo de Cuenta: "<<cuentaReg.tipoCuenta<< endl<<"1 = Ahorros, 2 = Corriente"<<endl<<endl;
            cout<<"Saldo Actual: "<<cuentaReg.saldoActual<<endl<<endl;
            existe=1;
            fread(&cuentaReg, sizeof(Cliente), 1, infoCuentasClientes);
            system("pause");
        }
        fread(&cuentaReg, sizeof(Cuenta), 1, infoCuentasClientes);
    }
    fclose(infoCuentasClientes);
}

void consultaPorCuenta(){

    printf("Ingrese el numero de cuenta del cliente: ");
    int CuentaBuscar;
    scanf("%d", &CuentaBuscar);
    int existe = 0;

    infoCuentasClientes = fopen("infoCuentasClientes.dat", "rb");
    Cuenta cuentaReg;
    int IDBusqueda=0;

    fread(&cuentaReg, sizeof(Cuenta), 1, infoCuentasClientes);
    while (!feof(infoCuentasClientes) && existe==0) {
        if (CuentaBuscar == cuentaReg.nroCuenta) {

            cout<<"Numero de cuenta: "<<cuentaReg.nroCuenta<<endl<<endl;
            cout<<"Tipo de Cuenta: "<<cuentaReg.tipoCuenta<<endl<< "1 = Ahorros, 2 = Corriente"<<endl<<endl;
            cout<<"Saldo Actual: "<<cuentaReg.saldoActual<<endl<<endl;
            IDBusqueda=cuentaReg.ID;
            fread(&cuentaReg, sizeof(Cuenta), 1, infoCuentasClientes);
            existe=1;
        }
        fread(&cuentaReg, sizeof(Cuenta), 1, infoCuentasClientes);
    }
    fclose(infoCuentasClientes);
    if (existe == 0){
        printf("No existe un cliente con este ID...\n\n");
        return;
    }



    baseDeDatosClientes = fopen("baseDeDatosClientes.dat", "rb");
    Cliente clienteReg;

    fread(&clienteReg, sizeof(Cliente), 1, baseDeDatosClientes);
    while (!feof(baseDeDatosClientes)) {
        if (IDBusqueda == clienteReg.ID && existe==1) {
            printf(" Nombre: %s\n Apellido: %s\n", clienteReg.nombres, clienteReg.apellidos);
            fread(&clienteReg, sizeof(Cliente), 1, baseDeDatosClientes);
            system("pause");
            existe=0;
        }
        fread(&clienteReg, sizeof(Cliente), 1, baseDeDatosClientes);
    }
    fclose(baseDeDatosClientes);
}

void creacionCuentas(){

    infoCuentasClientes = fopen("infoCuentasClientes.dat","a+b");
    if (infoCuentasClientes == NULL)
        exit(-1);
    Cuenta cuentarReg;

    system("cls");
    printf("nota: Para registrar su cuenta debe estar inscrito en el sistema\n\n");
    int cuentaPorBuscar = buscarID();
    if (cuentaPorBuscar != 1){
        printf("Esta cuenta No existe, registrela primero\n\n");
        system("pause");
        return;
    }

    cuentarReg.ID = idPersona;
    system("cls");
    printf("Ingrese que tipo de cuenta desea tener\n 1 = Ahorros\n 2 = Corriente\n\n opcion: ");
    cin >> cuentarReg.tipoCuenta;

    srand(time(NULL));
    cuentarReg.nroCuenta = (rand()%10000)+10000;
    printf("El numero de tu cuenta es: %d\n\n",cuentarReg.nroCuenta);

    printf("El valor minimo de apertura es 50.000 cop");
    cout<<endl;
    printf("Con que valor desea abrir su cuenta?\n\nValor: ");
    cin >> cuentarReg.saldoApertura;
    if(cuentarReg.saldoApertura<50000){
        cout<<"No puede abrir una cuenta con menos de 50000"<<endl;
        system("pause");
    }else{
        cuentarReg.saldoActual = cuentarReg.saldoApertura;
    }
    printf("Guardando sus datos de cuenta en el archivo binario...");
    fwrite(&cuentarReg, sizeof(Cuenta), 1, infoCuentasClientes);
    fclose(infoCuentasClientes);

    infoCuentasClientes=fopen("infoCuentasClientes.dat","rb");

    if (infoCuentasClientes==NULL)
        exit(1);

    int cod;
    /*printf("ingrese de nuevo:");
    scanf(" %d", &cod);
    fread(&cuentarReg, sizeof(Cuenta), 1, infoCuentasClientes);
    while(!feof(infoCuentasClientes))
    {
        if (cod==cuentarReg.ID) {
            printf("%d- %d -%d-%d-%d\n", cuentarReg.nroCuenta,
                   cuentarReg.saldoApertura, cuentarReg.tipoCuenta, cuentarReg.saldoActual, cuentarReg.ID);
            fread(&cuentarReg, sizeof(Cuenta), 1, infoCuentasClientes);
            system("pause");
        }
    }
    fclose(infoCuentasClientes)*/
}

int buscarID(){//se busca el id en un archivo txt auxiliar donde solo hay IDs

    archivoDeID = fopen("archivoDeID.txt", "a");
    fclose(archivoDeID);
    //se abre o crea archivo para no generar error en caso
    //de que sea la primera vez que se ejecuta el programa

    archivoDeID = fopen("archivoDeID.txt", "r");
    if (archivoDeID == NULL)
        exit(-1);
    //se abre el archivo auxiliar para lectura

    printf("\nPor favor ingrese el numero de ID de la persona: ");
    scanf("%d",&idPersona);

    int valorInt = 0;
    while (!feof(archivoDeID)) {//se busca el id
        fscanf (archivoDeID,"%d", &valorInt);
        if(valorInt == idPersona){
            system("cls");
            printf ("\nEl ID: %d se encuentra en nuestra base de datos\n\n", valorInt);
            system("pause");
            fclose(archivoDeID);
            return 1;
        }
    }
    fclose(archivoDeID);
    //se abre el mismo archivo pero para aÃ±adir el id en caso de que no exista
    //se hace de esta manera ya que al inicio si se pone a/a+ hay error en ejecuciÃ³n
    archivoDeID = fopen("archivoDeID.txt", "a+");
    if (archivoDeID == NULL)
        exit(-1);
    fprintf(archivoDeID,"%d\n",idPersona);
    fclose(archivoDeID);
    return idPersona;
}

int registroClientes() {

    baseDeDatosClientes = fopen("baseDeDatosClientes.dat","ab");
    if (baseDeDatosClientes == NULL)
        exit(-1);

    Cliente clienteReg;

    fflush(stdin);
    printf("\nPor favor ingrese el nombre de la persona: ");
    gets(clienteReg.nombres);
    if (clienteReg.nombres == ""){
        printf("No puede digitar un 'Vacio' intente de nuevo ");
        system("pause");
        return 1;
    }

    fflush(stdin);
    printf("\nPor favor ingrese el apellido de la persona: ");
    gets(clienteReg.apellidos);
    if (clienteReg.apellidos == ""){
        printf("No puede digitar un 'Vacio' intente de nuevo ");
        system("pause");
        return 1;
    }

    fflush(stdin);
    printf("\nPor favor ingrese la ciudad de la persona: ");
    gets(clienteReg.ciudad);
    if (clienteReg.ciudad == ""){
        printf("No puede digitar un 'Vacio' intente de nuevo ");
        system("pause");
        return 1;
    }

    fflush(stdin);
    printf("\nPor favor ingrese el tipo de ID de la persona (numero):\n\n1. CC\n2. CE \n3. TI\n\nOpcion: ");
    scanf("%d",&clienteReg.tipoID);

    if (clienteReg.tipoID < 1 || clienteReg.tipoID > 3) {
        system("cls");
        printf("=================================================\n");
        printf("EL Tipo de ID no es valido intente de nuevo\n");
        printf("=================================================\n\n");
        system("pause");
        return (-1);
    }

    fflush(stdin);
    clienteReg.ID = buscarID();

    if(clienteReg.ID == 1){
        system("cls");
        printf("\nEl ID de usuario que digito ya existe, intente de nuevo\n");
        system("pause");
        return 1;
    }
    else{
        system("cls");
        printf("Guardando sus datos en el archivo binario\n\n");
        system("pause");
        fwrite(&clienteReg, sizeof(Cliente), 1, baseDeDatosClientes);
        fclose(baseDeDatosClientes);
    }
    return 0;
}

void menu(){
    cout<<"===================================================="<<endl;
    cout<<"========= BIENVENIDO AL MENU DEL BANCO XYZ ========="<<endl;
    cout<<"===================================================="<<endl<<endl;
    system("pause");
    system("cls");
    int opcion = 0;
    while (opcion!=7){
        system("cls");
        cout<<endl<<"================= MENU DE OPCIONES ================="<<endl;
        cout<<"===================================================="<<endl;
        cout<<"== 1. Registro de clientes ========================="<<endl;
        cout<<"== 2. Creacion de cuentas =========================="<<endl;
        cout<<"== 3. Consulta de cuentas =========================="<<endl;
        cout<<"== 4. Registro de movimientos ======================"<<endl;
        cout<<"== 5. Consulta de movimientos ======================"<<endl;
        cout<<"== 6. Reporte general por cliente =================="<<endl;
        cout<<"== 7. Salir ========================================"<<endl;
        cout<<"===================================================="<<endl<<endl;
        cout<<"===================================================="<<endl;
        cout<<"==== Opcion: ";
        cin>>opcion;
        cout<<"===================================================="<<endl;
        switch(opcion){
            case 1:{
                system("cls");
                registroClientes();
                break;
            }
            case 2:{
                system("cls");
                creacionCuentas();
                break;
            }
            case 3:{
                system("cls");
                consultaCuentas();
                break;
            }
            case 4:{
                system("cls");
                registroMovimientos();
                break;
            }
            case 5:{
                system("cls");
                consultaMovimientos();
                break;
            }
            case 6:{
                system("cls");
                reporteCliente();
                break;
            }
            case 7:{
                system("cls");
                cout<<endl<<"====================================================="<<endl;
                cout<<"=========== GRACIAS POR USAR EL BANCO XYZ ==========="<<endl;
                cout<<"====================================================="<<endl;
                exit(-1);
                break;
            }
            default:{
                system("cls");
                cout<<endl<<"====================================================="<<endl;
                cout<<"======== HA ELEGIDO UNA OPCION NO DISPONIBLE ========"<<endl;
                cout<<"=== POR FAVOR ELIJA UN NUMERO DE OPCION DISPONIBLE =="<<endl;
                cout<<"====================================================="<<endl;
                break;
            }
        }
    }
}

int main(){
    menu();
}