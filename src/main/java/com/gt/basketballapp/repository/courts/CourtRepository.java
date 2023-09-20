package com.gt.basketballapp.repository.courts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourtRepository extends JpaRepository<Court, Long> {
	Court findCourtByName(String name);
	Court findCourtById(Long id);
}
