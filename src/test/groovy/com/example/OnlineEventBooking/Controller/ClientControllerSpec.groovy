package com.example.OnlineEventBooking.Controller

import com.example.OnlineEventBooking.Model.ClientModel
import com.example.OnlineEventBooking.Model.PersonInfoModel
import com.example.OnlineEventBooking.Service.ClientService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class ClientControllerSpec extends Specification{
    def mockClientService=Mock(ClientService.class)
    def testClientController=new ClientController(clientService: mockClientService)
    def mockMvc= MockMvcBuilders.standaloneSetup(testClientController).build()

}
