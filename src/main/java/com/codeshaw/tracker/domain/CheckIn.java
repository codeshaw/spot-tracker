package com.codeshaw.tracker.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(indexes = @Index(name = "IDX_SHARED_PAGE_ID",  columnList="SHARED_PAGE_ID"))
public class CheckIn {

  @Id
  @Column
  @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
  private LocalDateTime checkInTime;

  @Version
  private int version;

  @Column(updatable = false)
  private boolean visible = true;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "SHARED_PAGE_ID", foreignKey = @ForeignKey(name = "FK_SHARED_PAGE_CHECK_IN"))
  private SharedPage sharedPage;

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
        .append(sharedPage, checkIn.sharedPage)
        .append(checkInTime, checkIn.checkInTime)
        .append(messageText, checkIn.messageText)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(sharedPage)
        .append(checkInTime)
        .append(latitude)
        .append(longitude)
        .append(messageText)
        .toHashCode();
  }
}
