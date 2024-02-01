package org.example.dao;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.extern.slf4j.Slf4j;
import org.example.model.TicketStatus;
import org.jdbi.v3.core.Jdbi;

@Slf4j
public class TicketDao {

    private final Jdbi jdbi;

    @Inject
    public TicketDao(@Named("ticketDataConnection") Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public void updateTicketStatus(String ticketId, TicketStatus status) {
        log.info("update ticket status. ticket={}, status={}", ticketId, status);
    }
}
