package com.thedeathstar.repository;

import com.thedeathstar.model.Ship;

import java.util.List;

/**
 * Created by Jeremy on 7/10/17.
 */
public interface ShipsRepository {

    List<Ship> GetShips();

    Ship GetShip(int id);
}
