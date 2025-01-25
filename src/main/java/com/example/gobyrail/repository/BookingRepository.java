package com.example.gobyrail.repository;

import com.example.gobyrail.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    // Custom queries can be added here, if necessary

    @Query("SELECT b.seatClass, COUNT(b) FROM Booking b " +
            "WHERE b.schedule.scheduleId = :scheduleId " +
            "AND b.train.trainId = :trainId " +
            "AND b.bookingStatus = 'CONFIRMED' " +
            "AND DATE(b.bookingTime) = :bookingDate " +
            "GROUP BY b.seatClass")
    List<Object[]> countBookingsByClass(
            @Param("scheduleId") int scheduleId,
            @Param("trainId") int trainId,
            @Param("bookingDate") java.time.LocalDate bookingDate
    );
}
