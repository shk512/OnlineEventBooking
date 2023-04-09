package com.example.OnlineEventBooking.Controller

import com.example.OnlineEventBooking.Model.PersonInfoModel
import com.example.OnlineEventBooking.Model.VenueModel
import com.example.OnlineEventBooking.Service.VenueService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

class VenueControllerSpec extends Specification{
    def mockVenueService=Mock(VenueService.class)
    def testVenueController=new VenueController(venueService: mockVenueService)
    def mockMvc= MockMvcBuilders.standaloneSetup(testVenueController).build()

    def"Post/ check the venue register successfully"(){
        given:
        def personModel=new PersonInfoModel(name: "Pearl Continental",contact: "0300-1234567",streetAddress: "Mall Road",city: "Lahore")
        def venueModel=new VenueModel(perHeadRate: 1200,packageEndsDate: "2023-05-03",packageStartDate: "2023-05-03",isPackageActive: true,personInfoModel: personModel)
        def venueModelJson = new ObjectMapper().writeValueAsString(venueModel)

        when:
        def response= mockMvc.perform(post("/venue/register").contentType(MediaType.APPLICATION_JSON_VALUE).content(venueModelJson))
        then:
        response.andExpect (status().isOk())
    }
}

