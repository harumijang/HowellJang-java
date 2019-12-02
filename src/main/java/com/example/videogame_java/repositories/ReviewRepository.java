package com.example.videogame_java.repositories;

import com.example.videogame_java.models.Developer;
import com.example.videogame_java.models.Review;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository
    extends CrudRepository<Review, Integer> {
  @Query("SELECT review from Review review WHERE review.rid=:rid")
  public Review findReviewById(@Param("rid") Integer rid);

  @Query("select review from Review review")
  public List<Review> findAllReviews();

  @Query("select review from Review review where review.consumer.id =:uid")
  public List<Review> findAllReviewsByUser(@Param("uid") Integer userId);

  @Query("select review from Review review where review.game.id =:gid")
  public List<Review> findAllReviewsForGame(@Param("gid") Integer gid);


}