package com.example.OnlineEventBooking.Model;

import com.example.OnlineEventBooking.Entity.EventBooking;
import com.example.OnlineEventBooking.Entity.EventExecution;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class EventExecutionModel {
    private Long id;
    @JsonProperty("eventBooking")
    private EventBookingModel bookingId;
    private int attendee;
    private double totalAmount;
    private double balanceAmount;
    private double concessionAmount;
    public EventExecutionModel(EventExecution eventExecution){
        this.setId(eventExecution.getId());
        this.setAttendee(eventExecution.getAttendee());
        this.setTotalAmount(eventExecution.getTotalAmount());
        this.setConcessionAmount(eventExecution.getConcessionAmount());
        this.setBalanceAmount(eventExecution.getBalanceAmount());
        this.setBookingId(new EventBookingModel(eventExecution.getEventBooking()));
    }
    public EventExecution dissamble(EventBooking eventBooking){
        EventExecution eventExecution=new EventExecution();
        eventExecution.setAttendee(this.getAttendee());
        eventExecution.setConcessionAmount(this.concessionAmount);
        eventExecution.setTotalAmount(this.getAttendee()>eventBooking.getPersons()?eventBooking.getVenue().getPerHeadRate()*this.getAttendee():eventBooking.getTotalAmount());
        eventExecution.setBalanceAmount(eventExecution.getTotalAmount()-eventExecution.getConcessionAmount()-eventBooking.getAdvanceAmount());
        eventExecution.setEventBooking(eventBooking);
        return  eventExecution;
    }
}
