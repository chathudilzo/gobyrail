package com.example.gobyrail.service;


import com.example.gobyrail.entity.*;
import com.example.gobyrail.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private TrainScheduleRepository trainScheduleRepository;

    @Autowired
    private StationRepository stationRepository;

    public Booking createBooking(BookingRequest bookingRequest) {

        User user = userRepository.findById(bookingRequest.getUserId()).orElse(null);
        if (user == null) {
            throw new RuntimeException("User not found with ID: " + bookingRequest.getUserId());
        }

        Train train = trainRepository.findById(bookingRequest.getTrainId()).orElse(null);
        if (train == null) {
            throw new RuntimeException("Train not found with ID: " + bookingRequest.getTrainId());
        }

        TrainSchedule schedule = trainScheduleRepository.findById(bookingRequest.getScheduleId()).orElse(null);
        if (schedule == null) {
            throw new RuntimeException("Schedule not found with ID: " + bookingRequest.getScheduleId());
        }

        Station departureStation = stationRepository.findById(bookingRequest.getDepartureStationId()).orElse(null);
        if (departureStation == null) {
            throw new RuntimeException("Departure station not found with ID: " + bookingRequest.getDepartureStationId());
        }

        Station arrivalStation = stationRepository.findById(bookingRequest.getArrivalStationId()).orElse(null);
        if (arrivalStation == null) {
            throw new RuntimeException("Arrival station not found with ID: " + bookingRequest.getArrivalStationId());
        }


        SeatClass seatClass;
        try {
            seatClass = SeatClass.valueOf(bookingRequest.getSeatClass());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid seat class: " + bookingRequest.getSeatClass());
        }


        BookingStatus bookingStatus;
        try {
            bookingStatus = BookingStatus.valueOf(bookingRequest.getBookingStatus());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid booking status: " + bookingRequest.getBookingStatus());
        }


        BookingType bookingType;
        try {
            bookingType = BookingType.valueOf(bookingRequest.getBookingType());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid booking type: " + bookingRequest.getBookingType());
        }
        LocalDate bookingDate;
        try {
            bookingDate = bookingRequest.getDate();
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid Date: " + bookingRequest.getDate());
        }


        Booking booking = new Booking();
        booking.setUser(user);
        booking.setTrain(train);
        booking.setSchedule(schedule);
        booking.setDepartureStation(departureStation);
        booking.setArrivalStation(arrivalStation);
        booking.setSeatClass(seatClass);
        booking.setSeatsBooked(bookingRequest.getSeatsBooked());
        booking.setBookingStatus(bookingStatus);
        booking.setBookingType(bookingType);
        booking.setBookingTime(new Timestamp(System.currentTimeMillis()));
        booking.setBookingDate(bookingRequest.getDate());// Automatically set booking time


        return bookingRepository.save(booking);
    }



    public boolean cancelBooking(int bookingId) {
        Optional<Booking> bookingOptional = bookingRepository.findById(bookingId);
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            booking.setBookingStatus(BookingStatus.CANCELLED);
            bookingRepository.save(booking);
            return true;
        }
        return false;
    }


    public Optional<Booking> getBookingById(int bookingId) {
        return bookingRepository.findById(bookingId);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public BookingCountResponse getBookingCountByClass(int scheduleId, int trainId, LocalDate date) {
        List<Object[]> results = bookingRepository.countBookingsByClass(scheduleId, trainId, date);
        Map<SeatClass, Long> countMap = new HashMap<>();

        for (Object[] result : results) {
            SeatClass seatClass = (SeatClass) result[0];
            Long count = (Long) result[1];
            countMap.put(seatClass, count);
        }


        return new BookingCountResponse(scheduleId, trainId, countMap);
    }



}

