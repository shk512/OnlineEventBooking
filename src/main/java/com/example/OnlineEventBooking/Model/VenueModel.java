package com.example.OnlineEventBooking.Model;

import com.example.OnlineEventBooking.Entity.Venue;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class VenueModel {
    private String id;
    private String password;
    private double perHeadRate;
    private PersonInfoModel personInfoModel;
    private String packageStartDate;
    private String packageEndsDate;
    private Boolean isPackageActive;

    public Venue dissamble(){
        Venue venue=new Venue();

        venue.setId(this.id);
        venue.setPassword(this.password);
        venue.setPerHeadRate(this.perHeadRate);
        venue.setIsPackageActive(this.isPackageActive);
        venue.setPackageStartDate(this.packageStartDate);
        venue.setPackageEndsDate(this.packageEndsDate);
        venue.setPersonInfo(this.personInfoModel.dissamble());

        return venue;
    }
    public VenueModel assemble(Venue venue){
        VenueModel venueModel=new VenueModel();
        PersonInfoModel personInfoModel1=new PersonInfoModel();

        venueModel.setPackageEndsDate(venue.getPackageEndsDate());
        venueModel.setPassword(venue.getPassword());
        venueModel.setPerHeadRate(venue.getPerHeadRate());
        venueModel.setPackageStartDate(venue.getPackageStartDate());
        venueModel.setPersonInfoModel(personInfoModel1.assemble(venue.getPersonInfo()));
        venueModel.setId(venue.getId());
        venueModel.setIsPackageActive(venue.getIsPackageActive());

        return  venueModel;
    }
}
