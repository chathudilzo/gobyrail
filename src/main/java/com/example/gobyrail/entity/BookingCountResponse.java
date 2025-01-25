package com.example.gobyrail.entity;

import java.util.Map;

public class BookingCountResponse {private int scheduleId;
    private int trainId;
    private Map<SeatClass, Long> bookingCounts;


    public BookingCountResponse(int scheduleId, int trainId, Map<SeatClass, Long> bookingCounts) {
        this.scheduleId = scheduleId;
        this.trainId = trainId;
        this.bookingCounts = bookingCounts;
    }

    // Getters and setters
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

    public Map<SeatClass, Long> getBookingCounts() {
        return bookingCounts;
    }

    public void setBookingCounts(Map<SeatClass, Long> bookingCounts) {
        this.bookingCounts = bookingCounts;
    }
}
