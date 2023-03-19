package com.example.OnlineEventBooking.Repository;

import com.example.OnlineEventBooking.Entity.EventBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventBookingRepository extends JpaRepository<EventBooking,Long> {

}
