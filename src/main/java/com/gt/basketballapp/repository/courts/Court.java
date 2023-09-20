package com.gt.basketballapp.repository.courts;

import java.awt.geom.Point2D;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Court {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
	protected String name;
	@Enumerated(EnumType.STRING)
	protected RenovationStatus renovation_status;
	@Enumerated(EnumType.STRING)
	protected CourtType court_type;
	protected Point2D.Double coordinates;
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
