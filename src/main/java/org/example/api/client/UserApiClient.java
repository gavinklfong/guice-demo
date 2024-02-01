package org.example.api.client;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.extern.slf4j.Slf4j;
import org.example.model.User;

@Slf4j
public class UserApiClient {

    private String url;

    @Inject
    public UserApiClient(@Named("userApiServiceUrl") String url) {
        log.info("url: {}", url);
        this.url = url;
    }

    public User getUser(String userId) {
        log.info("get user: {}", userId);
        return User.builder()
                .id(userId)
                .name("John Doe")
                .credit(10)
                .build();
    }
}
