package com.codeshaw.tracker.dto.spot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

  @JsonProperty("feedMessageResponse")
  private FeedMessageResponse feedMessageResponse;

  public FeedMessageResponse getFeedMessageResponse() {
    return feedMessageResponse;
  }

  public void setFeedMessageResponse(FeedMessageResponse feedMessageResponse) {
    this.feedMessageResponse = feedMessageResponse;
  }
}
