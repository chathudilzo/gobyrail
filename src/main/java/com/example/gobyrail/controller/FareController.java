package com.example.gobyrail.controller;

import com.example.gobyrail.service.FareService;
import com.example.gobyrail.entity.Fare;
import com.example.gobyrail.entity.SeatClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fares")
public class FareController {

    private final FareService fareService;

    @Autowired
    public FareController(FareService fareService) {
        this.fareService = fareService;
    }

    @GetMapping("/train/{trainId}")
    public ResponseEntity<List<Fare>> getFaresByTrainId(@PathVariable int trainId) {
        List<Fare> fares = fareService.getFaresByTrainId(trainId);
        return ResponseEntity.ok(fares);
    }

    @GetMapping("/train/{trainId}/class/{classType}")
    public ResponseEntity<Fare> getFareByTrainAndClass(@PathVariable int trainId, @PathVariable SeatClass classType) {
        Fare fare = fareService.getFareByTrainAndClass(trainId, classType);
        return ResponseEntity.ok(fare);
    }

    @PostMapping
    public ResponseEntity<Fare> addFare(@RequestBody Fare fare) {
        Fare createdFare = fareService.addFare(fare);
        return ResponseEntity.ok(createdFare);
    }

    @PutMapping
    public ResponseEntity<Fare> updateFare(@RequestBody Fare fare) {
        Fare updatedFare = fareService.updateFare(fare);
        return ResponseEntity.ok(updatedFare);
    }

    @DeleteMapping("/{fareId}")
    public ResponseEntity<Void> deleteFare(@PathVariable int fareId) {
        fareService.deleteFare(fareId);
        return ResponseEntity.noContent().build();
    }
}

