
import edu.eci.arsw.cinema.filters.FilterAvailability;
import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Movie;
import edu.eci.arsw.cinema.services.CinemaException;
import edu.eci.arsw.cinema.services.CinemaServices;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JUAN NIETO
 */
public class FilterAvailabilityTest {
    
    @Test
    public void filtrarDisponibilidad() throws CinemaException{
        String functionDate;
        functionDate = "2020-9-1 15:30";
        FilterAvailability fa = new FilterAvailability();
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
            fa.filter(functions, "2");
        }catch (CinemaException e){
                assertEquals("No hay funciones que cumplan sus requisitos", e.getMessage() );
        }  
    }
    
    @Test
    public void filtrarNumeros(){
        String functionDate;
        functionDate = "2020-9-1 15:30";
        FilterAvailability fa = new FilterAvailability();
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
            fa.filter(functions, ".");
        }
        catch (CinemaException e){
                assertEquals("Los valores deben ser numeros positivos", e.getMessage() );
        }
    }
    
    @Test
    public void filtrarNumerosPositivos(){
        String functionDate;
        functionDate = "2020-9-1 15:30";
        FilterAvailability fa = new FilterAvailability();
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
            fa.filter(functions, "-1");
        }
        catch (CinemaException e){
                assertEquals("Los valores deben ser positivos", e.getMessage() );
        }        
    }
    
    @Test
    public void filtrarCondicionesCorrectas() throws CinemaException{
        String functionDate = "2020-9-1 15:30";
        List<CinemaFunction> functions= new ArrayList<>();
        FilterAvailability fa = new FilterAvailability();
        CinemaFunction funct1 = new CinemaFunction(new Movie("The Gentleman","Action"),functionDate);
        functions.add(funct1);
        funct1.buyTicket(0, 0);
        funct1.buyTicket(2, 3);
        funct1.buyTicket(0, 5);
        
        try{
            fa.filter(functions, "2");
        }
        catch (CinemaException e){
                assertEquals(8, e.getMessage() );
        } 
        
    }
    
}
