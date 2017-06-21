package com.codeshaw.tracker.dto.spot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpotResponse {

  private FeedMessageResponse feedMessageResponse;

  public FeedMessageResponse getFeedMessageResponse() {
    return feedMessageResponse;
  }

  public void setFeedMessageResponse(FeedMessageResponse feedMessageResponse) {
    this.feedMessageResponse = feedMessageResponse;
  }
}
