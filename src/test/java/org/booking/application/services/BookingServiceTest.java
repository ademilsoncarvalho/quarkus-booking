package org.booking.application.services;

import org.booking.application.repository.IBookingRepository;
import org.booking.application.utils.ILogger;
import org.booking.core.entities.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookingServiceTest {
    private IBookingRepository bookingRepository;
    private ILogger logger;
    private BookingService bookingService;

    @BeforeEach
    public void setup() {
        bookingRepository = Mockito.mock(IBookingRepository.class);
        logger = Mockito.mock(ILogger.class);
        bookingService = new BookingService(bookingRepository, logger);
    }

    @Test
    public void testRead() {
        List<Booking> bookings = Arrays.asList(new Booking("Test Car", "Type Car"), new Booking("Test Car", "Type Car"));
        when(bookingRepository.read()).thenReturn(bookings);

        List<Booking> result = bookingService.read();

        assertEquals(bookings, result);
        verify(bookingRepository, times(1)).read();
    }

    @Test
    public void testGet() {
        Booking booking = new Booking("Test Car", "Type Car");
        when(bookingRepository.get(anyInt())).thenReturn(Optional.of(booking));

        Optional<Booking> result = bookingService.get(1);

        assertTrue(result.isPresent());
        assertEquals(booking, result.get());
        verify(bookingRepository, times(1)).get(anyInt());
    }

    @Test
    public void testCreate() {
        Booking booking = new Booking("Test Car", "Type Car");
        when(bookingRepository.create(anyString(), anyString())).thenReturn(booking);

        Booking result = bookingService.create("client", "carType");

        assertEquals(booking, result);
        verify(bookingRepository, times(1)).create(anyString(), anyString());
    }

    @Test
    public void testUpdate() {
        Booking booking = new Booking("Test Car", "Type Car");
        when(bookingRepository.update(anyInt(), anyString(), anyString())).thenReturn(Optional.of(booking));

        Optional<Booking> result = bookingService.update(1, "client", "carType");

        assertTrue(result.isPresent());
        assertEquals(booking, result.get());
        verify(bookingRepository, times(1)).update(anyInt(), anyString(), anyString());
    }

    @Test
    public void testDelete() {
        when(bookingRepository.delete(anyInt())).thenReturn(true);

        boolean result = bookingService.delete(1);

        assertTrue(result);
        verify(bookingRepository, times(1)).delete(anyInt());
    }
}