package com.example.videogame_java.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="reviews")
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String reviewContent;

  @ManyToOne
  @JsonIgnore
  private Game game;

  @ManyToOne
  @JsonIgnore
  private Consumer consumer;


  public Review() {
  }

  public Review(String reviewContent, Game game, Consumer consumer) {
    this.reviewContent = reviewContent;
    this.game = game;
    this.consumer = consumer;
  }

  public Review(Integer id) {
    this.id = id;
  }


  public Consumer getConsumer() {
    return consumer;
  }

  public void setConsumer(Consumer user) {
    this.consumer = consumer;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }

  public String getReviewContent() {
    return reviewContent;
  }

  public void setReviewContent(String review) {
    this.reviewContent = review;
  }


}
