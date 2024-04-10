package org.booking.infra.repositorys;

import jakarta.enterprise.context.ApplicationScoped;
import org.booking.application.repository.IBookingRepository;
import org.booking.core.entities.Booking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookingRepository implements IBookingRepository {
    private final List<Booking> bookings = new ArrayList<>();

    @Override
    public Booking create(String clientName, String carType) {
        Booking booking = new Booking(clientName, carType);
        bookings.add(booking);
        return booking;
    }

    @Override
    public List<Booking> read() {
        return bookings;
    }

    @Override
    public Optional<Booking> get(int id) {
        for (Booking booking : bookings) {
            if (booking.getId() == id) {
                return Optional.of(booking);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Booking> update(int id, String clientName, String carType) {
        for (Booking booking : bookings) {
            if (booking.getId() == id) {
                booking.setClientName(clientName);
                booking.setCarType(carType);
                return Optional.of(booking);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(int id) {
        return bookings.removeIf(booking -> booking.getId() == id);
    }
}