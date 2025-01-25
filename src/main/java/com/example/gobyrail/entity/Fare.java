package com.example.gobyrail.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fare")
public class Fare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fare_id")
    private int fareId;

    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false)
    private Train train;

    @Enumerated(EnumType.STRING)
    @Column(name = "class_type")
    private SeatClass classType;

    @Column(name = "base_fare_per_km")
    private double baseFarePerKm;


    public int getFareId() {
        return fareId;
    }

    public void setFareId(int fareId) {
        this.fareId = fareId;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public SeatClass getClassType() {
        return classType;
    }

    public void setClassType(SeatClass classType) {
        this.classType = classType;
    }

    public double getBaseFarePerKm() {
        return baseFarePerKm;
    }

    public void setBaseFarePerKm(double baseFarePerKm) {
        this.baseFarePerKm = baseFarePerKm;
    }
}

