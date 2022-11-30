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
package Service;

import Entidad.Juego;
import Entidad.Jugador;
import java.util.ArrayList;
import java.util.Scanner;

public class JuegoService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Juego game = new Juego();
    ArrayList<Jugador> playerList = new ArrayList();
    RevolverService r = new RevolverService();
    JugadorService p = new JugadorService();

    private void crearJugadores() {
        //num para contador de ID
        //count para contar que no se pase del máx de jugadores que puso el usuario
        int num = 0;
        int count = 0;
        setearCantidad();
        while (count < game.getAmount()) {
            Jugador player = new Jugador();
            setearId(player, num);
            setearNombre(player);
            setearMojado(player);
            playerList.add(player);
            count++;
            num++;
        }
    }

    private void setearCantidad() {
        int answ;
        System.out.println("Ingrese cantidad de jugadores:");
        answ = leer.nextInt();
        if (answ > 0 && answ < 6) {
            game.setAmount(answ);
        } else {
            game.setAmount(6);
        }
    }
    
    private void setearMojado(Jugador player) {
        player.setWet(false);
    }

    private void setearNombre(Jugador player) {
        player.setName("Jugador " + player.getId());
    }

    private void setearId(Jugador player, int num) {
        num++;
        player.setId(num);
    }

    private void llenarJuego(ArrayList<Jugador> playerList, RevolverService r) {
        game.setPlayers(playerList);
        game.setR(r);
    }

    public void correrJuego() {

        System.out.println("===================BIENVENIDO A LA RULETA DEL AGUA!!===================");
        llenarJuego(playerList, r);
        game.getR().llenarRevolver();
        System.out.println("Se designó al azar un chorro de agua en uno de los 6 tambores");
        crearJugadores();
        int count = 0;
        boolean flag = false;
        do {
            if (count==game.getAmount()) {
                count=0;
            }
            game.getR().mostrarInfoRevolver();
            System.out.println("Es el turno del: " + game.getPlayers().get(count).getName());
            System.out.println("Se prepara para disparar...");
            if (p.disparar(game.getR(),count,game.getPlayers())) {
                System.out.println("TE MOJASTE!!!");
                //game.getPlayers().get(count).setWet(true);
                flag = true;
                System.out.println("========================================================================");
                break;
            } else {
                System.out.println("NO HABIA AGUA!!");
                System.out.println("Se pasa el revólver al jugador de al lado");
                System.out.println("========================================================================");
            }
            count++;
        } while (flag == false);

        System.out.println("Fin del juego!!!");
        System.out.print("El jugador mojado fue: ");
        for (Jugador p : game.getPlayers()) {
            if (p.isWet()) {
                System.out.println(p.getName());
            }
        }
    }
}
