package com.example.OnlineEventBooking.Repository;

import com.example.OnlineEventBooking.Entity.EventBooking;
import com.example.OnlineEventBooking.Entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventBookingRepository extends JpaRepository<EventBooking,Long> {
    List<EventBooking> findEventBookingByVenue_IdAndDate(Long venueId, Date date);
    List<EventBooking> findEventBookingByClient_Id(Long clientId);
    List<EventBooking> findEventBookingByVenue_Id(Long venueId);
    List<EventBooking> findEventBookingbyClient_IdAndDate(Long clientId,Date date);
}
