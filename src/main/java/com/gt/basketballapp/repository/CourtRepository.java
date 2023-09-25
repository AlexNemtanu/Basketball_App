package com.gt.basketballapp.repository;

import com.gt.basketballapp.model.Court;
import com.gt.basketballapp.model.CourtType;
import com.gt.basketballapp.model.RenovationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourtRepository extends JpaRepository<Court, Long> {
    Court findByName(String name);

    @Query("select (count(c) > 0) from Court c where c.name = ?1")
    boolean existsByName(String name);

    List<Court> findByRenovationStatus(RenovationStatus renovationStatus);

    List<Court> findByCourtType(CourtType courtType);

    long countByRenovationStatus(RenovationStatus renovationStatus);

    long countByCourtType(CourtType courtType);

    @Query("select c from Court c where c.courtType = ?1")
    Optional<Court> findCourtByCourtType(CourtType courtType);

}
