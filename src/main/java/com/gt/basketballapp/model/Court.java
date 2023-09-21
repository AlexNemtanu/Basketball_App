package com.gt.basketballapp.model;

import org.springframework.data.geo.Point;

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
    private Long id;

    private String name;
    private Point coordinates;
    @Enumerated(EnumType.STRING)
    private RenovationStatus renovationStatus;
    @Enumerated(EnumType.STRING)
    private CourtType courtType;

}

