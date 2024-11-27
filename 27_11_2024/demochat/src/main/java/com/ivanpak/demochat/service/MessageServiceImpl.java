package com.ivanpak.demochat.service;

import com.ivanpak.demochat.model.Message;
import com.ivanpak.demochat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;


    @Override
    public Flux<Message> findByRoomId(Integer roomId) {
        return messageRepository.findByRoomId(roomId);
    }

    @Override
    public Mono<Message> save(Message message) {
        return messageRepository.save(message);
    }
}
