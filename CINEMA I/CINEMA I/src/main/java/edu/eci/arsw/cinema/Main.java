package edu.eci.arsw.cinema;

import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Movie;
import edu.eci.arsw.cinema.services.CinemaServices;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        
        
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("cinemaContext.xml");
        CinemaServices cine = applicationContext.getBean(CinemaServices.class);
        
        
        registerCinemas("LAB3 Cinemas",cine);
        consultCinemas(cine);
        obtainFuntionByCinema("LAB3 Cinemas",cine);
        //buyTickets(5, 5, cine, "2020-9-1 15:30", "The Gentleman");
        //bookTickets(5, 5, cine, "2020-10-30 15:30", "Viuda Negra");
          
    }
    
    public static void registerCinemas(String cinema,CinemaServices cine){
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("-----------------------------");
        System.out.println("Registrando Cinemas a "+cinema);
        String functionDate = "2020-12-18 15:30";
        List<CinemaFunction> functions= new ArrayList<>();
        CinemaFunction funct1 = new CinemaFunction(new Movie("The Gentleman","Action"),functionDate);
        CinemaFunction funct2 = new CinemaFunction(new Movie("Pinocho","Childish"),functionDate);
        CinemaFunction funct3 = new CinemaFunction(new Movie("Greyhound: En la Mira del Enemigo Pelicula Completa","Action"),functionDate);
        functions.add(funct1);
        functions.add(funct2);
        functions.add(funct3);
        Cinema c = new Cinema(cinema,functions);
        cine.addNewCinema(c);
        System.out.println("Cinemas agregado");
    }
    
    public static void consultCinemas(CinemaServices cine){
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("-----------------------------");
        System.out.println("Consultado cinemas disponibles");
        Map<String,Cinema> cinemas = cine.getAllCinemas();
        for(Map.Entry<String, Cinema> fun : cinemas.entrySet()){
         System.out.println(fun.getValue().getName());   
        } 
    }
    
    public static void obtainFuntionByCinema(String name,CinemaServices cine){
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("-----------------------------");
        System.out.println("Obteniendo funcion por titulo de un cinema");
        Map<String,Cinema> cinemas = cine.getAllCinemas();
        for(Map.Entry<String, Cinema> fun : cinemas.entrySet()){
            Cinema temp = fun.getValue();
            System.out.println(fun.getValue().getName());
            for(CinemaFunction cin : temp.getFunctions()){
                System.out.println(cin.getMovie().getName()+" "+cin.getDate());
            }       
        }
    }
    
    /*
    public static void buyTickets(int row, int col, CinemaServices cinema, String date, String movieName){
    
    }
    
    public static void bookTickets(int row, int col, CinemaServices cinema, String date, String movieName){
    
    }
    */
}
