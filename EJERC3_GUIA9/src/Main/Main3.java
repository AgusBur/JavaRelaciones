/*
Realizar una baraja de cartas españolas (las del truco) orientada a objetos. Una carta 
tiene un número entre 1 y 12 (el 8 y el 9 no los incluimos) y un palo 
(espadas, bastos, oros y copas). Esta clase debe
contener un método toString() que retorne el número de carta y el palo. La baraja estará
compuesta por un conjunto de cartas, 40 exactamente.
Las operaciones que podrá realizar la baraja son:
• barajar(): cambia de posición todas las cartas aleatoriamente.
• siguienteCarta(): devuelve la siguiente carta que está en la baraja, cuando no haya más o
se haya llegado al final, se indica al usuario que no hay más cartas.
• cartasDisponibles(): indica el número de cartas que aún se puede repartir.
• darCartas(): dado un número de cartas que nos pidan, le devolveremos ese número de
cartas. En caso de que haya menos cartas que las pedidas, no devolveremos nada, pero
debemos indicárselo al usuario.
• cartasMonton(): mostramos aquellas cartas que ya han salido, si no ha salido ninguna
indicárselo al usuario
• mostrarBaraja(): muestra todas las cartas hasta el final. Es decir, si se saca una carta y
luego se llama al método, este no mostrara esa primera carta.
 */
package Main;

import Service.CartaService;
import java.util.Scanner;

/**
 * @author Agustina
 */
public class Main3 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        CartaService cs = new CartaService();
        int op;

        System.out.println("==============BIENVENIDO AL JUEGO DE CARTAS==============");
        cs.cargarCartas();
        do {
            System.out.println("Que desea hacer?");
            System.out.println("1: mezclar cartas");
            System.out.println("2: mostrar cartas del mazo");
            System.out.println("3: devolver la siguiente carta del mazo");
            System.out.println("4: ver número de cartas disponibles en mazo");
            System.out.println("5: ver cartas que ya salieron");
            System.out.println("6: dar cartas");
            System.out.println("7: Salir");
            op = leer.nextInt();
            switch (op) {
                case 1:
                    cs.barajarCartas();
                    break;
                case 2:
                    cs.mostrarCartasMazo();
                    break;
                case 3:
                    cs.devolverSiguiente();
                    break;
                case 4:
                    cs.verCartasDisponibles();
                    break;
                case 5:
                    cs.cartasAdivinadas();
                    break;
                case 6:
                    cs.darCartas();
                    break;
                case 7:
                    System.out.println("Saliendo..");
                    break;
                default:
                    System.out.println("Opción ingresada inválida");
                    break;
            }
        } while (op != 7);
    }

}
