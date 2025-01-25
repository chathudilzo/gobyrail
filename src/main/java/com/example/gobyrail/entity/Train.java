package com.example.gobyrail.entity;

import jakarta.persistence.*;


import java.sql.Timestamp;

@Entity
@Table(name = "trains")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "train_id")
    private Integer trainId;

    @Column(name = "train_name")
    private String trainName;

    @Column(name = "first_class_capacity")
    private Integer firstClassCapacity;

    @Column(name = "second_class_capacity")
    private Integer secondClassCapacity;

    @Column(name = "third_class_capacity")
    private Integer thirdClassCapacity;

    @Column(name = "total_seats", insertable = false, updatable = false)
    private Integer totalSeats;

    @Column(name = "created_at")
    private Timestamp createdAt;



    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public Integer getFirstClassCapacity() {
        return firstClassCapacity;
    }

    public void setFirstClassCapacity(Integer firstClassCapacity) {
        this.firstClassCapacity = firstClassCapacity;
    }

    public Integer getSecondClassCapacity() {
        return secondClassCapacity;
    }

    public void setSecondClassCapacity(Integer secondClassCapacity) {
        this.secondClassCapacity = secondClassCapacity;
    }

    public Integer getThirdClassCapacity() {
        return thirdClassCapacity;
    }

    public void setThirdClassCapacity(Integer thirdClassCapacity) {
        this.thirdClassCapacity = thirdClassCapacity;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
