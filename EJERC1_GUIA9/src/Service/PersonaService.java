/*
 Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que
pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo, mostrar desde
la clase Persona, la información del Perro y de la Persona.
El programa deberá preguntarle a
cada persona, que perro según su nombre, quiere adoptar. Dos personas no pueden adoptar
al mismo perro, si la persona eligió un perro que ya estaba adoptado, se le debe informar a la
persona.
Una vez que la Persona elige el Perro se le asigna, al final deberemos mostrar todas las
personas con sus respectivos perros.
 */
package Service;

import entidad.Perro;
import entidad.Persona;
import java.util.ArrayList;
import java.util.*;

public class PersonaService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ArrayList<Persona> personList = new ArrayList();
    ArrayList<Perro> dogList = new ArrayList();
    ArrayList<Perro> adoptedDog = new ArrayList();
    ArrayList<Persona> alredyAdopted = new ArrayList();

    public void crearPerros() {
        String op;
        System.out.println("=============Vamos a crear la lista de perritos para adoptar!============");
        do {
            Perro dog = new Perro();
            System.out.println("Ingrese nombre del perrito ");
            dog.setName(leer.next());
            System.out.println("Ingrese edad:");
            dog.setYears(leer.nextInt());
            System.out.println("Ingrese tamaño chico/mediano/grande:");
            dog.setSize(leer.next());
            System.out.println("Ingrese raza:");
            dog.setRace(leer.next());
            dogList.add(dog);
            System.out.println("Desea agregar otro perrito? S/N");
            op = leer.next();
        } while (op.equalsIgnoreCase("s"));
    }

    public void crearPersonas() {
        String op;
        System.out.println("=============Vamos a crear la lista de personas:============");
        do {
            Persona p = new Persona();
            System.out.println("Ingrese nombre de persona: ");
            p.setName(leer.next());
            System.out.println("Ingrese apellido:");
            p.setSurname(leer.next());
            System.out.println("Ingrese documento:");
            p.setDni(leer.nextInt());
            System.out.println("Ingrese edad:");
            p.setYears(leer.nextInt());
            personList.add(p);
            System.out.println("Desea agregar otra persona? S/N");
            op = leer.next();
        } while (op.equalsIgnoreCase("s"));
    }

    public void adoptarPerro() {
        int count = 0;
        int count2 = 0;
        String op, op2;
        do {
            boolean flag = false;
            if (verificarSiAdopto(count)) {
                count++;
                continue;
            }
            System.out.println(personList.get(count).getName() + " desea adoptar? S/N");
            op = leer.next();
            if (op.equalsIgnoreCase("s")) {
                do {
                    mostrarPerritos();
                    System.out.println("Ingresa nombre del perrito a adoptar:");
                    op2 = leer.next();
                    if (verificarNombre(op2)&&verificarAdopcion(op2)) {
                        adoptarPerrito(op2, count);
                        flag = true;
                    } else {
                        System.out.println("Ohh el perrito fue adoptado o no está en la lista");
                    }
                } while (flag == false);
            }
            count++;
        } while (count != personList.size());
    }

    private boolean verificarNombre(String op2) {
        boolean flag = false;
        for (Perro d : dogList) {
            if (d.getName().equalsIgnoreCase(op2)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    private boolean verificarSiAdopto(int count) {
        boolean flag = false;
        for (Persona p : alredyAdopted) {
            if (p.getName().equalsIgnoreCase(personList.get(count).getName())) {
                flag = true;
            }
        }
        return flag;
    }

    private void mostrarPerritos() {
        System.out.println("Nombres de perritos en adopción:");
        for (Perro d : dogList) {
            System.out.println(d.getName());
        }
    }

    private boolean verificarAdopcion(String op2) {
        boolean flag = false;
        if (adoptedDog.isEmpty()) {
            flag = true;
        } else {
            for (Perro p : adoptedDog) {
                if (p.getName().equalsIgnoreCase(op2)) {
                    break;
                } else {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private void adoptarPerrito(String op2, int count) {
        for (Perro d : dogList) {
            if (d.getName().equalsIgnoreCase(op2)) {
                personList.get(count).setDog(d);
                adoptedDog.add(d);
                alredyAdopted.add(personList.get(count));
            }
        }
        System.out.println("Felicitaciones " + personList.get(count).getName() + " adoptaste a " + op2 + " !!!");
    }

    public void mostrarPersonas() {
        for (Persona p : personList) {
            System.out.println("Nombre del dueño: " + p.getName() + " " + p.getSurname());
            System.out.println("Documento: " + p.getDni());
            System.out.println("Edad: " + p.getYears() + " años");
            System.out.println("Perrito adoptado: " + p.getDog());
            System.out.println("=======================================================================");
        }
    }
}
