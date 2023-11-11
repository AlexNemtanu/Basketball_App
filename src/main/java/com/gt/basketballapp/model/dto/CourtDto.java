package com.gt.basketballapp.model.dto;

import com.gt.basketballapp.model.Coordinates;
import com.gt.basketballapp.model.Court;
import com.gt.basketballapp.model.RenovationStatus;

/**
 * DTO for {@link Court}
 */
public record CourtDto(
        String name,
        Coordinates coordinates,
        RenovationStatus renovationStatus,
        String courtType) {
}