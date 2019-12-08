package com.example.videogame_java.controllers;
import com.example.videogame_java.models.Game;
import com.example.videogame_java.models.Review;
import com.example.videogame_java.repositories.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
;import java.util.List;

@CrossOrigin(origins = "*")
@RestController

public class GameController {
  @Autowired
  GameRepository repository;

  @GetMapping("/api/games/{gid}")
  public Game findGameById(
      @PathVariable("gid")
          Integer gid) {
    return repository.findGameById(gid);
  }

  @GetMapping("/api/games")
    public List<Game> findAllGames() {
    return repository.findAllGames();

  }

  @PostMapping("/api/games")
  public Game createGame(
      @RequestBody Game game) {
    return repository.save(game);
  }

  @GetMapping("/api/developers/{uid}/games")
  public List<Game> findAllGamesByUser(
      @PathVariable("uid") Integer uid) {
    return repository.findAllGamesByUser(uid);
  }

  @DeleteMapping("/api/games/{gid}")
  public List<Game> deleteGame(@PathVariable("gid") Integer gid) {
    repository.delete(this.findGameById(gid));
    return repository.findAllGames();
  }

  @PutMapping("api/games/{wid}")
  public void updateGame(@PathVariable("wid") Integer id,
                                   @RequestBody Game newGame) {
    Game game = repository.findGameById(id);
    game.update(newGame);
    repository.save(game);
  }

}
