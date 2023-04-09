package com.example.OnlineEventBooking.Repository;

import com.example.OnlineEventBooking.Entity.EventBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventBookingRepository extends JpaRepository<EventBooking,Long> {
    List<EventBooking> findEventBookingByVenue_IdAndDateAndTime(Long venueId, Date date,String time);
    List<EventBooking> findEventBookingByClient_PersonInfo_Contact(String contact);
    List<EventBooking> findEventBookingByVenue_Id(Long venueId);
}
