package com.example.OnlineEventBooking.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class ClientModel {
    @Id
    @Column
    private String mail;
    @Id @Column private String contact;
    @Column private String name;
    @Column private String address;
}
