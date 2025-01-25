package com.example.gobyrail.entity;

import java.time.LocalDate;

public class StationRequest {

    private int startStationId;
    private int destinationStationId;
    private LocalDate date;


    public int getStartStationId() {
        return startStationId;
    }

    public void setStartStationId(int startStationId) {
        this.startStationId = startStationId;
    }

    public int getDestinationStationId() {
        return destinationStationId;
    }

    public void setDestinationStationId(int destinationStationId) {
        this.destinationStationId = destinationStationId;
    }

    public void setDate(LocalDate date){
        this.date=date;
    }

    public LocalDate getDate(){
        return this.date;
    }
}
