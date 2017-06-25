package com.codeshaw.tracker.service;

import com.codeshaw.tracker.domain.CheckIn;

import java.util.List;

/**
 * Defines REST methods for pulling {Ch}
 */
public interface CheckInService {

    List<CheckIn> getAllCheckInsForSharedPage(String sharedPageId);
}
