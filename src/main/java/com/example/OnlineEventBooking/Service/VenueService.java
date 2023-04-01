package com.example.OnlineEventBooking.Service;

import com.example.OnlineEventBooking.Entity.Venue;
import com.example.OnlineEventBooking.Model.VenueModel;
import com.example.OnlineEventBooking.Repository.VenueRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class VenueService {

    @Autowired
    VenueRepository venueRepository;
    @Transactional
    public VenueModel saveVenue(VenueModel venueModel){
        VenueModel responseModel;
        if(venueModel.getId()!=null){
            if(searchVenue(venueModel.getId())){
                responseModel=new VenueModel(venueRepository.save(venueModel.dissamble()));
            }else {
                responseModel=new VenueModel(venueRepository.save(venueModel.dissamble()));
            }
        }else{
            responseModel=new VenueModel(venueRepository.save(venueModel.dissamble()));
        }
        return  responseModel;
    }
    @Transactional
    public Venue getVenueEntity(Long id){
        return venueRepository.findById(id).get();
    }
    @Transactional
    private boolean searchVenue(Long id){
        return venueRepository.existsById(id);
    }
    public List<VenueModel> getVenue(Long venueId){
        List<VenueModel> venueList;
        if(venueId!=null){
            venueList=venueRepository.findById(venueId).stream().map(VenueModel::new).collect(Collectors.toList());
        }else {
            venueList=venueRepository.findAll().stream().map(VenueModel::new).collect(Collectors.toList());
        }
        return venueList;
    }
    @Transactional
    public String deleteVenue(Long id){
        String result;
        if(searchVenue(id)){
            venueRepository.deleteById(id);
            result="Deleted";
        }else {
            result="Don't exists";
        }
        return  result;
    }
}
