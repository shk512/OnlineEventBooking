package com.example.OnlineEventBooking.Controller

import com.example.OnlineEventBooking.Model.PersonInfoModel
import com.example.OnlineEventBooking.Model.VenueModel
import com.example.OnlineEventBooking.Service.VenueService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class VenueControllerSpec extends Specification{
    def mockVenueService=Mock(VenueService.class)
    def testVenueController=new VenueController(venueService: mockVenueService)
    def mockMvc= MockMvcBuilders.standaloneSetup(testVenueController).build()

    def setUpVenueModel(){
        [new VenueModel(id: 1L,perHeadRate: 1200,packageEndsDate: new Date(2023,05,03),packageStartDate: new Date(2023,04,03),isPackageActive: true,personInfoModel: new PersonInfoModel(name: "Pearl Continental",contact: "0300-1234567",streetAddress: "Mall Road",city: "Lahore"))]
    }

    def"Post/ check the venue register successfully"(){
        given:
        def venueModel=new VenueModel(perHeadRate: 1200,packageEndsDate: new Date(2023,05,03),packageStartDate: new Date(2023,04,03),isPackageActive: true,personInfoModel: new PersonInfoModel(name: "Pearl Continental",contact: "0300-1234567",streetAddress: "Mall Road",city: "Lahore"))
        def venueModelJson = new ObjectMapper().writeValueAsString(venueModel)

        when:
        def response= mockMvc.perform(post("/venue/register").contentType(MediaType.APPLICATION_JSON_VALUE).content(venueModelJson))
        then:
        response.andExpect (status().isOk())
    }
    def"Get/ retrieve venue list or specific venue by id"(){
        given:
        mockVenueService.getVenue(venueId)>>venueResponse

        when:
        def response = mockMvc.perform(get(inputPath).contentType(MediaType.APPLICATION_JSON_VALUE))

        then:
        response.andExpect (status().isOk())
        response.andExpect { MockMvcResultMatchers.jsonPath('$.id').value(1L)}

        where:
        inputPath       |   venueId |   venueResponse
        "/venue/"       |   null    |   setUpVenueModel()
        "/venue/?id=1"  |   1L      |   setUpVenueModel()
    }
}

