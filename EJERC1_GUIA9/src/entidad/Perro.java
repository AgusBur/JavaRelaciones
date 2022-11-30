/*
 Perro, que tendrá como atributos: nombre, raza, edad y tamaño;
 */
package entidad;

public class Perro {
    
    private String name;
    private String race;
    private int years;
    private String size;

    public Perro() {
    }

    public Perro(String name, String race, int years, String size) {
        this.name = name;
        this.race = race;
        this.years = years;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + ", Raza: " + race + ", Años: " + years + ", Tamaño: " + size;
    }
    
    
}
