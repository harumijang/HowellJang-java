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
  private String name;

  @OneToMany(mappedBy = "game")
  private List<Review> reviews;

//  @ManyToOne
//  @JsonIgnore
//  private Developer developer;


  @ManyToMany(mappedBy = "games")
  List<Developer> developers;

  private String date;
// private List<Developer> otherDevs;
  private String videoURL;
  private String platforms;
  private String stores;
  private String imgURLs;


  public Game(Integer id) {
    this.id = id;
  }

  public Game() {}


  public String getGenres() {
    return genres;
  }

  public void setGenres(String genres) {
    this.genres = genres;
  }

  private String genres;

  public String getPlatforms() {
    return platforms;
  }

  public void setPlatforms(String platforms) {
    this.platforms = platforms;
  }

  public String getStores() {
    return stores;
  }

  public void setStores(String stores) {
    this.stores = stores;
  }

  public String getImgURLs() {
    return imgURLs;
  }

  public void setImgURLs(String imgURLs) {
    this.imgURLs = imgURLs;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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


  public List<Developer> getDevelopers() {
    return developers;
  }

  public void setDevelopers(List<Developer> developer) {
    this.developers = developers;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String newDate) {
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


  public void update(Game newGame) {
    this.setName(newGame.name);
    this.setDate(newGame.date);
    this.setVideoURL(newGame.videoURL);
    this.setPlatforms(newGame.platforms);
    this.setStores(newGame.stores);
    this.setImgURLs(newGame.imgURLs);
    this.setGenres(newGame.genres);
    this.setDevelopers(newGame.developers);

  }


}
