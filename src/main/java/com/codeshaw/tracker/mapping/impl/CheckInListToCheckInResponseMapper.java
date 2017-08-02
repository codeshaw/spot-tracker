package com.codeshaw.tracker.mapping.impl;

import com.codeshaw.tracker.domain.CheckIn;
import com.codeshaw.tracker.dto.CoordinateResponse;
import com.codeshaw.tracker.dto.Coordinate;
import com.codeshaw.tracker.mapping.ManyToOneMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {@link ManyToOneMapper} that turns a list of {@link CheckIn} entities to a single
 * {@link CoordinateResponse}.
 */
@Component
public class CheckInListToCheckInResponseMapper implements ManyToOneMapper<CoordinateResponse, CheckIn> {

    @Override
    public CoordinateResponse getMappedList(List<CheckIn> entities) {
        CoordinateResponse coordinateResponse = new CoordinateResponse();

        coordinateResponse.setCoordinates(entities.stream()
                .map(this::map).collect(Collectors.toList()));

        return coordinateResponse;
    }

    /**^
     * Maps a {@link CheckIn} to a {@link Coordinate}
     *
     * @param checkIn The {@link CheckIn} to map.
     * @return The mapped {@link Coordinate}
     */
    private Coordinate map(CheckIn checkIn) {
        return new Coordinate(checkIn.getLatitude(), checkIn.getLongitude());
    }
}
