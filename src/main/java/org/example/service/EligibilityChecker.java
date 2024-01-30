package org.example.service;

public interface EligibilityChecker {
    boolean isEligibleForTicketBooking(String userId, String theatreId, String ticketId);
}
