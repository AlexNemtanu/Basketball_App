package com.gt.basketballapp.model;

import java.awt.geom.Point2D;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Court {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    protected String name;
    protected Point2D.Double coordinates;

    @Enumerated(EnumType.STRING)
    protected RenovationStatus renovationStatus;

    @Enumerated(EnumType.STRING)
    protected CourtType courtType;

    protected enum RenovationStatus{
        RENOVATED,
        UNDER_RENOVATION,
        NOT_REVOVATED;
    }
    protected enum CourtType{
        INDOOR,
        OUTDOOR;
    }
}

