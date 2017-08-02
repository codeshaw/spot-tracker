package com.codeshaw.tracker.rest;

import com.codeshaw.tracker.dto.CoordinateResponse;

/**
 * Contract definitions for the co-ordinates service.
 */
public interface CheckInServiceRest {

    /**
     * Gets a {@link CoordinateResponse}
     * @param sharedPageId
     * @return
     */
    CoordinateResponse getAllCheckInsForSharedPage(String sharedPageId);

}
