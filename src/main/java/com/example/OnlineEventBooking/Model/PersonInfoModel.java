package com.example.OnlineEventBooking.Model;

import com.example.OnlineEventBooking.Entity.PersonInfo;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NonNull;
import org.springframework.stereotype.Component;


@Component
@Data
public class PersonInfoModel {
    private String name;
    private String contact;
    private String city;
    private String streetAddress;

    public PersonInfo dissamble(){
        PersonInfo personInfo=new PersonInfo();

        personInfo.setCity(city);
        personInfo.setName(name);
        personInfo.setContact(contact);
        personInfo.setStreetAddress(streetAddress);

        return  personInfo;
    }
    public PersonInfoModel assemble(PersonInfo personInfo){
        PersonInfoModel personInfoModel=new PersonInfoModel();

        personInfoModel.setCity(personInfo.getCity());
        personInfoModel.setContact(personInfo.getContact());
        personInfoModel.setName(personInfo.getName());
        personInfoModel.setStreetAddress(personInfo.getStreetAddress());

        return  personInfoModel;
    }
}
