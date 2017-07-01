package com.thedeathstar.controller;

import com.thedeathstar.model.DeathStar;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Jeremy on 6/30/17.
 */

@RestController
@RequestMapping("")
public class TrapController {

    @GetMapping("")
    public String GetTrap(){

        return "Its a Trap!!!!!!";

    }

}
