package com.example.gobyrail;

import java.util.Date;

public class RouteSegmentDTO {
    private int segmentID;
    private int trainId;
    private int scheduleId;
    private int departureStationID;  // just the ID
    private int arrivalStationID;    // just the ID
    private Date departureTime;
    private Date arrivalTime;
    private double distance;


    public int getSegmentID() {
        return segmentID;
    }

    public void setSegmentID(int segmentID) {
        this.segmentID = segmentID;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getDepartureStationID() {
        return departureStationID;
    }

    public void setDepartureStationID(int departureStationID) {
        this.departureStationID = departureStationID;
    }

    public int getArrivalStationID() {
        return arrivalStationID;
    }

    public void setArrivalStationID(int arrivalStationID) {
        this.arrivalStationID = arrivalStationID;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
