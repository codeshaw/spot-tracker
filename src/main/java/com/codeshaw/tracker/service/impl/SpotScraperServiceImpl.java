package com.codeshaw.tracker.service.impl;

import com.codeshaw.tracker.dto.spot.Response;
import com.codeshaw.tracker.dto.spot.SpotResponse;
import com.codeshaw.tracker.mapping.impl.SpotResponseToCheckInMapper;
import com.codeshaw.tracker.repository.CheckInRepository;
import com.codeshaw.tracker.repository.SharedPageRepository;
import com.codeshaw.tracker.service.SpotScraperService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {@link SpotScraperService}
 */
@Service
public class SpotScraperServiceImpl implements SpotScraperService {

    private static final Logger LOG = LoggerFactory.getLogger(SpotScraperServiceImpl.class);

    /**
     *
     */
    private SharedPageRepository sharedPageRepository;

    private CheckInRepository checkInRepository;

    /**
     *
     */
    private final SpotResponseToCheckInMapper mapper;

    @Autowired
    protected SpotScraperServiceImpl(SharedPageRepository sharedPageRepository, CheckInRepository checkInRepository,
                                     SpotResponseToCheckInMapper mapper) {
        this.sharedPageRepository = sharedPageRepository;
        this.checkInRepository = checkInRepository;
        this.mapper = mapper;
    }

    /**
     * Initialisation method.
     */
    @PostConstruct
    public void init() {
        scrapeSpotService();
    }

    @Scheduled(cron = "0 0 */12 * * *")
    public void scrapeSpotService() {
        LOG.info("Scraping SPOT service: {}", LocalDateTime.now().toString());

        List<SpotResponse> spotResponses = sharedPageRepository.findAll().stream()
                .map(sharedPage -> fetchFeedWithId(sharedPage.getId()))
                .collect(Collectors.toList());

        spotResponses.forEach(currentResponse -> LOG.debug("Found: {}", currentResponse));

        spotResponses.stream()
            .map(mapper::getMappedList)
            .forEach(current -> checkInRepository.save(current));
    }

    /**
     * Performs the REST request that gets the SPOT response and turns it into s {@link SpotResponse} instance
     * @param sharedPageFeedId The shared feed ID
     * @return The SPOT messages as DTO
     */
    private SpotResponse fetchFeedWithId(String sharedPageFeedId) {
        // Spot's API is crap. If there's only one element it returns one element, not an array
        // And I don't have the time to work out how to mitigate it. Busy busy busy.
        try {
            return new RestTemplate().getForObject(String.format(API_URL, sharedPageFeedId), SpotResponse.class);
        } catch (HttpMessageNotReadableException e) {
            SpotResponse spotResponse = new SpotResponse();
            spotResponse.setResponse(new Response());
            return spotResponse;
        }
    }

}
