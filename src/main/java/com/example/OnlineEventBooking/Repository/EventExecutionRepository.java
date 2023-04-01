package com.example.OnlineEventBooking.Repository;

import com.example.OnlineEventBooking.Entity.EventExecution;
import com.example.OnlineEventBooking.Model.EventExecutionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventExecutionRepository extends JpaRepository<EventExecution,Long> {
    List<EventExecution> findEventExecutionByEventBooking_IdAndEventBooking_Venue_Id(Long bookingId,String venueId);
    List<EventExecution> findEventExecutionByEventBooking_Venue_Id(String id);
    EventExecution findEventExecutionByEventBooking_Id(Long Id);
}
