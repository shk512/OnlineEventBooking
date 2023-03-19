package com.example.OnlineEventBooking.Service;


import com.example.OnlineEventBooking.Model.VenueModel;
import com.example.OnlineEventBooking.Repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class VenueService {

    @Autowired
    VenueRepository venueRepository;

    public VenueModel saveVenue(VenueModel venueModel){
        return  venueModel.assemble(venueRepository.save(venueModel.dissamble()));
    }
    public List<VenueModel> getVenue(String venueId){
        List<VenueModel> venueModelList=new ArrayList<>();

        if(venueId!=null){

        }else{

        }
        return venueModelList;
    }
}
