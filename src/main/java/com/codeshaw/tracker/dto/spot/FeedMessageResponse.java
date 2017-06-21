package com.codeshaw.tracker.dto.spot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedMessageResponse {

  @JsonProperty("feed")
  private Feed feed;

  private int count;
  private int totalCount;
  private int activityCount;

  private Messages messages;

  public Feed getFeed() {
    return feed;
  }

  public void setFeed(Feed feed) {
    this.feed = feed;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
  }

  public int getActivityCount() {
    return activityCount;
  }

  public void setActivityCount(int activityCount) {
    this.activityCount = activityCount;
  }

  public Messages getMessages() {
    return messages;
  }

  public void setMessages(Messages messages) {
    this.messages = messages;
  }
}
