/*
De Cine nos interesa conocer la película que se está reproduciendo, la
sala con los espectadores y el precio de la entrada. Luego, de las películas nos interesa saber
el título, duración, edad mínima y director. Por último, del espectador, nos interesa saber su
nombre, edad y el dinero que tiene disponible.
 */
package Entidad;


public class Pelicula {
    
    private String title;
    private int minutes;
    private int years;
    private String director;

    public Pelicula() {
    }

    public Pelicula(String title, int minutes, int years, String director) {
        this.title = title;
        this.minutes = minutes;
        this.years = years;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Pelicula " + "Título: " + title + "Director:" + director+ "Duración: " + minutes + "Edad mínima: " + years;
    }
    
    
}
