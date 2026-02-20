package com.api.marketplaceconsumer.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "received_events")
public class ReceivedEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String event;

    @Column(nullable = false)
    private UUID orderId;

    @Column(nullable = false)
    private UUID storeId;

    @Column(nullable = false)
    private String eventTimestamp;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String orderSnapshot;

    @Column(nullable = false)
    private LocalDateTime receivedAt;

    protected ReceivedEvent() {
    }

    public ReceivedEvent(String event, UUID orderId, UUID storeId, String eventTimestamp, String orderSnapshot) {
        this.event = event;
        this.orderId = orderId;
        this.storeId = storeId;
        this.eventTimestamp = eventTimestamp;
        this.orderSnapshot = orderSnapshot;
        this.receivedAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public String getEvent() {
        return event;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public UUID getStoreId() {
        return storeId;
    }

    public String getEventTimestamp() {
        return eventTimestamp;
    }

    public String getOrderSnapshot() {
        return orderSnapshot;
    }

    public LocalDateTime getReceivedAt() {
        return receivedAt;
    }
}
