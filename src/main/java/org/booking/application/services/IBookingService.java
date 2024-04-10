package org.booking.application.services;

import org.booking.core.entities.Booking;

import java.util.List;
import java.util.Optional;

public interface IBookingService {
    Booking create(String clientName, String carType);

    List<Booking> read();

    Optional<Booking> get(int id);

    Optional<Booking> update(int id, String clientName, String carType);

    boolean delete(int id);
}
