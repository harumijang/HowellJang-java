package com.example.videogame_java.repositories;

import com.example.videogame_java.models.Review;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository
    extends CrudRepository<Review, Integer> {
//  @Query("SELECT review from Review review WHERE review.rid=:rid")
//  public Review findMovieReviewById(@Param("rid") String rid);
}