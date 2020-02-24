package com.codeshaw.tracker.service.impl;

import com.codeshaw.tracker.domain.CheckIn;
import com.codeshaw.tracker.repository.CheckInRepository;
import com.codeshaw.tracker.repository.SharedPageRepository;
import com.codeshaw.tracker.rest.exception.NotFoundException;
import com.codeshaw.tracker.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CheckInServiceImpl implements CheckInService {

    private SharedPageRepository sharedPageRepository;
    private CheckInRepository checkInRepository;

    @Autowired
    public CheckInServiceImpl(CheckInRepository checkInRepository, SharedPageRepository sharedPageRepository) {
        this.checkInRepository = checkInRepository;
        this.sharedPageRepository = sharedPageRepository;
    }

    @Override
    public List<CheckIn> getAllCheckInsForSharedPage(String sharedPageId) {
//        if (!sharedPageRepository.exists(sharedPageId)) {
//            throw new NotFoundException("Not Found");
//        }
//        return checkInRepository.findBySharedPageIdAndVisibleTrueOrderByCheckInTimeAsc(sharedPageId);
        return Collections.emptyList();
    }
}
