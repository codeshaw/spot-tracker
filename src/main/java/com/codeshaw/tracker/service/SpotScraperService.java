package com.codeshaw.tracker.service;

public interface SpotScraperService {

    /**
     * URL for the SPOT tracker message service.
     */
    String API_URL = "https://api.findmespot.com/spot-main-web/consumer/rest-api/2.0/public/feed/%s/message.json";

    void scrapeSpotService();
}
