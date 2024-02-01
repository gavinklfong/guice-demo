package org.example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.extern.slf4j.Slf4j;
import org.example.config.TicketBookingModule;
import org.example.service.TicketBookingService;

@Slf4j
public class App {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new TicketBookingModule());
        TicketBookingService ticketBookingService = injector.getInstance(TicketBookingService.class);

        boolean success = ticketBookingService.bookTicket("user-01", "theatre-01", "ticket-99");
        log.info("success: {}", success);
    }
}