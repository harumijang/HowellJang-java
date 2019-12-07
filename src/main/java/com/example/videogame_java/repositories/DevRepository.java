package com.example.videogame_java.repositories;

import com.example.videogame_java.models.Developer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DevRepository extends  CrudRepository<Developer, Integer> {



  @Query("select developer from Developer developer")
    public List<Developer> findAllDevs();

  @Query("select developer from Developer developer where developer.id=:developerId")
  public Developer findDeveloperById(@Param("developerId") Integer id);

  @Query(
      "select d FROM Developer d JOIN d.games g WHERE g.id = :gameID"
  )
  public List<Developer> findAllDevsByGame(@Param("gameID") Integer gameID);


}


