package com.gt.basketballapp.model;

import java.awt.geom.Point2D;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courts")
public class Court {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
    private Long id;
	private String name;
	@Enumerated(EnumType.STRING)
	private RenovationStatus renovationStatus;
	@Enumerated(EnumType.STRING)
	private CourtType courtType;
	private Point2D.Double coordinates;
}
