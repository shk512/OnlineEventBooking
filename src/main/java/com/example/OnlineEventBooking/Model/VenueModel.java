package com.example.OnlineEventBooking.Model;

import com.example.OnlineEventBooking.Entity.EventBooking;
import com.example.OnlineEventBooking.Entity.PersonInfo;
import com.example.OnlineEventBooking.Entity.Venue;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class VenueModel {
    private String venueId;
    private PersonInfoModel personInfoModel;
    private String packageStartDate;
    private String packageEndsDate;
    private boolean isPackageActive;

    public Venue dissamble(){
        Venue venue=new Venue();

        venue.setVenueId(venueId);
        venue.setPackageActive(isPackageActive);
        venue.setPackageStartDate(packageStartDate);
        venue.setPackageEndsDate(packageEndsDate);
        venue.setPersonInfo(personInfoModel.dissamble());

        return venue;
    }
    public VenueModel assemble(Venue venue){
        VenueModel venueModel=new VenueModel();

        venueModel.setPackageEndsDate(venue.getPackageEndsDate());
        venueModel.setPackageStartDate(venue.getPackageStartDate());
        venueModel.setPersonInfoModel(personInfoModel.assemble(venue.getPersonInfo()));
        venueModel.setVenueId(venue.getVenueId());
        if(venue.isPackageActive()){
            venueModel.setPackageActive(true);
        }else{
            venueModel.setPackageActive(false);
        }

        return  venueModel;
    }
}
