package com.example.videogame_java.repositories;

import com.example.videogame_java.models.Consumer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConsumerRepository extends  CrudRepository<Consumer, Integer> {



  @Query("select consumer from Consumer consumer")
  public List<Consumer> findAllConsumers();


}


