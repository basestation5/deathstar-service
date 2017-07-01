package com.thedeathstar.model;

import java.util.List;

/**
 * Created by Jeremy on 6/16/17.
 */
public class DeathStar {

    private String id;

    private String name;

    private List<Hanger> hangers;

    private List<Ship> ships;

    //Getters and Setters

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public List<Hanger> getHangers() {
        return hangers;
    }

    public void setHangers(List<Hanger> hangers) {
        this.hangers = hangers;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

}
