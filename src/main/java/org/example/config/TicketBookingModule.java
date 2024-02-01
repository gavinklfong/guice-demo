package org.example.config;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import org.example.service.EligibilityChecker;
import org.example.service.EligibilityCheckerImpl;
import org.jdbi.v3.core.Jdbi;

public class TicketBookingModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(EligibilityChecker.class).to(EligibilityCheckerImpl.class);
    }

    @Provides
    @Named("userApiServiceUrl")
    String getUserApiServiceUrl() {
        return "https://user-service:9090";
    }

    @Provides
    @Singleton
    @Named("ticketDataConnection")
    Jdbi getTicketDataConnection() {
        return Jdbi.create("jdbc:mysql://booking-db:3306/ticket", "app-db-user", "password123");
    }
}
