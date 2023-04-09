package com.example.OnlineEventBooking.Repository;

import com.example.OnlineEventBooking.Entity.EventBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventBookingRepository extends JpaRepository<EventBooking,Long> {
    EventBooking findEventBookingByDateAndTimeAndVenue_Id(Date date,String time,Long venueId);
    List<EventBooking> findEventBookingByIdAndVenue_Id(Long bookingId,Long venueId);
    List<EventBooking> findEventBookingByClient_PersonInfo_Contact(String contact);
    List<EventBooking> findEventBookingByVenue_Id(Long venueId);
}
