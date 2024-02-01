package org.example.api.client;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Theatre;

@Slf4j
public class TheatreApiClient {
    public Theatre getTheatre(String theatreId) {
        log.info("get theatre: {}", theatreId);
        return Theatre.builder()
                .id(theatreId)
                .rank(4)
                .build();
    }
}
