package com.ivanpak.demochat.controller;

import com.ivanpak.demochat.model.Message;
import com.ivanpak.demochat.service.MessageService;
import io.netty.handler.codec.MessageAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.time.LocalDateTime;

@RestController
public class ChatController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/api/chat")
    public Mono<Message> save(@RequestBody Message message) {
        message.setCreatedAt(LocalDateTime.now());
        return messageService.save(message);
    }

    @GetMapping(value = "/api/chat/room/{roomId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> get(@PathVariable Integer roomId) {
        return messageService.findByRoomId(roomId);
    }

}
