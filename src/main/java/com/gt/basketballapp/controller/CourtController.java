package com.gt.basketballapp.controller;

import com.gt.basketballapp.model.Court;
import com.gt.basketballapp.model.CourtType;
import com.gt.basketballapp.model.RenovationStatus;
import com.gt.basketballapp.model.dto.CourtDto;
import com.gt.basketballapp.service.CourtService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/courts")
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "Basketball App", description = "Endpoints for managing courts")
public class CourtController {

    private final CourtService courtService;

    @PostMapping
    @Operation(summary = "Create a court", description = "Create a court", tags = {"Basketball App"},
            responses = {
                    @ApiResponse(description = "Created", responseCode = "201",
                            content = {
                                    @Content(
                                            schema = @Schema(implementation = Court.class)
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            })
    public ResponseEntity<Void> createCourt(@RequestBody CourtDto courtDto) {
        courtService.save(courtDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    @Operation(summary = "Get all courts", description = "Get all courts", tags = {"Basketball App"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            schema = @Schema(implementation = Court.class)
                                    )
                            }),
                    @ApiResponse(description = "No content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            })
    public ResponseEntity<List<CourtDto>> getAllCourts() {
        List<CourtDto> courts = courtService.findAll();
        return ResponseEntity.ok(courts);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find a court by ID", description = "Find a court by ID", tags = {"Basketball App"},
    responses = {
            @ApiResponse(description = "Success", responseCode = "200",
            content = {
                    @Content(
                            schema = @Schema(implementation = Court.class)
                    )
            }),
            @ApiResponse(description = "No content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
    })
    public ResponseEntity<CourtDto> getCourtById(@PathVariable Long id) {
        CourtDto courtDto = courtService.findById(id);
        return ResponseEntity.ok(courtDto);
    }

    @GetMapping("/name")
    @Operation(summary = "Find a court by name", description = "Find a court by name", tags = {"Basketball App"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            schema = @Schema(implementation = Court.class)
                                    )
                            }),
                    @ApiResponse(description = "No content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            })
    public ResponseEntity<CourtDto> findByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(courtService.findByName(name));
    }

    @GetMapping("/renovation-status/{renovationStatus}")
    @Operation(summary = "Find a court by renovation status", description = "Find a court by renovation status", tags = {"Basketball App"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            schema = @Schema(implementation = Court.class)
                                    )
                            }),
                    @ApiResponse(description = "No content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            })
    public ResponseEntity<List<CourtDto>> findByRenovationStatus(@PathVariable RenovationStatus renovationStatus) {
        return ResponseEntity.ok(courtService.findByRenovationStatus(renovationStatus));
    }

    @GetMapping("/court-type/{courtType}")
    @Operation(summary = "Find a court by court type", description = "Find a court by court type", tags = {"Basketball App"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            schema = @Schema(implementation = Court.class)
                                    )
                            }),
                    @ApiResponse(description = "No content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            })
    public ResponseEntity<List<CourtDto>> findByCourtType(@PathVariable CourtType courtType) {
        return ResponseEntity.ok(courtService.findByCourtType(courtType));
    }

    @GetMapping("/count-by-renovation-status")
    @Operation(summary = "Count courts by renovation status", description = "Count courts by renovation status", tags = {"Basketball App"},
            responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = Court.class)
                            )
                    }),
            @ApiResponse(description = "No content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
    })
    public ResponseEntity<Long> countByRenovationStatus(@RequestParam("renovationStatus") RenovationStatus renovationStatus) {
        return ResponseEntity.ok(courtService.countByRenovationStatus(renovationStatus));
    }

    @GetMapping("/count-by-court-type")
    @Operation(summary = "Count courts by court type", description = "Count courts by court type", tags = {"Basketball App"},
            responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = Court.class)
                            )
                    }),
            @ApiResponse(description = "No content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
    })
    public ResponseEntity<Long> countByCourtType(@RequestParam("courtType") CourtType courtType) {
        return ResponseEntity.ok(courtService.countByCourtType(courtType));
    }

    @GetMapping("/exists-by-name")
    @Operation(summary = "Check if a court exists by name", description = "Check if a court exists by name", tags = {"Basketball App"},
            responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = Court.class)
                            )
                    }),
            @ApiResponse(description = "No content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
    })
    public ResponseEntity<Boolean> existsByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(courtService.existsByName(name));
    }

    @GetMapping("/search")
    @Operation(summary = "Search courts by renovation status and court type", description = "Search courts by renovation status and court type", tags = {"Basketball App"},
            responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = Court.class)
                            )
                    }),
            @ApiResponse(description = "No content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
    })
    public ResponseEntity<List<CourtDto>> findByRenovationStatusAndCourtType(
            @RequestParam(name = "courtType", required = false) CourtType courtType,
            @RequestParam(name = "renovationStatus", required = false) RenovationStatus renovationStatus) {

        return ResponseEntity.ok(courtService.findByRenovationStatusAndCourtType(renovationStatus, courtType));
    }
}
