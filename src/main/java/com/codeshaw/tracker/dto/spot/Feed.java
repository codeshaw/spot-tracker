package com.codeshaw.tracker.dto.spot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Feed {

  private String id;

  private String name;
  private String description;

  private String status;

  private int usage;
  private int daysRange;

  private boolean detailedMessageShown;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public int getUsage() {
    return usage;
  }

  public void setUsage(int usage) {
    this.usage = usage;
  }

  public int getDaysRange() {
    return daysRange;
  }

  public void setDaysRange(int daysRange) {
    this.daysRange = daysRange;
  }

  public boolean isDetailedMessageShown() {
    return detailedMessageShown;
  }

  public void setDetailedMessageShown(boolean detailedMessageShown) {
    this.detailedMessageShown = detailedMessageShown;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    Feed feed = (Feed) o;

    return new EqualsBuilder()
        .append(usage, feed.usage)
        .append(daysRange, feed.daysRange)
        .append(detailedMessageShown, feed.detailedMessageShown)
        .append(id, feed.id)
        .append(name, feed.name)
        .append(description, feed.description)
        .append(status, feed.status)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(id)
        .append(name)
        .append(description)
        .append(status)
        .append(usage)
        .append(daysRange)
        .append(detailedMessageShown)
        .toHashCode();
  }
}
