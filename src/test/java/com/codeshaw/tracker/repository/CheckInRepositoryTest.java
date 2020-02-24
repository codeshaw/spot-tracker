package com.codeshaw.tracker.repository;

import com.codeshaw.tracker.domain.CheckIn;
import com.codeshaw.tracker.domain.SharedPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * JPA tests for the {@link CheckInRepository}
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CheckInRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CheckInRepository repository;

    private SharedPage sharedPage;

    /**
     * Setup methods common to all test methods
     */
    @Before
    public void setup() {
        sharedPage = new SharedPage("Fuckyou", "123");
        entityManager.persist(sharedPage);
    }

    @Test
    @Transactional
    public void testFindAll() {
        CheckIn aCheckIn = new CheckIn(LocalDateTime.now(), 12.34D, 45.67D, "Crappy test message");
        CheckIn bCheckIn = new CheckIn(LocalDateTime.now(), 23.45D, 67.89D, "Crappy test message 2");

        entityManager.persistFlushFind(aCheckIn);
        entityManager.persistFlushFind(bCheckIn);

        List<CheckIn> allSharedPages = repository.findAll();
        assertThat(allSharedPages.size(), is(2));
    }

}