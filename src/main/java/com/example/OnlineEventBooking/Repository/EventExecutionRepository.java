package com.example.OnlineEventBooking.Repository;

import com.example.OnlineEventBooking.Entity.EventExecution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventExecutionRepository extends JpaRepository<EventExecution,Long> {
}
