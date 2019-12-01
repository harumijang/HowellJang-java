package com.example.videogame_java.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="games")
public class Game {

  @Id
  @GeneratedValue
      (strategy = GenerationType.IDENTITY)
  private Integer id;

  @OneToMany(mappedBy = "game")
  private List<Review> reviews;
  private Integer rating;

  @ManyToOne
  @JsonIgnore
  private Developer developer;

  public Game(Integer id) {

    this.id = id;
  }

  public Game() {}


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }

  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public Developer getDeveloper() {
    return developer;
  }

  public void setDeveloper(Developer developer) {
    this.developer = developer;
  }


}
