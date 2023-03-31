package com.example.OnlineEventBooking.Service;

import com.example.OnlineEventBooking.Entity.Venue;
import com.example.OnlineEventBooking.Model.VenueModel;
import com.example.OnlineEventBooking.Repository.VenueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class VenueService {

    @Autowired
    VenueRepository venueRepository;
    @Transactional
    public String saveVenue(VenueModel venueModel){
        String result;
        if(searchVenue(venueModel.getId())){
            result="Already exists";
        }else {
            result= upsert(venueModel)!=null?"Successfuly registered":"Error";
        }
        return  result;
    }
    @Transactional
    public String update(VenueModel venueModel){
        String result;
        if(searchVenue(venueModel.getId())){
            result=upsert(venueModel)!=null?"Successfuly Updated":"Error";
        }else {
            result="Don't exists";
        }
        return  result;
    }
    @Transactional
    private VenueModel upsert(VenueModel venueModel){
        return new VenueModel(venueRepository.save(venueModel.dissamble()));
    }
    @Transactional
    private boolean searchVenue(String id){
        return venueRepository.existsById(id);
    }
    public List<VenueModel> getVenue(String venueId,String pass){
        List<VenueModel> venueList;
        if(venueId!=null && pass!=null){
            venueList=Stream.of(venueRepository.findVenueByIdAndPassword(venueId,pass)).map(VenueModel::new).collect(Collectors.toList());
        }else if(venueId!=null){
            venueList=Stream.of(venueRepository.findVenueById(venueId)).map(VenueModel::new).collect(Collectors.toList());
        }else{
            venueList= venueRepository.findAll().stream().map(VenueModel::new).collect(Collectors.toList());
        }
        return venueList;
    }
    @Transactional
    public String deleteVenue(String id){
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
