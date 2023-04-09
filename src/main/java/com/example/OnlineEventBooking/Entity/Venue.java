package com.example.OnlineEventBooking.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "venue")
public class Venue {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "venue")
    List<EventBooking> bookings;
    @Embedded
    private PersonInfo personInfo;
    @Column(name = "per_head_rate")
    private double perHeadRate;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "package_start_date")
    private Date packageStartDate;
    @Column(name = "package_ends_date")
    private Date packageEndsDate;
    @Column(name="is_package_active")
    private Boolean isPackageActive;
}
