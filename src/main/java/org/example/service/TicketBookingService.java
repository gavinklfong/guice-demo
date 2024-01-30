package org.example.service;

import com.google.inject.Inject;
import org.example.dao.TicketDao;
import org.example.model.TicketStatus;

public class TicketBookingService {
    private EligibilityChecker eligibilityChecker;
    private TicketDao ticketDao;
    private NotificationService notificationService;

    @Inject
    public TicketBookingService(EligibilityChecker eligibilityChecker,
                                TicketDao ticketDao,
                                NotificationService notificationService) {
        this.eligibilityChecker = eligibilityChecker;
        this.ticketDao = ticketDao;
        this.notificationService = notificationService;
    }

    public boolean bookTicket(String userId, String theatreId, String ticketId) {
        if (eligibilityChecker.isEligibleForTicketBooking(userId, theatreId, ticketId)) {
            ticketDao.updateTicketStatus(ticketId, TicketStatus.RESERVED);
            notificationService.sendTicketConfirmation(userId, ticketId);
            return true;
        }

        return false;
    }
}
