package com.example.videogame_java.repositories;

import com.example.videogame_java.models.Game;
import com.example.videogame_java.models.Review;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Integer> {
  @Query("select game from Game game")
  public List<Game> findAllGames();

  @Query("select game from Game game where game.id =:gid")
  public Game findGameById(@Param("gid") Integer gid);

  @Query("select game from Game game where game.developer.id =:uid")
  List<Game> findAllGamesByUser(Integer uid);

}
