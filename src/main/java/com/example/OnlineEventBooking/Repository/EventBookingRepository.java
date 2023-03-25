package com.example.OnlineEventBooking.Repository;

import com.example.OnlineEventBooking.Entity.EventBooking;
import com.example.OnlineEventBooking.Entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventBookingRepository extends JpaRepository<EventBooking,Long> {
    EventBooking findEventBookingByVenue_IdAndDate(String venueId, Date date);
    List<EventBooking> findEventBookingByClient_Id(String clientId);
    List<EventBooking> findEventBookingByClient_IdAndDate(String clientId,Date date);
}
