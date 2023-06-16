/*
programacion avanzada
01/05/2022
Taller 3 Lab 1
Santiago Mesa
Mateo Infante
Grupo 5
*/
package taller3lab1infantemesa;


public class Taller3Lab1InfanteMesa {
    public static void main(String[] args) {
        HidroAvion hidroAvioncito = new HidroAvion(2008,20,40);
        hidroAvioncito.despegar("Ha");
        hidroAvioncito.volar("Ha", 70);
        hidroAvioncito.navegar("Ha",50);
        hidroAvioncito.aterrizar("Ha");

        System.out.println("--------------------------------");

        HidroAvionCombate hidroAvioncitoCombate = new HidroAvionCombate(3056,80,500);
        hidroAvioncitoCombate.atacar("HaC");
        hidroAvioncitoCombate.volar("HaC",200);
        hidroAvioncitoCombate.navegar("HaC",150);
        hidroAvioncitoCombate.aterrizar("HaC");

        System.out.println();



    }
}
