package com.example.videogame_java.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="games")
public class Game {

  @Id
  @GeneratedValue
      (strategy = GenerationType.IDENTITY)
  private Integer id;
  private String title;

  @OneToMany(mappedBy = "game")
  private List<Review> reviews;

  @ManyToOne
  @JsonIgnore
  private Developer developer;

  private Integer rating;
  private Date date;
//  private List<Developer> otherDevs;
  private String videoURL;
  @Column
  @ElementCollection(targetClass=String.class)
  private List<String> platforms;
  @Column
  @ElementCollection(targetClass=String.class)
  private List<String> stores;
  @Column
  @ElementCollection(targetClass=String.class)
  private List<String> imgURLs;



  public Game(Integer id) {
    this.id = id;
  }

  public Game() {}

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

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

  public Date getDate() {
    return date;
  }

  public void setDate(Date newDate) {
    this.date = date;
  }

//  public List<Developer> getOtherDevs() {
//    return otherDevs;
//  }
//
//  public void setOtherDevs(List<Developer> otherDevs) {
//    this.otherDevs = otherDevs;
//  }

  public String getVideoURL() {
    return videoURL;
  }

  public void setVideoURL(String videoURL) {
    this.videoURL = videoURL;
  }

  public List<String> getPlatforms() {
    return platforms;
  }

  public void setPlatforms(List<String> platforms) {
    this.platforms = platforms;
  }

  public List<String> getStores() {
    return stores;
  }

  public void setStores(List<String> stores) {
    this.stores = stores;
  }

  public void update(Game newGame) {
    this.setTitle(newGame.title);
    this.setDate(newGame.date);
    this.setImgURLs(newGame.imgURLs);
//    this.setOtherDevs(newGame.otherDevs);
    this.setVideoURL(newGame.videoURL);
    this.setPlatforms(newGame.platforms);
    this.setStores(newGame.stores);

  }

  public List<String> getImgURLs() {
    return imgURLs;
  }

  public void setImgURLs(List<String> imgURLs) {
    this.imgURLs = imgURLs;

  }


}
