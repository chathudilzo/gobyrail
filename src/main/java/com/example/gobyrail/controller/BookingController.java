package com.example.gobyrail.controller;

import com.example.gobyrail.entity.BookingCountResponse;
import com.example.gobyrail.entity.BookingRequest;
import com.example.gobyrail.service.BookingService;
import com.example.gobyrail.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;


    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest bookingRequest) {

        Booking createdBooking = bookingService.createBooking(bookingRequest);
        return ResponseEntity.ok(createdBooking);
    }


    @PostMapping("/cancel/{bookingId}")
    public ResponseEntity<String> cancelBooking(@PathVariable int bookingId) {
        boolean success = bookingService.cancelBooking(bookingId);
        if (success) {
            return ResponseEntity.ok("Booking successfully cancelled.");
        } else {
            return ResponseEntity.status(404).body("Booking not found.");
        }
    }


    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable int bookingId) {
        Optional<Booking> booking = bookingService.getBookingById(bookingId);
        return booking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(404).build());
    }


    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return bookings.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(bookings);
    }

    @GetMapping("/bookingCountByClass")
    public ResponseEntity<BookingCountResponse> getBookingCountByClass(@RequestParam int scheduleId, @RequestParam int trainId, @RequestParam LocalDate date) {
        BookingCountResponse response = bookingService.getBookingCountByClass(scheduleId, trainId, date);
        return ResponseEntity.ok(response);
    }
}
