package com.example.gobyrail.service;

import com.example.gobyrail.repository.FareRepository;
import com.example.gobyrail.entity.Fare;
import com.example.gobyrail.entity.SeatClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FareService {

    private final FareRepository fareRepository;

    @Autowired
    public FareService(FareRepository fareRepository) {
        this.fareRepository = fareRepository;
    }

    public List<Fare> getFaresByTrainId(int trainId) {
        return fareRepository.findByTrainTrainId(trainId);
    }

    public Fare getFareByTrainAndClass(int trainId, SeatClass classType) {
        return fareRepository.findByTrainTrainIdAndClassType(trainId, classType);
    }

    public Fare addFare(Fare fare) {
        return fareRepository.save(fare);
    }

    public Fare updateFare(Fare fare) {
        if (fareRepository.existsById(fare.getFareId())) {
            return fareRepository.save(fare);
        }
        throw new RuntimeException("Fare not found with id: " + fare.getFareId());
    }

    public void deleteFare(int fareId) {
        if (fareRepository.existsById(fareId)) {
            fareRepository.deleteById(fareId);
        } else {
            throw new RuntimeException("Fare not found with id: " + fareId);
        }
    }
}

