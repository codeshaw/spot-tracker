package com.codeshaw.tracker.rest;

import com.codeshaw.tracker.dto.CoordinateResponseDto;

/**
 * Contract definitions for the co-ordinates service.
 */
public interface CheckInServiceRest {

    /**
     * Gets a {@link CoordinateResponseDto}
     * @param sharedPageId
     * @return
     */
    CoordinateResponseDto getAllCheckInsForSharedPage(String sharedPageId);

    /**
     * Forces a refresh of the SPOT backend.
     */
    void forceRefresh();

}
