package com.example.gobyrail.service;

import com.example.gobyrail.repository.RouteSegmentRepository;
import com.example.gobyrail.entity.RouteSegment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteSegmentService {

    @Autowired
    private RouteSegmentRepository routeSegmentRepository;


    public List<RouteSegment> findRouteByStations(int startStationId, int destinationStationId) {
        return routeSegmentRepository.findByDepartureStation_StationIdAndArrivalStation_StationId(startStationId, destinationStationId);
    }


    public List<RouteSegment> getAllRouteSegments() {
        return routeSegmentRepository.findAll();
    }


}
