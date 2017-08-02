package com.codeshaw.tracker.dto.spot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

  private long id;

  private String messengerId;

  private String messengerName;

  private long unixTime;

  private MessageType messageType;

  private double latitude;
  private double longitude;

  private String modelId;

  private String showCustomMsg;

  private String dateTime;

  private String hidden;

  private String messageContent;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getMessengerId() {
    return messengerId;
  }

  public void setMessengerId(String messengerId) {
    this.messengerId = messengerId;
  }

  public String getMessengerName() {
    return messengerName;
  }

  public void setMessengerName(String messengerName) {
    this.messengerName = messengerName;
  }

  public long getUnixTime() {
    return unixTime;
  }

  public void setUnixTime(long unixTime) {
    this.unixTime = unixTime;
  }

  public MessageType getMessageType() {
    return messageType;
  }

  public void setMessageType(MessageType messageType) {
    this.messageType = messageType;
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

  public String getModelId() {
    return modelId;
  }

  public void setModelId(String modelId) {
    this.modelId = modelId;
  }

  public String getShowCustomMsg() {
    return showCustomMsg;
  }

  public void setShowCustomMsg(String showCustomMsg) {
    this.showCustomMsg = showCustomMsg;
  }

  public String getDateTime() {
    return dateTime;
  }

  public void setDateTime(String dateTime) {
    this.dateTime = dateTime;
  }

  public String getHidden() {
    return hidden;
  }

  public void setHidden(String hidden) {
    this.hidden = hidden;
  }

  public String getMessageContent() {
    return messageContent;
  }

  public void setMessageContent(String messageContent) {
    this.messageContent = messageContent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    Message message = (Message) o;

    return new EqualsBuilder()
        .append(id, message.id)
        .append(unixTime, message.unixTime)
        .append(latitude, message.latitude)
        .append(longitude, message.longitude)
        .append(messengerId, message.messengerId)
        .append(messengerName, message.messengerName)
        .append(messageType, message.messageType)
        .append(modelId, message.modelId)
        .append(showCustomMsg, message.showCustomMsg)
        .append(dateTime, message.dateTime)
        .append(hidden, message.hidden)
        .append(messageContent, message.messageContent)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(id)
        .append(messengerId)
        .append(messengerName)
        .append(unixTime)
        .append(messageType)
        .append(latitude)
        .append(longitude)
        .append(modelId)
        .append(showCustomMsg)
        .append(dateTime)
        .append(hidden)
        .append(messageContent)
        .toHashCode();
  }
}
