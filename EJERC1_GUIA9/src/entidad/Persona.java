/*
Persona con
atributos: nombre, apellido, edad, documento y Perro.
 */
package entidad;

public class Persona {
    
    
    private String name;
    private String surname;
    private int years;
    private int dni;
    private Perro dog;

    public Persona() {
    }

    public Persona(String name, String surname, int years, int dni, Perro dog) {
        this.name = name;
        this.surname = surname;
        this.years = years;
        this.dni = dni;
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Perro getDog() {
        return dog;
    }

    public void setDog(Perro dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Persona: " + 
                "Nombre: " + name + 
                ", Apellido: " + surname + 
                ", Edad: " + years + 
                ", Documento: " + dni + 
                ", Perro: " + dog;
    }
    
    
}
