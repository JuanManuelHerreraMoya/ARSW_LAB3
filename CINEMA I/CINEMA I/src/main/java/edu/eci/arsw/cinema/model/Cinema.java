/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.model;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author cristian
 */

public class Cinema {
    private String name;
    private List<CinemaFunction> functions; 
    
    
    public Cinema(){}
    
    public Cinema(String name,List<CinemaFunction> functions){
        this.name=name;
        this.functions=functions;
    }

    public CinemaFunction getFunctionByNameAndDate(String name, String date)  {
        CinemaFunction cinemaF = null;
        for (int i=0;i< functions.size();i++) {
            if (functions.get(i).getMovie().getName().equals(name) && functions.get(i).getDate().equals(date)) {
                cinemaF= functions.get(i);
                return  cinemaF;
            }
        }
        return cinemaF;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CinemaFunction> getFunctions() {
        return this.functions;
    }

    public void setSchedule(List<CinemaFunction> functions) {
        this.functions = functions;
    }
}
