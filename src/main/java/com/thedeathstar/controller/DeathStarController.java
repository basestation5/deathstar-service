package com.thedeathstar.controller;


//import com.thedeathstar.model.DeathStars;
import com.thedeathstar.model.DeathStar;
import com.thedeathstar.repository.DeathStarRepository;
import com.thedeathstar.repository.DeathStarRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by Jeremy on 6/16/17.
 */


@RestController
@RequestMapping("/deathstars")
public class DeathStarController {

    @Autowired
    public DeathStarController(DeathStarRepository _repo)
    {
        repo = _repo;
    }

    private DeathStarRepository repo;

    @GetMapping("")
    public ResponseEntity<List<DeathStar>> GetDeathstars(){

        return new ResponseEntity<>(repo.GetDeathstars(),HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<DeathStar> GetDeathstar(@PathVariable String id){

        return new ResponseEntity<>(repo.GetDeathstar(),HttpStatus.OK);
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