package com.api.marketplaceconsumer.controllers;

import java.util.UUID;

public record EventRequest(
        String event,
        UUID orderId,
        UUID storeId,
        String timestamp
) {
}
