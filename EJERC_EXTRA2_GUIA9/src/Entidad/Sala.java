/*
 Para representar la sala con los espectadores vamos a utilizar una matriz. Los asientos son
etiquetados por una letra y un número la fila A1 empieza al final del mapa como se muestra en
la tabla. También deberemos saber si el asiento está ocupado por un espectador o no, si esta
ocupado se muestra una X, sino un espacio vacío.
8 A X | 8 B X | 8 C X | 8 D | 8 E X | 8 F X
7 A X | 7 B X | 7 C X | 7 D X | 7 E | 7 F X
6 A X | 6 B X | 6 C | 6 D X | 6 E X | 6 F
5 A X | 5 B X | 5 C X | 5 D X | 5 E X | 5 F X
4 A X | 4 B X | 4 C X | 4 D X | 4 E X | 4 F X
3 A X | 3 B X | 3 C X | 3 D | 3 E X | 3 F X
2 A X | 2 B | 2 C X | 2 D X | 2 E X | 2 F
1 A X | 1 B X | 1 C X | 1 D X | 1 E X | 1 F X
Se debe realizar una pequeña simulación, en la que se generen muchos espectadores y se los
ubique en los asientos aleatoriamente (no se puede ubicar un espectador donde ya este
ocupado el asiento).
 */
package Entidad;

/**
 * @author Agustina
 */
public class Sala {
    
    private String letter;
    private int num;
    private boolean taken;
    private String state;

    public Sala() {
    }
    
    public Sala(int num, String letter) {   
        this.num = num;
        this.letter = letter;
        this.taken = false;
        this.state = " ";
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return " "+num + letter+ state+" ";
    }
}
