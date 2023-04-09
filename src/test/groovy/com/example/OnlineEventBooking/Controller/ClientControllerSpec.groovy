package com.example.OnlineEventBooking.Controller

import com.example.OnlineEventBooking.Model.ClientModel
import com.example.OnlineEventBooking.Model.PersonInfoModel
import com.example.OnlineEventBooking.Service.ClientService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class ClientControllerSpec extends spock.lang.Specification{
    def mockClientService=Mock(ClientService.class)
    def testClientController=new ClientController(clientService: mockClientService)
    def mockMvc= MockMvcBuilders.standaloneSetup(testClientController).build()

    def "Post/ check the user successfully save"(){
        given:
        def clientModel=new ClientModel(personInfoModel: new PersonInfoModel(name: "Mukaram",contact: "0300-1234567",streetAddress: "Satellite Town",city: "Gujranwala"))
        def clientModelJson = new ObjectMapper().writeValueAsString(clientModel)
        mockClientService.saveClient(clientModel)>>new ClientModel(id: 1L, personInfoModel: new PersonInfoModel(name: "Mukaram",contact: "0300-1234567",streetAddress: "Satellite Town",city: "Gujranwala"))

        when:
        def response= mockMvc.perform(post("/client/save").contentType(MediaType.APPLICATION_JSON_VALUE).content(clientModelJson))

        then:
        response.andExpect (status().isOk())
    }
}
