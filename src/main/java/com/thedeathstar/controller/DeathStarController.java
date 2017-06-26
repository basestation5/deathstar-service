package com.thedeathstar.controller;


import com.thedeathstar.model.DeathStars;
import com.thedeathstar.model.DeathStar;
import com.thedeathstar.repository.DeathStarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Jeremy on 6/16/17.
 */


@RestController
@RequestMapping("/deathstars")
public class DeathStarController {

    @GetMapping("")
    public ResponseEntity<DeathStars> GetDeathstars(){

        DeathStarRepository repo = new DeathStarRepository();

        return new ResponseEntity<>(repo.GetDeathstars(),HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<DeathStar> GetDeathstar(@PathVariable String id){

        DeathStarRepository repo = new DeathStarRepository();

        return new ResponseEntity<>(repo.GetDS1(),HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity UpdateDeathstar() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity AddDeathstar() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity DeleteDeathstar() {
        return new ResponseEntity<>(HttpStatus.OK);
    }


}