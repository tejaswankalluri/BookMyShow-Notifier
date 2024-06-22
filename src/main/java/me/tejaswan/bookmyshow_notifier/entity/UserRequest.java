package me.tejaswan.bookmyshow_notifier.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Table(name = "user_request",
        indexes = {@Index(name = "user_request_0", columnList = "chat_id"),
                @Index(name = "user_request_1", columnList = "movie_code"),
                @Index(name = "user_request_2", columnList = "venue_code")})
@Entity
@Data
public class UserRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private int chatId;
    private String movieCode;
    private String venueCode;
    private Date date;

    @CreationTimestamp
    private Date createdAt;
}
