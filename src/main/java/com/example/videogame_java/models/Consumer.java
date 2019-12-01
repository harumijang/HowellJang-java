package com.example.videogame_java.models;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="consumers")
public class Consumer implements User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String username;
  private String password;

  @OneToMany(mappedBy = "consumer")
  private List<Review> reviews;

  public Consumer() {
  }

  public Consumer(Integer id) {
    this.id = id;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }


  @Override
  public void setUsername(String username) {
    this.username = username;

  }

  @Override
  public void setPassword(String password) {
    this.password = password;

  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public String getPassword() {
    return password;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }



}
