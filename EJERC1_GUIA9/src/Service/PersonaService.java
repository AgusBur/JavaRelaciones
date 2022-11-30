/*
 Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que
pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo, mostrar desde
la clase Persona, la información del Perro y de la Persona.
 */
package Service;

import entidad.Perro;
import entidad.Persona;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonaService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ArrayList<Persona> pList = new ArrayList();
    ArrayList <Perro> dList = new ArrayList();
    
    public void crearPerro() {
        for (int i = 0; i < 2; i++) {
            Perro dog = new Perro();
            System.out.println("Ingrese nombre del perrito "+(i+1)+" :");
            dog.setName(leer.next());
            System.out.println("Ingrese edad:");
            dog.setYears(leer.nextInt());
            System.out.println("Ingrese tamaño chico/mediano/grande:");
            dog.setSize(leer.next());
            System.out.println("Ingrese raza:");
            dog.setRace(leer.next());
            dList.add(dog);
            System.out.println("====================================================");
        }
    }
    
    
    public void crearPersona() {

        for (int i = 0; i < 2; i++) {
            Persona p = new Persona();
            System.out.println("Ingrese nombre de dueña/o de: "+dList.get(i).getName());
            p.setName(leer.next());
            System.out.println("Ingrese apellido:");
            p.setSurname(leer.next());
            System.out.println("Ingrese documento:");
            p.setDni(leer.nextInt());
            System.out.println("Ingrese edad:");
            p.setYears(leer.nextInt());
            p.setDog(dList.get(i));
            pList.add(p);
            System.out.println("====================================================");
        }
    }
    
    public void mostrarPersonas() {   
        for (Persona p : pList) {
            System.out.println("Nombre del dueño: "+p.getName()+p.getSurname());
            System.out.println("Documento: "+p.getDni());
            System.out.println("Edad: "+p.getYears()+" años");
            System.out.println("Perro: "+p.getDog());
            System.out.println("====================================================");
        }     
    }

}
