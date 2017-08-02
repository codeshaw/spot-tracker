package com.codeshaw.tracker.repository;

import com.codeshaw.tracker.domain.CheckIn;
import org.joda.time.LocalDateTime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for the {@link CheckIn} domain.
 */
@Repository
public interface CheckInRepository extends CrudRepository<CheckIn, LocalDateTime> {

    List<CheckIn> findAll();

    List<CheckIn> findBySharedPageIdAndVisibleTrueOrderByCheckInTimeAsc(String sharedPageId);
}
