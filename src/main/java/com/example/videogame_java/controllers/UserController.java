package com.example.videogame_java.controllers;

import com.example.videogame_java.models.Consumer;
import com.example.videogame_java.models.Developer;
import com.example.videogame_java.repositories.ConsumerRepository;
import com.example.videogame_java.repositories.DevRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RestController
    public class UserController {
      @Autowired
      DevRepository devRepository;
      @Autowired
      ConsumerRepository conRepository;



  @GetMapping("/api/developers")
  public List<Developer> findAllDevelopers() {
    return devRepository.findAllDevs();
  }

  @GetMapping("/api/consumers")
  public List<Consumer> findAllConsumers() {
    return conRepository.findAllConsumers();
  }

}




