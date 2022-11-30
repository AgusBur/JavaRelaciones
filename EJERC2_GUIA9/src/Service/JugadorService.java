/*
 Métodos:
• disparo(Revolver r): el método, recibe el revolver de agua y llama a los métodos de
mojar() y siguienteChorro() de Revolver. El jugador se apunta, aprieta el gatillo y si el
revolver tira el agua, el jugador se moja. El atributo mojado pasa a false y el método
devuelve true, sino false.
 */
package Service;

import Entidad.Jugador;
import java.util.ArrayList;

public class JugadorService {

    Jugador player = new Jugador();

    public boolean disparar(RevolverService r, int count, ArrayList <Jugador> player) {
        boolean flag = false;
        
        if (r.mojar()) {
            player.get(count).setWet(true);
            flag = true;
        } else {
            r.moverTambor();
        }
        return flag;
    }
}
