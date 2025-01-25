package com.example.gobyrail.repository;

import com.example.gobyrail.entity.RouteSegment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RouteSegmentRepository extends JpaRepository<RouteSegment, Integer> {


    List<RouteSegment> findByDepartureStation_StationIdAndArrivalStation_StationId(int departureStationID, int arrivalStationID);
}
