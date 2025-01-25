package com.example.gobyrail.repository;

import com.example.gobyrail.entity.Fare;
import com.example.gobyrail.entity.SeatClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FareRepository extends JpaRepository<Fare, Integer> {
    List<Fare> findByTrainTrainId(int trainId);

    Fare findByTrainTrainIdAndClassType(int trainId, SeatClass classType);
}
