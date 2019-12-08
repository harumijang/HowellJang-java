package com.example.videogame_java.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="developers")
public class Developer implements User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String username;
  private String password;

//  @OneToMany(mappedBy = "developer")
//  private List<Game> games;

  @JsonIgnore
  @ManyToMany(mappedBy = "developers")
  private List<Game> games;

  public Developer(Integer id) {
    this.id = id;
  }

  public Developer() {
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
    return this.username;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<Game> getGames() {
    return games;
  }

  public void setGames(List<Game> games) {
    this.games = games;
  }

  public void update(Developer newDev) {
    this.password = newDev.password;
    this.username = newDev.username;
    this.games = newDev.games;
  }
}
