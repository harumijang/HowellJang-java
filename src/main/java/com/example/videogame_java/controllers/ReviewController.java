package com.example.videogame_java.controllers;


import com.example.videogame_java.models.Review;
import com.example.videogame_java.repositories.ConsumerRepository;
import com.example.videogame_java.repositories.GameRepository;
import com.example.videogame_java.repositories.ReviewRepository;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
;import java.util.List;


@CrossOrigin(origins = "*")
@RestController

public class ReviewController {
  @Autowired
  ReviewRepository repository;
  @Autowired
  GameRepository gameRepo;
  @Autowired
  ConsumerRepository conRepo;


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

  @DeleteMapping("/api/reviews/{rid}")
  public List<Review> deleteReview(@PathVariable("rid") Integer rid) {
    repository.delete(this.findReviewById(rid));
    return repository.findAllReviews();
  }

  @PutMapping("api/reviews/{rid}")
  public void updateReview(@PathVariable("rid") Integer id,
                           @RequestBody Review newReview) {
    Review review = repository.findReviewById(id);
    review.update(newReview);
    repository.save(review);
  }

  //    @PostMapping("/api/reviews?consumer=x&gamer=y")
//  @PostMapping("/api/reviews/{gid}")
////  public List<Review> createReview(
////      @RequestBody Review review) {
////    System.out.println("this is review: " + review.getReviewContent()+review.getGame().getName()+review.getConsumer().getUsername());
////    repository.save(review);
////    return repository.findAllReviews();
////  }

  @PostMapping("/api/games/{gid}/reviews")
  public List<Review> createReview(
      @RequestBody String content) throws JSONException {
    JSONObject jsonObj = new JSONObject(content);
    String reviewString = jsonObj.getString("content");
    Integer reviewGID = jsonObj.getInt("gid");
    Integer reviewUID = jsonObj.getInt("uid");
    System.out.println(reviewString + " " + reviewGID + " " + reviewUID);
    Review newReview = new Review();
    newReview.setReviewContent(reviewString);
    newReview.setGame(gameRepo.findGameById(reviewGID));
    newReview.setConsumer(conRepo.findConsumerById(reviewUID));
    System.out.println("consumer: " + newReview.getConsumer().getUsername());
    repository.save(newReview);
    return repository.findAllReviews();
  }


}

