package com.marcelloventurini.springmongodb.dto;

import com.marcelloventurini.springmongodb.entities.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {
  private String id;
  private String name;

  public AuthorDTO() {
  }

  public AuthorDTO(User user) {
    id = user.getId();
    name = user.getName();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}