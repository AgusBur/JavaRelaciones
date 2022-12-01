/*
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
package Service;

import Entidad.Carta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CartaService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ArrayList<Carta> cardList = new ArrayList();
    ArrayList<Carta> guessCards = new ArrayList();

    public void cargarCartas() {

        String s = "";
        for (int i = 1; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 8 || i == 9) {
                    break;
                } else {
                    switch (j) {
                        case 0:
                            s = "BASTO";
                            break;
                        case 1:
                            s = "ORO";
                            break;
                        case 2:
                            s = "ESPADA";
                            break;
                        case 3:
                            s = "COPA";
                            break;
                    }
                }
                Carta let = new Carta();
                let.setNum(i);
                let.setPalo(s);
                cardList.add(let);
            }
        }
    }

    public void barajarCartas() {
        Collections.shuffle(cardList);
    }

    public void devolverSiguiente() {
        for (Carta c : cardList) {
            for (int i = 0; i < 1; i++) {
                System.out.println("La carta que salió es:");
                System.out.println(c);
                cardList.remove(c);
                guessCards.add(c);
                break;
            }
            break;
        }
    }

    public void verCartasDisponibles() {
        System.out.println("Todavía quedan dosponibles: " + cardList.size() + " cartas");
    }

    public void darCartas() {
        int op;
        System.out.println("Cuántas cartas desea sacar?");
        op = leer.nextInt();
        
        if (op <= cardList.size()) {
            System.out.println("Cartas:");
            for (int i = 0; i < op; i++) {
                for (Carta c : cardList) {
                    for (int j = 0; j < 1; i++) {
                        System.out.println(c);
                        cardList.remove(c);
                        guessCards.add(c);
                        break;
                    }
                    break;
                }
            }
        } else {
            System.out.println("No se puede entregar esa cantidad, no hay tantas disponibles");
        }
    }
    
    public void cartasAdivinadas() {
        if (guessCards.size()>0) {
            for (Carta c : guessCards) {
                System.out.println(c);
            }
        } else {
            System.out.println("Todavía no salió ninguna carta del mazo");
        }
    }
    
    public void mostrarCartasMazo() {
        for (Carta c : cardList) {
            System.out.println(c);
        }
    }
}
