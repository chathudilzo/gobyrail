package com.example.gobyrail.entity;

import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name = "trainschedule")
public class TrainSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scheduleId;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    @ManyToOne
    @JoinColumn(name = "first_departure_station_id")
    private Station firstDepartureStation;

    @ManyToOne
    @JoinColumn(name = "last_arrival_station_id")
    private Station lastArrivalStation;

    @Column(name = "departure_time")
    private Date departureTime;

    @Column(name = "arrival_time")
    private Date arrivalTime;


    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Station getFirstDepartureStation() {
        return firstDepartureStation;
    }

    public void setFirstDepartureStation(Station firstDepartureStation) {
        this.firstDepartureStation = firstDepartureStation;
    }

    public Station getLastArrivalStation() {
        return lastArrivalStation;
    }

    public void setLastArrivalStation(Station lastArrivalStation) {
        this.lastArrivalStation = lastArrivalStation;
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
}
