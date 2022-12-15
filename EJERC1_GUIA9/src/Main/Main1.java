/*
1):Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a contar de dos
clases. Perro, que tendrá como atributos: nombre, raza, edad y tamaño; y la clase Persona con
atributos: nombre, apellido, edad, documento y Perro.
Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que
pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo, mostrar desde
la clase Persona, la información del Perro y de la Persona.
1-EXTRA): Ahora se debe realizar unas mejoras al ejercicio de Perro y Persona. Nuestro programa va a
tener que contar con muchas personas y muchos perros. El programa deberá preguntarle a
cada persona, que perro según su nombre, quiere adoptar. Dos personas no pueden adoptar
al mismo perro, si la persona eligió un perro que ya estaba adoptado, se le debe informar a la
persona.
Una vez que la Persona elige el Perro se le asigna, al final deberemos mostrar todas las
personas con sus respectivos perros.
 */
package Main;

import Service.PersonaService;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        PersonaService ps = new PersonaService();
        int op;

        do {
            System.out.println("========================ADOPCIÓN DE PERRITOS(L)========================");
            System.out.println("Que desea hacer?");
            System.out.println("1: Cargar lista de perritos en adopción");
            System.out.println("2: Cargar lista de personas a adoptar");
            System.out.println("3: Proceso de adopción");
            System.out.println("4: Mostrar lista de personas y perritos adoptados");
            System.out.println("5: Salir");
            op = leer.nextInt();

            switch (op) {
                case 1:
                    ps.crearPerros();
                    break;
                case 2:
                    ps.crearPersonas();
                    break;
                case 3:
                    ps.adoptarPerro();
                    break;
                case 4:
                    ps.mostrarPersonas();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (op != 5);
    }
}
