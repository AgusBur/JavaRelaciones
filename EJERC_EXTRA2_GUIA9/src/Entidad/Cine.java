/*
De Cine nos interesa conocer la película que se está reproduciendo, la
sala con los espectadores y el precio de la entrada. Luego, de las películas nos interesa saber
el título, duración, edad mínima y director. Por último, del espectador, nos interesa saber su
nombre, edad y el dinero que tiene disponible.
 */
package Entidad;

import java.util.*;

public class Cine {

    private ArrayList<Pelicula> movie;
    private ArrayList<Espectadores> people;
    private double price;
    private Sala room[][];

    public Cine() {
        this.price = 600;
    }

    public Cine(ArrayList<Pelicula> movie, ArrayList<Espectadores> people, double price, Sala[][] room) {
        this.movie = movie;
        this.people = people;
        this.price = 600;
        this.room = room;
    }

    public ArrayList<Pelicula> getMovie() {
        return movie;
    }

    public void setMovie(ArrayList<Pelicula> movie) {
        this.movie = movie;
    }

    public ArrayList<Espectadores> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Espectadores> people) {
        this.people = people;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Sala[][] getRoom() {
        return room;
    }

    public void setRoom(Sala[][] room) {
        this.room = room;
    }

}
