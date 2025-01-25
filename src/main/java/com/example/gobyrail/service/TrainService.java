package com.example.gobyrail.service;

import com.example.gobyrail.entity.Train;
import com.example.gobyrail.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;


    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }


    public Train addTrain(Train train) {
        return trainRepository.save(train);
    }


    public Train getTrainById(Integer trainId) {
        return trainRepository.findById(trainId).orElse(null);
    }


    public Train updateTrain(Integer trainId, Train trainDetails) {
        Train train = getTrainById(trainId);
        if (train != null) {
            train.setTrainName(trainDetails.getTrainName());
            train.setFirstClassCapacity(trainDetails.getFirstClassCapacity());
            train.setSecondClassCapacity(trainDetails.getSecondClassCapacity());
            train.setThirdClassCapacity(trainDetails.getThirdClassCapacity());
            return trainRepository.save(train);
        }
        return null;
    }

    // Delete a train by ID
    public void deleteTrain(Integer trainId) {
        trainRepository.deleteById(trainId);
    }
}
