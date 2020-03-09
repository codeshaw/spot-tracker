package com.codeshaw.tracker.rest.impl;

import com.codeshaw.tracker.mapping.impl.CheckInListToCheckInResponseMapper;
import com.codeshaw.tracker.rest.CheckInServiceRest;
import com.codeshaw.tracker.service.CheckInService;
import com.codeshaw.tracker.service.SpotScraperService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CheckInServiceRestImplTest {

    /**
     * Mock for the check in service
     */
    @Mock
    private CheckInService mockCheckInService;

    /**
     * Mock for the spot scraper service
     */
    @Mock
    private SpotScraperService mockSpotScraperService;

    /**
     * Mock for the check in list to check in response mapper.
     */
    @Mock
    private CheckInListToCheckInResponseMapper mapper;

    /**
     * Class under test
     */
    private CheckInServiceRestImpl service;

    @BeforeEach
    public void setup() {
        service = new CheckInServiceRestImpl(this.mockCheckInService, this.mockSpotScraperService, this.mapper);
    }

    /**
     * Test for {@link CheckInServiceRest#getAllCheckInsForSharedPage(String)}
     */
    @Test
    @Disabled("Not yet implemented")
    public void getAllCheckInsForSharedPage() {
        // Does nothing
    }

    /**
     * Test for {@link CheckInServiceRest#getAllCheckInsForSharedPage(String)}
     */
    @Test
    public void forceRefresh() throws Exception {
        service.forceRefresh();
        Mockito.verify(mockSpotScraperService).scrapeSpotService();
    }

}