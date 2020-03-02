package com.codeshaw.tracker.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class CheckIn {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Version
  private int version;

  @Column(updatable = false)
  private boolean visible = true;

  @Column
  private LocalDateTime checkInTime;

  private double latitude;

  private double longitude;

  private String messageText;

  /**
   * Protected-access no-arg constructor.
   */
  public CheckIn() {
  }

  /**
   * Public constructor.
   *
   * @param checkInTime The time of the check-in event
   * @param latitude Latitude of the check-in event
   * @param longitude Longitude of the check-in event
   * @param messageText The message text associated with the check-in event.
   */
  public CheckIn(LocalDateTime checkInTime, double latitude, double longitude, String messageText) {
    this.checkInTime = checkInTime;
    this.latitude = latitude;
    this.longitude = longitude;
    this.messageText = messageText;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

  public LocalDateTime getCheckInTime() {
    return checkInTime;
  }

  public void setCheckInTime(LocalDateTime checkInTime) {
    this.checkInTime = checkInTime;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public String getMessageText() {
    return messageText;
  }

  public void setMessageText(String messageText) {
    this.messageText = messageText;
  }

  public boolean isVisible() {
    return visible;
  }

  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    CheckIn checkIn = (CheckIn) o;

    return new EqualsBuilder()
        .append(latitude, checkIn.latitude)
        .append(longitude, checkIn.longitude)
        .append(checkInTime, checkIn.checkInTime)
        .append(messageText, checkIn.messageText)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(checkInTime)
        .append(latitude)
        .append(longitude)
        .append(messageText)
        .toHashCode();
  }
}
