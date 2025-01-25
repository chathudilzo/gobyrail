package com.example.gobyrail.service;

import com.example.gobyrail.entity.Station;
import com.example.gobyrail.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    public List<Station> getAllStations() {
        System.out.println(stationRepository.findAll());
        return stationRepository.findAll();
    }
}
