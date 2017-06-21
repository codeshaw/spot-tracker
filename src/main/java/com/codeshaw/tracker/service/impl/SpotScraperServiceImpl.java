package com.codeshaw.tracker.service.impl;

import com.codeshaw.tracker.domain.TestObject;
import com.codeshaw.tracker.repository.SharedPageRepository;
import com.codeshaw.tracker.service.SpotScraperService;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {@link SpotScraperService}
 */
@Service
public class SpotScraperServiceImpl implements SpotScraperService {

    private static final Logger LOG = LoggerFactory.getLogger(SpotScraperServiceImpl.class);

    private SharedPageRepository sharedPageRepository;

    @Autowired
    protected SpotScraperServiceImpl(SharedPageRepository sharedPageRepository) {
        this.sharedPageRepository = sharedPageRepository;
    }

    @Scheduled(cron = "*/10 * * * * *")
    public void scrapeSpotService() {
        LOG.info("Scraping SPOT service: {}", LocalDateTime.now().toString());

        List<TestObject> spotResponses = sharedPageRepository.findAll().stream()
                .map(sharedPage -> fetchFeedWithId(sharedPage.getSharedPageFeedId()))
                .collect(Collectors.toList());

        spotResponses.forEach(currentResponse -> LOG.debug("Found: {}", currentResponse));
    }

    private TestObject fetchFeedWithId(String sharedPageFeedId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", TestObject.class);
    }
}
