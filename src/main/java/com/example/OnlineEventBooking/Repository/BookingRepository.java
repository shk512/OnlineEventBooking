package com.example.OnlineEventBooking.Repository;

import com.example.OnlineEventBooking.Entity.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking,Integer> {

}
