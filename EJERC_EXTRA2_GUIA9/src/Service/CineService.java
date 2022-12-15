/*
 */
package Service;

import Entidad.Cine;
import Entidad.Espectadores;
import Entidad.Pelicula;
import Entidad.Sala;
import java.util.Scanner;

/**
 * @author Agustina
 */
public class CineService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Cine cine = new Cine();
    Sala matriz[][] = new Sala[8][6];

    private void crearSala() {

        int num = 8;
        String letter = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                switch (j) {
                    case 0:
                        letter = "A";
                        break;
                    case 1:
                        letter = "B";
                        break;
                    case 2:
                        letter = "C";
                        break;
                    case 3:
                        letter = "D";
                        break;
                    case 4:
                        letter = "E";
                        break;
                    case 5:
                        letter = "F";
                        break;
                }
                Sala room = new Sala();
                room.setNum(num);
                room.setLetter(letter);
                room.setState(" ");
                matriz[i][j] = room;
            }
            num--;
        }
        cine.setRoom(matriz);
    }

    private boolean verLugarGeneral() {
        boolean flag = false;
        int num, num2 = 0;
        num = cine.getPeople().size();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                if (!cine.getRoom()[i][j].isTaken()) {
                    num2++;
                }
            }
        }
        if (num <= num2) {
            flag = true;
        }
        return flag;
    }

    private void verLugarParticular() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                if (matriz[i][j].getState().equalsIgnoreCase("T")) {
                    matriz[i][j].setTaken(false);
                    matriz[i][j].setState(" ");
                }
            }
        }
        System.out.println("=============COMPRAR BUTACAS==============");
        int num, numColumn = 0;
        String letter1, letter2;
        boolean flag = false;
        System.out.println("Elegir asientos sin la X, la cual indica que está ocupado");
        for (Espectadores p : cine.getPeople()) {
            do {
                System.out.println("Ingrese el asiento vacío para " + p.getName());
                System.out.println("Ingrese fila:");
                num = leer.nextInt();
                System.out.println("Ingrese columna:");
                letter1 = leer.next();

                for (int j = 0; j < 7; j++) {
                    switch (j) {
                        case 0:
                            letter2 = "A";
                            if (verLetrasIgualdad(letter1, letter2)) {
                                numColumn = j;
                            }
                            break;
                        case 1:
                            letter2 = "B";
                            if (verLetrasIgualdad(letter1, letter2)) {
                                numColumn = j;
                            }
                            break;
                        case 2:
                            letter2 = "C";
                            if (verLetrasIgualdad(letter1, letter2)) {
                                numColumn = j;
                            }
                            break;
                        case 3:
                            letter2 = "D";
                            if (verLetrasIgualdad(letter1, letter2)) {
                                numColumn = j;
                            }
                            break;
                        case 4:
                            letter2 = "E";
                            if (verLetrasIgualdad(letter1, letter2)) {
                                break;
                            }
                        case 5:
                            letter2 = "F";
                            if (verLetrasIgualdad(letter1, letter2)) {
                                numColumn = j;
                            }
                            break;
                        case 6:
                            letter2 = "G";
                            if (verLetrasIgualdad(letter1, letter2)) {
                                numColumn = j;
                            }
                            break;
                    }
                }
                if (!cine.getRoom()[verNumero(num)][numColumn].isTaken()) {
                    System.out.println("Genial! Asiento asignado correctamente");
                    flag = true;
                } else {
                    System.out.println("Asiento OCUPADO");
                }
            } while (!flag);
            cine.getRoom()[verNumero(num)][numColumn].setTaken(flag);
            cine.getRoom()[verNumero(num)][numColumn].setState("T");
        }
    }

    private boolean verLetrasIgualdad(String letter1, String letter2) {
        boolean flag = false;
        if (letter1.equalsIgnoreCase(letter2)) {
            flag = true;
        }
        return flag;
    }

    private int verNumero(int num) {
        int num2 = 0;
        switch (num) {
            case 1:
                num2 = 7;
                break;
            case 2:
                num2 = 6;
                break;
            case 3:
                num2 = 5;
                break;
            case 4:
                num2 = 4;
                break;
            case 5:
                num2 = 3;
                break;
            case 6:
                num2 = 2;
                break;
            case 7:
                num2 = 1;
                break;
            case 8:
                num2 = 0;
                break;

        }
        return num2;
    }

    private void mostrarSala() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(matriz[i][j].toString());
            }
            System.out.println("");
        }
    }

    private void ponerAleatorio() {
        String place = "";
        for (int i = 0; i < (int) (Math.random() * 48); i++) {
            cine.getRoom()[(int) (Math.random() * 7)][(int) (Math.random() * 6)].setTaken(true);
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                if (cine.getRoom()[i][j].isTaken()) {
                    cine.getRoom()[i][j].setState("X");
                }
            }
        }
    }

    private void elegirPeli() {
        PeliculaService ps = new PeliculaService();
        EspectadoresService es = new EspectadoresService();
        String op = "";
        int count = 0;
        boolean flag = false;
        crearSala();
        ponerAleatorio();
        ps.crearListaPelis(cine);
        es.generarEspectadores(cine);
        System.out.println("");
        ps.mostrarPelisNombre(cine);
        System.out.println("================================================");
        System.out.println("Que película deseas ver?");
        op = leer.next();
        do {
            for (Pelicula m : cine.getMovie()) {
                if (m.getTitle().equalsIgnoreCase(op)) {
                    break;
                }
                count++;
            }
            if (comprobarSiPuedenVer(count, es)) {
                flag = true;
            } else {
                System.out.println("La peli elegida es para +18, "
                        + "hay algún menor entre los espectadores...");
                System.out.println("Las pelis que sí pueden elegir:");
                System.out.println("");
                ps.mostrarPelisATP(cine);
                System.out.println("================================================");
                System.out.println("Que película deseas ver?");
                op = leer.next();
            }
        } while (!flag);
        System.out.println("Buenisimo!! Película seleccionada correctamente");
    }

    private boolean comprobarSiPuedenVer(int count, EspectadoresService es) {
        boolean flag = false;
        if (cine.getMovie().get(count).getYears() == 0) {
            flag = true;
        } else {
            if (es.verificarEdad(cine)) {
                flag = true;
            }
        }
        return flag;
    }

    public void ubicarAsientos() {
        PeliculaService ps = new PeliculaService();
        EspectadoresService es = new EspectadoresService();
        String op;
        System.out.println("==================BIENVENIDO A CINEAGUS======================");
        do {
            elegirPeli();
            if (!verLugarGeneral()) {
                System.out.println("Disculpe. No hay tantos lugares disponibles en la sala para esa peli elegida");
            }
        } while (!verLugarGeneral());
        System.out.println("Si hay asientos disponibles");
        System.out.println("");
        System.out.println("          pantalla           ");
        System.out.println("=============================");
        mostrarSala();
        System.out.println("");
        verLugarParticular();
        System.out.println("=============================================================");
        System.out.println("Sus lugares elegidos aparecerán con una T");
        mostrarSala();
        System.out.println("Presione S para confirmar sus asientos o N para cambiar");
        op = leer.next();
        while (op.equalsIgnoreCase("n")) {
            verLugarParticular();
            mostrarSala();
            System.out.println("Presione S para confirmar sus asientos o N para cambiar");
            op = leer.next();
        }
        System.out.println("SUS ASIENTOS FUERON ASIGNADOS!! ");
        System.out.println("=================Muchas gracias por elegirnos!!=================");
    }
}
