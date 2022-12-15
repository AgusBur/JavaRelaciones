/*
 */
package Service;

import Entidad.Cine;
import Entidad.Pelicula;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author Agustina
 */
public class PeliculaService {
    
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    //Cine cinema = new Cine();
    ArrayList <Pelicula> movieList = new ArrayList();
    
    public void crearListaPelis(Cine cinema) {
        
            Pelicula movie = new Pelicula();
            movie.setTitle("Harry Potter");
            movie.setDirector("J.K Rowling");
            movie.setMinutes(150);
            movie.setYears(0);
            movieList.add(movie);
            Pelicula movie2 = new Pelicula();
            movie2.setTitle("Avatar");
            movie2.setDirector("Disney");
            movie2.setMinutes(190);
            movie2.setYears(0);
            movieList.add(movie2);
            Pelicula movie3 = new Pelicula();
            movie3.setTitle("Orgullo y prejuicio");
            movie3.setDirector("Joe Wright");
            movie3.setMinutes(130);
            movie3.setYears(18);
            movieList.add(movie3);
            Pelicula movie4 = new Pelicula();
            movie4.setTitle("El orfanato");
            movie4.setDirector("J.A Bayona");
            movie4.setMinutes(105);
            movie4.setYears(18);
            movieList.add(movie4);
            Pelicula movie5 = new Pelicula();
            movie5.setTitle("Coco");
            movie5.setDirector("Disney");
            movie5.setMinutes(150);
            movie5.setYears(0);
            movieList.add(movie5);
            Pelicula movie6 = new Pelicula();
            movie6.setTitle("El diablo viste a la moda");
            movie6.setDirector("David Frankel");
            movie6.setMinutes(110);
            movie6.setYears(18);
            movieList.add(movie6);
 
            cinema.setMovie(movieList);
    }
    
    public void mostrarPelisNombre(Cine cinema) {
        System.out.println("================LISTA DE PELICULAS================");
        for (Pelicula p : cinema.getMovie()) {
            System.out.println(p.getTitle());
        }
    }
    
    public void mostrarPelisATP(Cine cinema) {
        System.out.println("================LISTA DE PELICULAS ATP================");
        for (Pelicula p : cinema.getMovie()) {
            if (p.getYears()==0) {
                System.out.println(p.getTitle());
            }
        }
    }
    
    public void mostrarPelisMayorEdad() {
        System.out.println("================LISTA DE PELICULAS================");
        for (Pelicula p : movieList) {
            if (p.getYears()==18) {
                System.out.println(p.getTitle());
            }
        }
    }
}
