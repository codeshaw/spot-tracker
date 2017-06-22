package com.codeshaw.tracker.repository;

import com.codeshaw.tracker.domain.SharedPage;
import org.hamcrest.Matchers;
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
 * JPA tests for the {@link SharedPageRepository}
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class SharedPageRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SharedPageRepository repository;

    @Test
    public void testFindAll() {
        entityManager.persist(new SharedPage("Test Feed 1", "TEST_PAGE_FEED_ID_1"));
        entityManager.persist(new SharedPage("Test Feed 2", "TEST_PAGE_FEED_ID_2"));

        List<SharedPage> allSharedPages = repository.findAll();
        assertThat(allSharedPages.size(), is(2));

        List<String> sharedPageNames = allSharedPages.stream()
                .map(SharedPage::getSharedPageName)
                .collect(Collectors.toList());
        assertThat(sharedPageNames, contains("Test Feed 1", "Test Feed 2"));

        List<String> sharedPageFeedIds = allSharedPages.stream()
                .map(SharedPage::getId)
                .collect(Collectors.toList());
        assertThat(sharedPageFeedIds, contains("TEST_PAGE_FEED_ID_1", "TEST_PAGE_FEED_ID_2"));
    }

}