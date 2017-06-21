package com.codeshaw.tracker.repository;

import com.codeshaw.tracker.domain.CheckIn;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Repository for the {@link CheckIn} domain.
 */
@Repository
public interface CheckInRepository extends CrudRepository<CheckIn, UUID> {

    List<CheckIn> findAll();
}
