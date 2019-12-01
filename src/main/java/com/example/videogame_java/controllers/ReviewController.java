package com.example.videogame_java.controllers;

import com.example.videogame_java.models.Review;
import com.example.videogame_java.repositories.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
;

public class ReviewController {

  @RestController
  @CrossOrigin(origins = "*")
  public class MovieReviewController {
    @Autowired
    ReviewRepository repository;

//    @GetMapping("/api/review/{rid}")
//    public Review findMovieReviewById(
//        @PathVariable("rid")
//            String rid) {
//      return repository.findMovieReviewById(rid);
//    }

    @PostMapping("/api/reviews")
    public Review createMovieReview(
        @RequestBody Review review) {
      return repository.save(review);
    }
  }
}
