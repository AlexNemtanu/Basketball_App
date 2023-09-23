package com.gt.basketballapp.model;

import org.springframework.data.geo.Point;

import java.io.Serializable;

/**
 * DTO for {@link Court}
 */
public record CourtDto(String name, Point coordinates, RenovationStatus renovationStatus,
                       CourtType courtType) implements Serializable {
}