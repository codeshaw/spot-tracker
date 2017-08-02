package com.codeshaw.tracker.mapping.impl;

import com.codeshaw.tracker.domain.CheckIn;
import com.codeshaw.tracker.domain.SharedPage;
import com.codeshaw.tracker.dto.spot.Response;
import com.codeshaw.tracker.dto.spot.SpotResponse;
import com.codeshaw.tracker.mapping.OneToManyMapper;
import com.codeshaw.tracker.repository.SharedPageRepository;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SpotResponseToCheckInMapper implements OneToManyMapper<SpotResponse, CheckIn> {

  @Autowired
  private SharedPageRepository sharedPageRepository;

  @Override
  public List<CheckIn> getMappedList(SpotResponse dto) {
    Response response = dto.getResponse();
    if (response.getFeedMessageResponse() == null) {
      return new ArrayList<>();
    }

    String sharedFeedId = response.getFeedMessageResponse().getFeed().getId();
    SharedPage sharedPage = sharedPageRepository.findOne(sharedFeedId);

    return dto.getResponse().getFeedMessageResponse().getMessages().getMessage().stream()
        .map(currentMessage -> {
          CheckIn checkIn = new CheckIn();
          checkIn.setSharedPage(sharedPage);
          checkIn.setCheckInTime(new LocalDateTime(currentMessage.getUnixTime() * 1000, DateTimeZone.UTC));
          checkIn.setLatitude(currentMessage.getLatitude());
          checkIn.setLongitude(currentMessage.getLongitude());
          checkIn.setMessageText(currentMessage.getMessageContent());
          return checkIn;
        }).collect(Collectors.toList());
  }
}
