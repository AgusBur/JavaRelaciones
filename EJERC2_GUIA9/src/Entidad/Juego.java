/*
Clase Juego: esta clase posee los siguientes atributos: Jugadores (conjunto de Jugadores) y
Revolver
Métodos:
• llenarJuego(ArrayList<Jugador>jugadores, Revolver r): este método recibe los jugadores
y el revolver para guardarlos en los atributos del juego.
10
• ronda(): cada ronda consiste en un jugador que se apunta con el revolver de agua y
aprieta el gatillo. Sí el revolver tira el agua el jugador se moja y se termina el juego, sino se
moja, se pasa al siguiente jugador hasta que uno se moje. Si o si alguien se tiene que
mojar. Al final del juego, se debe mostrar que jugador se mojó.
Pensar la lógica necesaria para realizar esto, usando los atributos de la clase Juego.
 */
package Entidad;

import Service.RevolverService;
import java.util.ArrayList;

public class Juego {
    
    private ArrayList <Jugador> players;
    private RevolverService r;
    private int amount;

    public Juego() {
    }

    public Juego(ArrayList<Jugador> players, RevolverService r, int amount) {
        this.players = players;
        this.r = r;
        this.amount = amount;
    }

    public ArrayList<Jugador> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Jugador> players) {
        this.players = players;
    }

    public RevolverService getR() {
        return r;
    }

    public void setR(RevolverService r) {
        this.r = r;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
