package org.example.api.client;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EntitlementApiClient {

    public int getEntitlementLevel(String userId) {
        log.info("get entitlement level for user: {}", userId);
        return 5;
    }
}
