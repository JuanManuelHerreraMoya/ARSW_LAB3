
import edu.eci.arsw.cinema.filters.FilterAvailability;
import edu.eci.arsw.cinema.filters.FilterByGender;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Movie;
import edu.eci.arsw.cinema.services.CinemaException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JUAN NIETO
 */
public class FilterGenderTest {
    
    @Test
    public void pruebaDeErroPorNoTernerCategoria(){
        String functionDate;
        functionDate = "2020-9-1 15:30";
        FilterByGender fg = new FilterByGender();
        List<CinemaFunction> functions= new ArrayList<>();
        CinemaFunction funct1 = new CinemaFunction(new Movie("The Gentleman","Action"),functionDate);
        CinemaFunction funct2 = new CinemaFunction(new Movie("Pinocho","Childish"),functionDate);
        CinemaFunction funct3 = new CinemaFunction(new Movie("Greyhound: En la Mira del Enemigo Pelicula Completa","Action"),functionDate);
        functions.add(funct1);
        functions.add(funct2);
        functions.add(funct3);
        functionDate = "2018-12-18 15:30";
        CinemaFunction funct4 = new CinemaFunction(new Movie("SuperHeroes Movie","Action"),functionDate);
        CinemaFunction funct5 = new CinemaFunction(new Movie("The Night","Horror"),functionDate);
        functions.add(funct4);
        functions.add(funct5);
        
        try{
            fg.filter(functions, "Comedy");
        }catch (CinemaException e){
                assertEquals("No existen funciones con ese genero", e.getMessage() );
        }  
    }
    
    @Test
    public void encontroGenero(){
        String functionDate;
        functionDate = "2020-9-1 15:30";
        FilterByGender fg = new FilterByGender();
        
        List<CinemaFunction> functions= new ArrayList<>();
        CinemaFunction funct1 = new CinemaFunction(new Movie("The Gentleman","Action"),functionDate);
        CinemaFunction funct2 = new CinemaFunction(new Movie("Pinocho","Childish"),functionDate);
        CinemaFunction funct3 = new CinemaFunction(new Movie("Greyhound: En la Mira del Enemigo Pelicula Completa","Action"),functionDate);
        functions.add(funct1);
        functions.add(funct2);
        functions.add(funct3);
        functionDate = "2018-12-18 15:30";
        CinemaFunction funct4 = new CinemaFunction(new Movie("SuperHeroes Movie","Action"),functionDate);
        CinemaFunction funct5 = new CinemaFunction(new Movie("The Night","Horror"),functionDate);
        functions.add(funct4);
        functions.add(funct5);
        
        try{
            fg.filter(functions, "Action");
        }catch (CinemaException e){
                assertEquals("No existen funciones con ese genero", e.getMessage() );
        }  
    }
    
    @Test
    public void noHayPeliculas(){
        FilterByGender fg = new FilterByGender();
        List<CinemaFunction> functions= new ArrayList<>();

        try{
            fg.filter(functions, "Action");
        }catch (CinemaException e){
                assertEquals("Erorre al tratar de filtrar peliculas", e.getMessage() );
        }  
    }
    
}
