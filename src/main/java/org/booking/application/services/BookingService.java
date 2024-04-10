package org.booking.application.services;

import org.booking.application.repository.IBookingRepository;
import org.booking.application.utils.ILogger;
import org.booking.core.entities.Booking;


import java.util.List;
import java.util.Optional;

public class BookingService implements IBookingService {
    private final IBookingRepository bookingRepository;
    private final ILogger logger;

    public BookingService(IBookingRepository bookingRepository, ILogger logger) {
        this.bookingRepository = bookingRepository;
        this.logger = logger;
    }

    public List<Booking> read() {
        try {
            return bookingRepository.read();
        } catch (Exception e) {
            logger.info(e.getMessage());
            return null;
        }
    }

    public Optional<Booking> get(int id) {
        try {
            return bookingRepository.get(id);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return Optional.empty();
        }
    }

    public Booking create(String clientName, String carType) {
        if (clientName == null || clientName.isEmpty() || carType == null || carType.isEmpty()) {
            throw new IllegalArgumentException("Client name and car type must be provided");
        }

        try {
            return bookingRepository.create(clientName, carType);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return null;
        }
    }

    public Optional<Booking> update(int id, String clientName, String carType) {
        try {
            return bookingRepository.update(id, clientName, carType);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return Optional.empty();
        }
    }

    public boolean delete(int id) {
        try {
            return bookingRepository.delete(id);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
    }
}