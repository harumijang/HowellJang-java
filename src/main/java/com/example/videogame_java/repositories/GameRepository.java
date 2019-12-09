package com.example.videogame_java.repositories;

import com.example.videogame_java.models.Game;
import com.example.videogame_java.models.Review;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static org.hibernate.sql.ast.Clause.WHERE;

public interface GameRepository extends CrudRepository<Game, Integer> {
  @Query("select game from Game game")
  public List<Game> findAllGames();

  @Query("select game from Game game where game.id =:gid")
  public Game findGameById(@Param("gid") Integer gid);

//  @Query("select game from Game game where game.developer.id =:uid")
//  List<Game> findAllGamesByUser(Integer uid);

  @Query("select g FROM Game g JOIN g.developers d WHERE d.id = :devID")
      public List<Game> findAllGamesByUser(@Param("devID") Integer devID);

  @Query("SELECT COUNT (id) FROM Game Where id = :gid")
  public Integer howManyRecords(@Param("gid") Integer gid);


}
