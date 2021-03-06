package com.codeshaw.tracker.repository;

import com.codeshaw.tracker.domain.SharedPage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for the {@link SharedPage} domain.
 */
@Repository
public interface SharedPageRepository extends CrudRepository<SharedPage, String> {

    List<SharedPage> findAll();
}
