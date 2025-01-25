package com.example.gobyrail.service;

import com.example.gobyrail.repository.TrainScheduleRepository;
import com.example.gobyrail.entity.TrainSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainScheduleService {

    @Autowired
    private TrainScheduleRepository trainScheduleRepository;


    public List<TrainSchedule> getAllSchedules() {
        return trainScheduleRepository.findAll();
    }


    public TrainSchedule getScheduleById(int scheduleId) {
        return trainScheduleRepository.findById(scheduleId).orElse(null);
    }


    public TrainSchedule createSchedule(TrainSchedule trainSchedule) {
        return trainScheduleRepository.save(trainSchedule);
    }
}
