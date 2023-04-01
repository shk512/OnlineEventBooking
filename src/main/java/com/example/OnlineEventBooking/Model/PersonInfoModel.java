package com.example.OnlineEventBooking.Model;

import com.example.OnlineEventBooking.Entity.PersonInfo;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;


@Component
@Data
@NoArgsConstructor
public class PersonInfoModel {
    private String name;
    private String contact;
    private String city;
    private String streetAddress;
    public  PersonInfoModel(PersonInfo personInfo){
        this.setName(personInfo.getName());
        this.setCity(personInfo.getCity());
        this.setContact(personInfo.getContact());
        this.setStreetAddress(personInfo.getStreetAddress());
    }
    public PersonInfo dissamble(){
        PersonInfo personInfo=new PersonInfo();
        personInfo.setCity(city);
        personInfo.setName(name);
        personInfo.setContact(contact);
        personInfo.setStreetAddress(streetAddress);
        return  personInfo;
    }
}
