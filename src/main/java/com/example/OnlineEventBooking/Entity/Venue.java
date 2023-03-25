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
@Table(name = "venue")
public class Venue {

    @Id
    @Column(name = "id")
    private String id;
    @OneToMany(mappedBy = "venue")
    List<EventBooking> bookings;
    @Embedded
    private PersonInfo personInfo;
    @Column(name = "per_head_rate")
    private double perHeadRate;
    @Column(name = "password")
    private String password;
    @Column(name = "package_start_date")
    private String packageStartDate;
    @Column(name = "package_ends_date")
    private String packageEndsDate;
    @Column(name="is_package_active")
    private Boolean isPackageActive;
}
