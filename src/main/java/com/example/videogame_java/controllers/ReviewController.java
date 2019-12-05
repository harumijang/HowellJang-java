package com.example.videogame_java.controllers;

import com.example.videogame_java.models.Review;
import com.example.videogame_java.repositories.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
;import java.util.List;

@CrossOrigin(origins = "*")
@RestController

public class ReviewController {
   @Autowired
    ReviewRepository repository;

    @GetMapping("/api/review/{rid}")
    public Review findReviewById(
        @PathVariable("rid")
            Integer rid) {
      return repository.findReviewById(rid);
    }

    @GetMapping("/api/consumers/{uid}/reviews")
    public List<Review> findAllReviewsByUser(
        @PathVariable("uid") Integer uid) {
      return repository.findAllReviewsByUser(uid);
    }

    @GetMapping("api/games/{gid}/reviews")
    public List<Review> findAllReviewsForGame(
        @PathVariable("gid") Integer gid) {
      return repository.findAllReviewsForGame(gid);
    }


    @GetMapping("/api/reviews")
    public List<Review> findAllReviews() {
      return repository.findAllReviews();
    }

    @PostMapping("/api/reviews")
    public List<Review> createReview(
        @RequestBody Review review) {
      repository.save(review);
      return repository.findAllReviews();
    }

    @DeleteMapping("/api/reviews/{rid}")
    public List<Review> deleteReview(@PathVariable("rid") Integer rid) {
      repository.delete(this.findReviewById(rid));
      return repository.findAllReviews();
    }
  }

