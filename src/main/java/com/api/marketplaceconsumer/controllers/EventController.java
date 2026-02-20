package com.api.marketplaceconsumer.controllers;

import com.api.marketplaceconsumer.entities.ReceivedEvent;
import com.api.marketplaceconsumer.services.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<ReceivedEvent> receiveEvent(@RequestBody EventRequest request) {
        ReceivedEvent saved = eventService.processEvent(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
