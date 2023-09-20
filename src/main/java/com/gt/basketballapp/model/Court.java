package com.gt.basketballapp.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.geo.Point;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courts")
public class Court {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String name;
	@Enumerated(EnumType.STRING)
	private RenovationStatus renovationStatus;
	@Enumerated(EnumType.STRING)
	private CourtType courtType;
	private Point coordinates;
}
