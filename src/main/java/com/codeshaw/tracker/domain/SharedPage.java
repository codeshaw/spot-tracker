package com.codeshaw.tracker.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SharedPage {

    @Id
    @Column(length = 100)
    private String id;

    @Column(length = 100)
    private String sharedPageName;

    protected SharedPage() {
    }

    public SharedPage(String id, String sharedPageName ) {
        this.sharedPageName = sharedPageName;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSharedPageName() {
        return sharedPageName;
    }

    public void setSharedPageName(String sharedPageName) {
        this.sharedPageName = sharedPageName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SharedPage that = (SharedPage) o;

        return new EqualsBuilder()
            .append(id, that.id)
            .append(sharedPageName, that.sharedPageName)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(id)
            .append(sharedPageName)
            .toHashCode();
    }
}
