package com.codeshaw.tracker.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class SharedPage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Version
    private int version;

    @Column(length = 100)
    private String sharedPageName;

    @Column(length = 35)
    private String sharedPageFeedId;

    @SuppressWarnings("unused")
    protected SharedPage() {
    }

    public SharedPage(String sharedPageName, String sharedPageFeedId) {
        this.sharedPageName = sharedPageName;
        this.sharedPageFeedId = sharedPageFeedId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getSharedPageName() {
        return sharedPageName;
    }

    public void setSharedPageName(String sharedPageName) {
        this.sharedPageName = sharedPageName;
    }

    public String getSharedPageFeedId() {
        return sharedPageFeedId;
    }

    public void setSharedPageFeedId(String sharedPageFeedId) {
        this.sharedPageFeedId = sharedPageFeedId;
    }
}
