package com.codeshaw.tracker.repository;

import com.codeshaw.tracker.domain.CheckIn;
import com.codeshaw.tracker.domain.SharedPage;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;

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

    @Test
    public void testFindAll() {
        SharedPage whatever = new SharedPage("Fuckyou", "123");
        new CheckIn(whatever, LocalDateTime.now(), 12.34D, 45.67D, "Crappy test message");
        entityManager.persist(whatever);

        List<CheckIn> allSharedPages = repository.findAll();
        assertThat(allSharedPages.size(), is(2));
    }

}