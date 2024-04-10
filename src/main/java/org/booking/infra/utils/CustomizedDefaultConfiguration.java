package org.booking.infra.utils;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import org.booking.application.repository.IBookingRepository;
import org.booking.application.services.BookingService;
import org.booking.application.services.IBookingService;
import org.booking.application.utils.ILogger;

@Dependent
public class CustomizedDefaultConfiguration {

    private final IBookingRepository bookingRepository;
    private final ILogger logger;

    @Inject
    public CustomizedDefaultConfiguration(IBookingRepository bookingRepository, ILogger logger) {
        this.bookingRepository = bookingRepository;
        this.logger = logger;
    }

    @Produces
    public IBookingService createBookingService() {
        return new BookingService(bookingRepository, logger);
    }

}
