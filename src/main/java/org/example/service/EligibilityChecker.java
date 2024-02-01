package org.example.service;

public interface EligibilityChecker {
    boolean isEligibilityForTicketBooking(String userId, String theatreId, String ticketId);
}
