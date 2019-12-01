package com.example.videogame_java.controllers;

import com.example.videogame_java.models.Developer;
import com.example.videogame_java.repositories.DevRepository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
  ;import java.util.List;

@RestController
    @CrossOrigin(origins = "*")
    public class UserController {
      @Autowired
      DevRepository devRepository;


  @GetMapping("/api/developers")
  public List<Developer> findAllDevelopers() {
    return devRepository.findAllDevs();
  }

}




