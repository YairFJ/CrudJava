package com.api.Messages.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;

@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private Long id;
    private String user;
    private String message;
    private LocalDateTime dateCreated;

}
