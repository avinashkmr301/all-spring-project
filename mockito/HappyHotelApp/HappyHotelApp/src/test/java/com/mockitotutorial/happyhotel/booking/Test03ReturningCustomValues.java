package com.mockitotutorial.happyhotel.booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

class Test03ReturningCustomValues {
    private BookingService bookingService;
    private PaymentService paymentServiceMock;
    private RoomService roomServiceMock;
    private BookingDAO bookingDAOMock;
    private MailSender mailSenderMock;

    @BeforeEach
    void setup(){
        this.paymentServiceMock = mock(PaymentService.class);
        this.bookingDAOMock = mock(BookingDAO.class);
        this.roomServiceMock = mock(RoomService.class);
        this.mailSenderMock = mock(MailSender.class);

        this.bookingService = new BookingService(paymentServiceMock,roomServiceMock,bookingDAOMock,mailSenderMock);

    }
    @Test
    void should_CountAvailablePlaces_When_OneRoomAvailable(){
        //given
        when(this.roomServiceMock.getAvailableRooms())
                .thenReturn(Collections.singletonList(new Room("Room 1",2)));
        int expected = 2;

        //when
        int actual = this.bookingService.getAvailablePlaceCount();

        //then
        assertEquals(expected,actual);
    }
    @Test
    void should_CountAvailablePlaces_When_MultipleRoomsAvailable(){
        //given
        List<Room> rooms = Arrays.asList(new Room("R1",2),new Room("R2",4));
        when(this.roomServiceMock.getAvailableRooms())
                .thenReturn(rooms);
        int expected = 6;
        //when
        int actual = this.bookingService.getAvailablePlaceCount();

        //then
        assertEquals(expected,actual);

    }

}