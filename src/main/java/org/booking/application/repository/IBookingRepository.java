package org.booking.application.repository;

import org.booking.core.entities.Booking;

import java.util.List;
import java.util.Optional;

public interface IBookingRepository {
    Booking create(String clientName, String carType);
    List<Booking> read();
    Optional<Booking> get(int id);
    Optional<Booking> update(int id, String clientName, String carType);
    boolean delete(int id);
}
