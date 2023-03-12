package com.example.OnlineEventBooking.Model;

import com.example.OnlineEventBooking.Entity.EventBooking;
import com.example.OnlineEventBooking.Entity.PersonInfo;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

public class ClientModel {
    private String clientId;
    private PersonInfo personInfo;
}
