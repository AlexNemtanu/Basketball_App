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

@RestController
@RequestMapping("api/v1/courts")
@AllArgsConstructor
public class CourtController {

    private final CourtService courtService;

    @PostMapping
    public ResponseEntity<CourtDto> createCourt(@RequestBody CourtDto courtDto){
        courtService.save(courtDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(courtDto);
    }
    @GetMapping("/{id}")
    public CourtDto getCourtById(@PathVariable Long id) {
        return courtService.findById(id);
    }

    @GetMapping
    public List<CourtDto> getAllCourts() {
        return courtService.findAll();
    }

    @GetMapping("/name/{name}")
    public CourtDto getCourtByName(@PathVariable String name) {
        return courtService.findByName(name);
    }

    @GetMapping("/renovation-status/{renovationStatus}")
    public List<CourtDto> getCourtsByRenovationStatus(@PathVariable RenovationStatus renovationStatus) {
        return courtService.findByRenovationStatus(renovationStatus);
    }

    @GetMapping("/court-type/{courtType}")
        public List<CourtDto> getCourtsByCourtType(@PathVariable CourtType courtType){
        return courtService.findByCourtType(courtType);
    }

    @GetMapping("/test")
    public String test() {
        return "api is working";
    }
}


