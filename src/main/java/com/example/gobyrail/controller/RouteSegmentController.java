package com.example.gobyrail.controller;

import com.example.gobyrail.entity.BookingCountResponse;
import com.example.gobyrail.service.BookingService;
import com.example.gobyrail.service.RouteSegmentService;
import com.example.gobyrail.entity.StationRequest;
import com.example.gobyrail.entity.RouteSegment;
import com.example.gobyrail.entity.TrainSchedule;
import com.example.gobyrail.entity.TrainScheduleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/routsegments")
public class RouteSegmentController {

    @Autowired
    private RouteSegmentService routeSegmentService;

    @Autowired
    private BookingService bookingService;


    @PostMapping("/findRoute")
    public ResponseEntity<List<TrainScheduleResponse>> getRouteByStations(@RequestBody StationRequest stationRequest) {


        int startStationId = stationRequest.getStartStationId();
        int destinationStationId = stationRequest.getDestinationStationId();
        LocalDate date=stationRequest.getDate();


        List<RouteSegment> routeSegments = routeSegmentService.findRouteByStations(startStationId, destinationStationId);
        List<TrainSchedule> trainSchedules = routeSegments.stream()
                .map(RouteSegment::getTrainSchedule)
                .distinct()
                .collect(Collectors.toList());
        List<TrainScheduleResponse> responses = trainSchedules.stream().map(schedule -> {

            BookingCountResponse bookingCountsResponse = bookingService.getBookingCountByClass(
                    schedule.getScheduleId(),
                    schedule.getTrain().getTrainId(),
                    date
            );

            return new TrainScheduleResponse(schedule, bookingCountsResponse.getBookingCounts());
        }).collect(Collectors.toList());


        return ResponseEntity.ok(responses);
    }

    @GetMapping
    public ResponseEntity<List<RouteSegment>> getAllRouteSegments() {
        List<RouteSegment> routeSegments = routeSegmentService.getAllRouteSegments();
        return routeSegments.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(routeSegments);
    }
}
