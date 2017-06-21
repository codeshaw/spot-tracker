package com.codeshaw.tracker.domain;

import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class CheckIn {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Version
  private int version;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "SHARED_PAGE_ID")
  private SharedPage sharedPage;

  private LocalDateTime checkInTime;

  private double latitude;

  private double longitude;

  private String messageText;

  /**
   * Protected-access no-arg constructor.
   */
  @SuppressWarnings("unused")
  protected CheckIn() {
  }

  /**
   * Public constructor.
   *
   * @param sharedPage The shared page associated with the spot device
   * @param checkInTime The time of the check-in event
   * @param latitude Latitude of the check-in event
   * @param longitude Longitude of the check-in event
   * @param messageText The message text associated with the check-in event.
   */
  public CheckIn(SharedPage sharedPage, LocalDateTime checkInTime,
                 double latitude, double longitude, String messageText) {
    this.sharedPage = sharedPage;
    this.checkInTime = checkInTime;
    this.latitude = latitude;
    this.longitude = longitude;
    this.messageText = messageText;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

  public SharedPage getSharedPage() {
    return sharedPage;
  }

  public void setSharedPage(SharedPage sharedPage) {
    this.sharedPage = sharedPage;
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
}
