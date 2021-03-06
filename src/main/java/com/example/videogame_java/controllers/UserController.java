package com.example.videogame_java.controllers;

import com.example.videogame_java.models.Consumer;
import com.example.videogame_java.models.Developer;
import com.example.videogame_java.models.Game;
import com.example.videogame_java.repositories.ConsumerRepository;
import com.example.videogame_java.repositories.DevRepository;
import com.example.videogame_java.repositories.GameRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.lang.reflect.Array;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
    public class UserController {
      @Autowired
      DevRepository devRepository;
      @Autowired
      ConsumerRepository conRepository;
      @Autowired
      GameRepository gameRepository;



  @GetMapping("/api/developers")
  public List<Developer> findAllDevelopers() {
    return devRepository.findAllDevs();
  }

  @GetMapping("/api/developers/{did}")
  public Developer findDeveloperById(@PathVariable("did") Integer id) {
    return devRepository.findDeveloperById(id);
  }


  @GetMapping("/api/consumers")
  public List<Consumer> findAllConsumers() {
    return conRepository.findAllConsumers();
  }

  @GetMapping("/api/consumers/{cid}")
  public Consumer findConsumerById(@PathVariable("cid") Integer id) {
    return conRepository.findConsumerById(id);
  }


  @PostMapping("/api/consumers")
  public void createConsumer(@RequestBody Consumer consumer) {
    conRepository.save(consumer);
  }

  @PostMapping("/api/developers")
  public void createDeveloper(@RequestBody Developer developer) {
    devRepository.save(developer);
  }

  @DeleteMapping("/api/consumers/{cid}")
  public void deleteConsumer(@PathVariable("cid") Integer cid) {
    conRepository.delete(this.findConsumerById(cid));
  }

  @DeleteMapping("/api/developers/{did}")
  public void deleteDeveloper(@PathVariable("did") Integer did) {
    devRepository.delete(this.findDeveloperById(did));
  }

  @PutMapping("api/developers/{did}")
  public void updateDeveloper(@PathVariable("did") Integer did,
                           @RequestBody Developer newDev) {
    Developer dev = devRepository.findDeveloperById(did);
    dev.update(newDev);
    devRepository.save(dev);
  }

  @PutMapping("api/consumers/{cid}")
  public void updateConsumer(@PathVariable("cid") Integer cid,
                           @RequestBody Consumer newConsumer) {
    Consumer consumer = conRepository.findConsumerById(cid);
    consumer.update(newConsumer);
    conRepository.save(consumer);
  }

  @GetMapping("/api/games/{gid}/developers")
  public List<Developer> findAllDevsByGame(
      @PathVariable("gid") Integer gid) {
    return devRepository.findAllDevsByGame(gid);
  }

  @PutMapping("/api/games/{gid}/developers")
  public void addDevsByGame(@PathVariable("gid") Integer gid, @RequestBody Developer[] devs) {
    Game game = gameRepository.findGameById(gid);
    game.updateDevs(devs);
    gameRepository.save(game);
  }

  @PostMapping("/api/developers/{did}/games")
  public void addGameToDev(@PathVariable("did") Integer id,
                           @RequestBody Game game) {
    Developer dev = devRepository.findDeveloperById(id);
    dev.updateGames(game);
    devRepository.save(dev);
  }

}




