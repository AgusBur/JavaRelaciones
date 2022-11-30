/*
 Clase Revolver de agua: esta clase posee los siguientes atributos: posición actual (posición
del tambor que se dispara, puede que esté el agua o no) y posición agua (la posición del
tambor donde se encuentra el agua). Estas dos posiciones, se generarán aleatoriamente.
Métodos:
• llenarRevolver(): le pone los valores de posición actual y de posición del agua. Los valores
deben ser aleatorios.
• mojar(): devuelve true si la posición del agua coincide con la posición actual
• siguienteChorro(): cambia a la siguiente posición del tambor
• toString(): muestra información del revolver (posición actual y donde está el agua)
 */
package Entidad;

public class RevolverDeAgua {
    
    private int actPosition;
    private int aquaPosition;

    public RevolverDeAgua() {
    }

    public RevolverDeAgua(int actPosition, int aquaPosition) {
        this.actPosition = actPosition;
        this.aquaPosition = aquaPosition;
    }

    public int getActPosition() {
        return actPosition;
    }

    public void setActPosition(int actPosition) {
        this.actPosition = actPosition;
    }

    public int getAquaPosition() {
        return aquaPosition;
    }

    public void setAquaPosition(int aquaPosition) {
        this.aquaPosition = aquaPosition;
    }

    @Override
    public String toString() {
        return "Revolver de agua " + "Posicion actual: " + actPosition + ", Posicion del agua: " + aquaPosition;
    }
    
    
}
