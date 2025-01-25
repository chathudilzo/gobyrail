package com.example.gobyrail.controller;

import com.example.gobyrail.service.TrainService;
import com.example.gobyrail.entity.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;


    @GetMapping
    public ResponseEntity<List<Train>> getAllTrains() {
        List<Train> trains = trainService.getAllTrains();
        return ResponseEntity.ok(trains);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Train> getTrainById(@PathVariable("id") Integer trainId) {
        Train train = trainService.getTrainById(trainId);
        if (train != null) {
            return ResponseEntity.ok(train);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<Train> addTrain(@RequestBody Train train) {
        Train newTrain = trainService.addTrain(train);
        return ResponseEntity.ok(newTrain);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Train> updateTrain(@PathVariable("id") Integer trainId, @RequestBody Train trainDetails) {
        Train updatedTrain = trainService.updateTrain(trainId, trainDetails);
        if (updatedTrain != null) {
            return ResponseEntity.ok(updatedTrain);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrain(@PathVariable("id") Integer trainId) {
        trainService.deleteTrain(trainId);
        return ResponseEntity.noContent().build();
    }
}
