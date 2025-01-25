package com.example.gobyrail.entity;

import java.util.Map;

public class TrainScheduleResponse {
    private int scheduleId;
    private int trainId;
    private String trainName;
    private String startStationName;
    private String destinationStationName;
    private String departureTime;
    private String arrivalTime;
    private Map<SeatClass, Long> bookingCounts;

    public TrainScheduleResponse(TrainSchedule schedule, Map<SeatClass, Long> bookingCounts) {
        this.scheduleId = schedule.getScheduleId();
        this.trainId = schedule.getTrain().getTrainId();
        this.trainName = schedule.getTrain().getTrainName();
        this.startStationName = schedule.getFirstDepartureStation().getStationName();
        this.destinationStationName = schedule.getLastArrivalStation().getStationName();
        this.departureTime = schedule.getDepartureTime().toString();
        this.arrivalTime = schedule.getArrivalTime().toString();
        this.bookingCounts = bookingCounts;
    }


    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getStartStationName() {
        return startStationName;
    }

    public void setStartStationName(String startStationName) {
        this.startStationName = startStationName;
    }

    public String getDestinationStationName() {
        return destinationStationName;
    }

    public void setDestinationStationName(String destinationStationName) {
        this.destinationStationName = destinationStationName;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Map<SeatClass, Long> getBookingCounts() {
        return bookingCounts;
    }

    public void setBookingCounts(Map<SeatClass, Long> bookingCounts) {
        this.bookingCounts = bookingCounts;
    }
}
