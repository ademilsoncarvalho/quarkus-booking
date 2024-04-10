package org.booking.infra.utils;

import jakarta.enterprise.context.ApplicationScoped;
import org.booking.application.utils.ILogger;

@ApplicationScoped
public class SystemLogger implements ILogger {
    @Override
    public void info(String message) {
        System.out.println(message);
    }
}
