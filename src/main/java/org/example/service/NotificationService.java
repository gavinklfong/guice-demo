package org.example.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotificationService {

    public void sendTicketConfirmation(String userId, String ticketId) {
        log.info("send ticket confirmation for user: {} and ticket: {}", userId, ticketId);
    }
}
