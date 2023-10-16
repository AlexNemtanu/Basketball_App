package com.gt.basketballapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Court {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Coordinates coordinates;

    @Enumerated(EnumType.STRING)
    private RenovationStatus renovationStatus;

    @Enumerated(EnumType.STRING)
    private CourtType courtType;
}

