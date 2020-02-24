package com.codeshaw.tracker.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
public class Trip {

  @Id
  private UUID id;

  private String tripColour;

  private boolean active;

  @OneToMany
  private List<TripSegment> tripSegments;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getTripColour() {
    return tripColour;
  }

  public void setTripColour(String tripColour) {
    this.tripColour = tripColour;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public List<TripSegment> getTripSegments() {
    return tripSegments;
  }

  public void setTripSegments(List<TripSegment> tripSegments) {
    this.tripSegments = tripSegments;
  }
}
