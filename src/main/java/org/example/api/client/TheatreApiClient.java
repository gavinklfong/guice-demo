package org.example.api.client;

import org.example.model.Theatre;

public class TheatreApiClient {

    public Theatre getTheatre(String theatreId) {
        return Theatre.builder()
                .id(theatreId)
                .rank(4)
                .build();
    }
}
