/*
Métodos:
• llenarRevolver(): le pone los valores de posición actual y de posición del agua. Los valores
deben ser aleatorios.
• mojar(): devuelve true si la posición del agua coincide con la posición actual
• siguienteChorro(): cambia a la siguiente posición del tambor
• toString(): muestra información del revolver (posición actual y donde está el agua)
 */
package Service;

import Entidad.RevolverDeAgua;
import java.util.Scanner;

public class RevolverService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    RevolverDeAgua ra = new RevolverDeAgua();

    public void llenarRevolver() {
        int num1, num2;
        num1 = (int) (Math.random() * 6 + 1);
        num2 = (int) (Math.random() * 6 + 1);
        ra.setActPosition(num1);
        ra.setAquaPosition(num2);
    }

    public boolean mojar() {
        boolean answ = false;
        if (ra.getActPosition() == ra.getAquaPosition()) {
            answ = true;
        }
        return answ;
    }

    public void moverTambor() {
        if (ra.getActPosition() < 6) {
            ra.setActPosition(ra.getActPosition()+1);
        } else {
            ra.setActPosition(1);
        }
    }

    public void mostrarInfoRevolver() {
        System.out.println(ra.toString());
    }
}
