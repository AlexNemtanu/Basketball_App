package com.gt.basketballapp.model.dto;

import com.gt.basketballapp.model.Court;
import com.gt.basketballapp.model.CourtType;
import com.gt.basketballapp.model.RenovationStatus;
import org.springframework.data.geo.Point;

import java.io.Serializable;

/**
 * DTO for {@link Court}
 */
public record CourtDto(
        String name,
        Point coordinates,
        RenovationStatus renovationStatus,
        CourtType courtType) implements Serializable {
}