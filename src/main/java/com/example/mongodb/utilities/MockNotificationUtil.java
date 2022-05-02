package com.example.mongodb.utilities;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class MockNotificationUtil {
    public static String sendMockEmail(String email) {
        log.info("Your email body is =" + email);
        return "The mail has been sent";
    }

    private MockNotificationUtil() {
    }
}
