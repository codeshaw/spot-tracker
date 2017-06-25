package com.codeshaw.tracker.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CoordinateResponse {

    @JsonProperty("coordinates")
    private List<Coordinate> coordinates;

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CoordinateResponse that = (CoordinateResponse) o;

        return new EqualsBuilder()
                .append(coordinates, that.coordinates)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(coordinates)
                .toHashCode();
    }
}
