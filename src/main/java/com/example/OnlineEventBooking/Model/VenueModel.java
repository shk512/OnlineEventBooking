package com.example.OnlineEventBooking.Model;

import com.example.OnlineEventBooking.Entity.Venue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class VenueModel {
    private Long id;
    private double perHeadRate;
    @JsonProperty("venueInfo")
    private PersonInfoModel personInfoModel;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date packageStartDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date packageEndsDate;
    private Boolean isPackageActive;
    private String username;
    private String password;
    public VenueModel(Venue venue ){
        this.setId(venue.getId());
        this.setPassword(venue.getPassword());
        this.setUsername(venue.getUsername());
        this.setPackageStartDate(venue.getPackageStartDate());
        this.setPerHeadRate(venue.getPerHeadRate());
        this.setPackageEndsDate(venue.getPackageEndsDate());
        this.setIsPackageActive(venue.getIsPackageActive());
        this.setPersonInfoModel(new PersonInfoModel(venue.getPersonInfo()));
    }
    public Venue dissamble(){
        Venue venue=new Venue();

        venue.setId(this.id);
        venue.setPassword(this.password);
        venue.setUsername(this.username);
        venue.setPerHeadRate(this.perHeadRate);
        venue.setIsPackageActive(this.isPackageActive);
        venue.setPackageStartDate(this.packageStartDate);
        venue.setPackageEndsDate(this.packageEndsDate);
        venue.setPersonInfo(this.personInfoModel.dissamble());

        return venue;
    }
}
