package com.codeshaw.tracker.dto.spot;

import com.codeshaw.tracker.dto.spot.Feed;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by Brad_TR on 21/06/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedMessageResponse {

  private int count;

  private Feed feed;

  private int totalCount;

  private int activityCount;

  private List<Message> messages;

}
