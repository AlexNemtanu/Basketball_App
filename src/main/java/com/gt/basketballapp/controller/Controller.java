package com.gt.basketballapp.controller;

import com.gt.basketballapp.model.CourtType;
import com.gt.basketballapp.model.RenovationStatus;
import com.gt.basketballapp.model.dto.CourtDto;
import com.gt.basketballapp.service.CourtService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/courts")
public class Controller {

    private final CourtService courtService;

    @PostMapping
    public ResponseEntity<Void> createCourt(@RequestBody CourtDto courtDto) {
        courtService.save(courtDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<CourtDto>> getAllCourts() {
        List<CourtDto> courts = courtService.findAll();
        return ResponseEntity.ok(courts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourtDto> getCourtById(@PathVariable Long id) {
        CourtDto courtDto = courtService.findById(id);
        return ResponseEntity.ok(courtDto);
    }

    @GetMapping("/by-name")
    public ResponseEntity<CourtDto> findByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(courtService.findByName(name));
    }

    @GetMapping("/renovation-status/{renovationStatus}")
    public ResponseEntity<List<CourtDto>> findByRenovationStatus(@PathVariable RenovationStatus renovationStatus) {
        return ResponseEntity.ok(courtService.findByRenovationStatus(renovationStatus));
    }

    @GetMapping("/court-type/{courtType}")
    public ResponseEntity<List<CourtDto>> findByCourtType(@PathVariable CourtType courtType) {
        return ResponseEntity.ok(courtService.findByCourtType(courtType));
    }

    @GetMapping("/count-by-renovation-status")
    public ResponseEntity<Long> countByRenovationStatus(@RequestParam("renovationStatus") RenovationStatus renovationStatus) {
        return ResponseEntity.ok(courtService.countByRenovationStatus(renovationStatus));
    }

    @GetMapping("/count-by-court-type")
    public ResponseEntity<Long> countByCourtType(@RequestParam("courtType") CourtType courtType) {
        return ResponseEntity.ok(courtService.countByCourtType(courtType));
    }

    @GetMapping("/exists-by-name")
    public ResponseEntity<Boolean> existsByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(courtService.existsByName(name));
    }
}
