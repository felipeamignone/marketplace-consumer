package com.api.marketplaceconsumer.services;

import com.api.marketplaceconsumer.controllers.EventRequest;
import com.api.marketplaceconsumer.entities.ReceivedEvent;
import com.api.marketplaceconsumer.repositories.ReceivedEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EventService {
    private final ReceivedEventRepository receivedEventRepository;
    private final RestTemplate restTemplate;
    private final String marketplaceApiUrl;

    public EventService(
            ReceivedEventRepository receivedEventRepository,
            RestTemplate restTemplate,
            @Value("${marketplace.api.url}") String marketplaceApiUrl
    ) {
        this.receivedEventRepository = receivedEventRepository;
        this.restTemplate = restTemplate;
        this.marketplaceApiUrl = marketplaceApiUrl;
    }

    public ReceivedEvent processEvent(EventRequest request) {
        String orderSnapshot = fetchOrderSnapshot(request.orderId().toString());

        ReceivedEvent receivedEvent = new ReceivedEvent(
                request.event(),
                request.orderId(),
                request.storeId(),
                request.timestamp(),
                orderSnapshot
        );

        ReceivedEvent saved = receivedEventRepository.save(receivedEvent);
        return saved;
    }

    private String fetchOrderSnapshot(String orderId) {
        String url = marketplaceApiUrl + "/orders/" + orderId;
        return restTemplate.getForObject(url, String.class);
    }
}
