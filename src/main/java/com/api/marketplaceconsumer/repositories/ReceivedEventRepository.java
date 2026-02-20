package com.api.marketplaceconsumer.repositories;

import com.api.marketplaceconsumer.entities.ReceivedEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReceivedEventRepository extends JpaRepository<ReceivedEvent, UUID> {
}
