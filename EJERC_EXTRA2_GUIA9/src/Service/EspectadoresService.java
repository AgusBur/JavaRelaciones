/*
 Se debe realizar una pequeña simulación, en la que se generen muchos espectadores y se los
ubique en los asientos aleatoriamente (no se puede ubicar un espectador donde ya este
ocupado el asiento).
Los espectadores serán ubicados de uno en uno y para ubicarlos tener en cuenta que sólo se
podrá sentar a un espectador si tiene el dinero suficiente para pagar la entrada, si hay espacio
libre en la sala y si tiene la edad requerida para ver la película. En caso de que el asiento este
ocupado se le debe buscar uno libre.
Al final del programa deberemos mostrar la tabla, podemos mostrarla con la letra y numero de
cada asiento o solo las X y espacios vacíos.
 */
package Service;

import Entidad.Cine;
import Entidad.Espectadores;
import Entidad.Pelicula;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Agustina
 */
public class EspectadoresService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");  
    //Cine cinema = new Cine();
    Pelicula movie = new Pelicula();
    CineService cs = new CineService();
    ArrayList <Espectadores> peopleList = new ArrayList();

    public void generarEspectadores(Cine cinema) {
        int num;
        System.out.println("Cuántas entradas desea sacar?");
        num = leer.nextInt();
        for (int i = 0; i < num; i++) {
            Espectadores people = new Espectadores();
            System.out.println("Ingrese nombre y apellido para entrada "+(i+1));
            people.setName(leer.next());
            System.out.println("Ingrese edad:");
            people.setYearsOld(leer.nextInt());
            System.out.println("Ingrese el dinero disponible ");
            people.setMoney(leer.nextDouble());
            peopleList.add(people);
        }
        cinema.setPeople(peopleList);
    }

    public boolean verificarEdad(Cine cine) {
        boolean flag = false;
        int count=0;
        for (Espectadores e : cine.getPeople()) {
            if (e.getYearsOld()>=18) {
                count++;
            }
        }
        if (count==cine.getPeople().size()) {
            flag=true;
        }
        return flag;
    }

}
