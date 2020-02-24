package com.codeshaw.tracker.domain;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class TripSegment {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  private String segmentStyle;

  @OneToMany
  private List<CheckIn> checkIns;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getSegmentStyle() {
    return segmentStyle;
  }

  public void setSegmentStyle(String segmentStyle) {
    this.segmentStyle = segmentStyle;
  }

  public List<CheckIn> getCheckIns() {
    return checkIns;
  }

  public void setCheckIns(List<CheckIn> checkIns) {
    this.checkIns = checkIns;
  }

}
