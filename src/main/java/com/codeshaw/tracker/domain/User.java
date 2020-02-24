package com.codeshaw.tracker.domain;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @OneToMany
  private List<Trip> trips;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public List<Trip> getTrips() {
    return trips;
  }

  public void setTrips(List<Trip> trips) {
    this.trips = trips;
  }
}
