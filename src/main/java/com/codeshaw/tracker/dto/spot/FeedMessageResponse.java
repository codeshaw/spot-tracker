package com.codeshaw.tracker.dto.spot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedMessageResponse {

  private Feed feed;

  private int count;
  private int totalCount;
  private int activityCount;

  private List<Message> messages;

}
