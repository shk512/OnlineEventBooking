package com.example.OnlineEventBooking.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Venue")
public class Venue {

    @Id
    @Column(name = "venue_id")
    private String venueId;
    @OneToMany(mappedBy = "venue")
    List<EventBooking> bookings;
    @Embedded
    private PersonInfo personInfo;
    @Column(name = "password")
    private String password;
    @Column(name = "package_start_date")
    private String packageStartDate;
    @Column(name = "package_ends_date")
    private String packageEndsDate;
    @Column(name="is_package_active")
    private boolean isPackageActive;
}
