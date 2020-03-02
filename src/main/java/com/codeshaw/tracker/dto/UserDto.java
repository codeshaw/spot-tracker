package com.codeshaw.tracker.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

  @JsonProperty("username")
  private String username;

  @JsonProperty("password")
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserDto user = (UserDto) o;
    return
        username.equals(user.username) &&
        password.equals(user.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password);
  }
}
