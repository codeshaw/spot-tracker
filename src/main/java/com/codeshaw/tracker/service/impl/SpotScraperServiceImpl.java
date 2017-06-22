package com.codeshaw.tracker.service.impl;

import com.codeshaw.tracker.dto.spot.SpotResponse;
import com.codeshaw.tracker.mapping.impl.SpotResponseToCheckInMapper;
import com.codeshaw.tracker.repository.CheckInRepository;
import com.codeshaw.tracker.repository.SharedPageRepository;
import com.codeshaw.tracker.service.SpotScraperService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

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

    @Scheduled(cron = "*/10 * * * * *")
    public void scrapeSpotService() {
        LOG.info("Scraping SPOT service: {}", LocalDateTime.now().toString());

        List<SpotResponse> spotResponses = sharedPageRepository.findAll().stream()
                .map(sharedPage -> fetchFeedWithId(sharedPage.getId()))
                .collect(Collectors.toList());

        spotResponses.forEach(currentResponse -> LOG.debug("Found: {}", currentResponse));

        spotResponses.stream()
            .map(mapper::getMappedList)
            .forEach(current -> checkInRepository.save(current));}

    /**
     * Performs the REST request that gets the SPOT response and turns it into s {@link SpotResponse} instance
     * @param sharedPageFeedId The shared feed ID
     * @return The SPOT messages as DTO
     */
//    private SpotResponse fetchFeedWithId(String sharedPageFeedId) {
//        return new RestTemplate().getForObject(String.format(API_URL, sharedPageFeedId), SpotResponse.class);
//    }

    /**
     * Crap test method for the file system.
     * @param sharedPageFeedId
     * @return
     */
    @Autowired private ObjectMapper objectMapper;
    private SpotResponse fetchFeedWithId(String sharedPageFeedId) {
        try {
            return objectMapper.readValue(new URL("classpath:response.json"), SpotResponse.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
