package com.example.gobyrail.repository;

import com.example.gobyrail.entity.TrainSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainScheduleRepository extends JpaRepository<TrainSchedule, Integer> {
}
