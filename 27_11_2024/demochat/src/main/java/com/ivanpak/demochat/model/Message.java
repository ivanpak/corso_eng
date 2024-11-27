package com.ivanpak.demochat.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Document(collection = "chat")
public class Message {
    @Id
    private String id;

    private Integer roomId;

    private String sender;
    private String message;
    private LocalDateTime createdAt;
}
