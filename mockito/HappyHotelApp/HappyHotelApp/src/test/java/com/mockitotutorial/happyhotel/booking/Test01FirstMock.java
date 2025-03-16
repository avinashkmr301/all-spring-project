package com.mockitotutorial.happyhotel.booking;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class Test01FirstMock {
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
    void should_CalculateCorrectPrice_When_CorrectInput(){
        //given
        BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2024,3,7),LocalDate.of(2024,3,10),3,false);
        double expected = 50.0 * 3 * 3;
        //when
        double actual = bookingService.calculatePrice(bookingRequest);
        //then
        assertEquals(expected,actual);
    }

}