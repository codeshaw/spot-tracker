package com.codeshaw.tracker.rest.impl;

import com.codeshaw.tracker.domain.CheckIn;
import com.codeshaw.tracker.dto.CoordinateResponse;
import com.codeshaw.tracker.mapping.impl.CheckInListToCheckInResponseMapper;
import com.codeshaw.tracker.rest.CheckInServiceRest;
import com.codeshaw.tracker.service.CheckInService;
import com.codeshaw.tracker.service.SpotScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * REST-ful implementation of {@link CheckInServiceRest}
 */
@Service
@RestController
@RequestMapping("/checkin")
public class CheckInServiceRestImpl implements CheckInServiceRest {

    /**
     * The back-end service for the {@link CheckIn} domain.
     */
    private final CheckInService checkInService;

    /**
     * The back-end service for the SPOT scraper.
     */
    private final SpotScraperService spotScraperService;

    /**
     * Mapper from the {@link CheckIn} domain to the {@link CoordinateResponse} DTO.
     */
    private CheckInListToCheckInResponseMapper mapper;

    @Autowired
    public CheckInServiceRestImpl(CheckInService checkInService, SpotScraperService spotScraperService,
                                  CheckInListToCheckInResponseMapper mapper) {
        this.checkInService = checkInService;
        this.spotScraperService = spotScraperService;
        this.mapper = mapper;
    }

    @Override
    @CrossOrigin(maxAge = 3600)
    @RequestMapping(value = "/{sharedPage}", method = RequestMethod.GET)
    public CoordinateResponse getAllCheckInsForSharedPage(@PathVariable("sharedPage") String sharedPageId) {
        return mapper.getMappedList(checkInService.getAllCheckInsForSharedPage(sharedPageId));
    }

    @Override
    @CrossOrigin(maxAge = 3600)
    @RequestMapping(value = "/{refresh}", method = RequestMethod.GET)
    public void forceRefresh() {
        spotScraperService.scrapeSpotService();
    }
}
