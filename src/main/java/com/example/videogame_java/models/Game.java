package com.example.videogame_java.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Arrays;
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


//  public Game(Integer id) {
//    this.id = id;
//  }

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
    if (!newGame.name.isEmpty()) {
      this.setName(newGame.name);
    }
    if (!newGame.date.isEmpty()) {
      this.setDate(newGame.date);
    }
    if (!newGame.videoURL.isEmpty()) {
      this.setVideoURL(newGame.videoURL);
    }
    if(!newGame.platforms.isEmpty()) {
      this.setPlatforms(newGame.platforms);
    }
    if(!newGame.stores.isEmpty()) {
      this.setStores(newGame.stores);
    }
    if(!newGame.imgURLs.isEmpty()) {
      this.setImgURLs(newGame.imgURLs);
    }
    if(!newGame.genres.isEmpty()) {
      this.setGenres(newGame.genres);
    }
    if(!newGame.developers.isEmpty())
    this.setDevelopers(newGame.developers);
  }


  public void updateDevs(Developer[] devs) {
    List<Developer> list = Arrays.asList(devs);
    this.developers = list;
  }
}
