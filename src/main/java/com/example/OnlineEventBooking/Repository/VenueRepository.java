package com.example.OnlineEventBooking.Repository;

import com.example.OnlineEventBooking.Entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<Venue,String> {

}
