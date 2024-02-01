package org.example.service;

import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.TicketDao;
import org.example.model.TicketStatus;

@Slf4j
public class TicketBookingService {
    private EligibilityChecker eligibilityChecker;
    private TicketDao ticketDao;
    private NotificationService notificationService;

//    public TicketBookingService() {
//        this.eligibilityChecker = new EligibilityChecker(
//                "https://threatre-service:8080",
//                "https://user-service:9080",
//                "https://entitlement-service:8888");
//        this.ticketDao = new TicketDao("jdbc:mysql:booking-db.dev:3306/ticket", "app-user", "password123");
//        this.notificationService = new NotificationService("smtp.demo.com");
//    }


    @Inject
    public TicketBookingService(EligibilityChecker eligibilityChecker,
                                TicketDao ticketDao,
                                NotificationService notificationService) {
        this.eligibilityChecker = eligibilityChecker;
        this.ticketDao = ticketDao;
        this.notificationService = notificationService;
    }

    public boolean bookTicket(String userId, String theatreId, String ticketId) {
        log.info("book ticket - start");
        if (eligibilityChecker.isEligibilityForTicketBooking(userId, theatreId, ticketId)) {
            ticketDao.updateTicketStatus(ticketId, TicketStatus.RESERVED);
            notificationService.sendTicketConfirmation(userId, ticketId);
            return true;
        }

        return false;
    }
}
