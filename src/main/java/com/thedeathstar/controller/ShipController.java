package com.thedeathstar.controller;

import com.thedeathstar.model.Ship;
import com.thedeathstar.repository.ShipRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Jeremy on 6/30/17.
 */

@RestController
@RequestMapping("/deathstars/ships")
public class ShipController {

    @Autowired
    public ShipController(ShipRepositoryImpl _repo){

        repo = _repo;
    }

    private ShipRepositoryImpl repo;

    @GetMapping("")
    public ResponseEntity<List<Ship>> GetShips(){

        return new ResponseEntity<>(repo.GetShips(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Ship> GetShip(@PathVariable("id") int id){

        return new ResponseEntity<>(repo.GetShip(id), HttpStatus.OK);

    }
}
