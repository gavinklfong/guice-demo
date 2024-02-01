package org.example.service;

import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.example.api.client.EntitlementApiClient;
import org.example.api.client.TheatreApiClient;
import org.example.api.client.UserApiClient;
import org.example.model.Theatre;
import org.example.model.User;

@Slf4j
public class EligibilityCheckerImpl implements EligibilityChecker {

    private EntitlementApiClient entitlementApiClient;
    private UserApiClient userApiClient;
    private TheatreApiClient theatreApiClient;

    @Inject
    public EligibilityCheckerImpl(EntitlementApiClient entitlementApiClient,
                                  UserApiClient userApiClient,
                                  TheatreApiClient theatreApiClient) {
        this.entitlementApiClient = entitlementApiClient;
        this.userApiClient = userApiClient;
        this.theatreApiClient = theatreApiClient;
    }

    public boolean isEligibilityForTicketBooking(String userId, String theatreId, String ticketId) {
        log.info("check eligibility for ticket booking");
        Theatre theatre = theatreApiClient.getTheatre(theatreId);
        User user = userApiClient.getUser(userId);
        int entitlementLevel = entitlementApiClient.getEntitlementLevel(userId);
        return entitlementLevel + user.getCredit() > theatre.getRank();
    }
}
