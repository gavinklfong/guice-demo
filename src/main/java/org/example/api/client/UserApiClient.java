package org.example.api.client;

import org.example.model.User;

public class UserApiClient {

    public User getUser(String userId) {
        return User.builder()
                .id(userId)
                .name("John Doe")
                .credit(10)
                .build();
    }
}
