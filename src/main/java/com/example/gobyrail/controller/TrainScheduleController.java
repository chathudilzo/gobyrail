package com.example.gobyrail.controller;

import com.example.gobyrail.service.TrainScheduleService;
import com.example.gobyrail.entity.TrainSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainschedules")
public class TrainScheduleController {

    @Autowired
    private TrainScheduleService trainScheduleService;


    @GetMapping
    public ResponseEntity<List<TrainSchedule>> getAllSchedules() {
        List<TrainSchedule> schedules = trainScheduleService.getAllSchedules();
        return ResponseEntity.ok(schedules);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TrainSchedule> getScheduleById(@PathVariable("id") int id) {
        TrainSchedule schedule = trainScheduleService.getScheduleById(id);
        if (schedule != null) {
            return ResponseEntity.ok(schedule);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<TrainSchedule> createSchedule(@RequestBody TrainSchedule trainSchedule) {
        TrainSchedule createdSchedule = trainScheduleService.createSchedule(trainSchedule);
        return ResponseEntity.status(201).body(createdSchedule);
    }
}
