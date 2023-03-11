package com.example.OnlineEventBooking.Repository;

import com.example.OnlineEventBooking.Entity.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends CrudRepository<Venue,String> {
}
