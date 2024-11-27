package com.ivanpak.demochat.service;

import com.ivanpak.demochat.model.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MessageService {

    Flux<Message> findByRoomId(Integer roomId);

    Mono<Message> save(Message message);
}
