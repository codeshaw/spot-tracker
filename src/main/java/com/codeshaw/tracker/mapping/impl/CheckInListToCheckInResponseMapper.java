package com.codeshaw.tracker.mapping.impl;

import com.codeshaw.tracker.domain.CheckIn;
import com.codeshaw.tracker.dto.CoordinateResponseDto;
import com.codeshaw.tracker.dto.CoordinateDto;
import com.codeshaw.tracker.mapping.ManyToOneMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {@link ManyToOneMapper} that turns a list of {@link CheckIn} entities to a single
 * {@link CoordinateResponseDto}.
 */
@Component
public class CheckInListToCheckInResponseMapper implements ManyToOneMapper<CoordinateResponseDto, CheckIn> {

    @Override
    public CoordinateResponseDto getMappedList(List<CheckIn> entities) {
        CoordinateResponseDto coordinateResponse = new CoordinateResponseDto();

        coordinateResponse.setCoordinates(entities.stream()
                .map(this::map).collect(Collectors.toList()));

        return coordinateResponse;
    }

    /**^
     * Maps a {@link CheckIn} to a {@link CoordinateDto}
     *
     * @param checkIn The {@link CheckIn} to map.
     * @return The mapped {@link CoordinateDto}
     */
    private CoordinateDto map(CheckIn checkIn) {
        return new CoordinateDto(checkIn.getLatitude(), checkIn.getLongitude());
    }
}
