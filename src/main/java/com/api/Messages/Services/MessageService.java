package com.api.Messages.Services;


import com.api.Messages.Model.Message;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    public List<Message> messages = new ArrayList<>();
    public Date date;
    public Long nextId = 1L;

    public MessageService(){
        messages.add(new Message(nextId++ , "Yair", "Quiero money!!", LocalDateTime.now()));
        messages.add(new Message(nextId++ , "Facundo", "Deja de mentir", LocalDateTime.now()));
    }

    public List<Message> getAllMessages(){
        return messages;
    }

    public Optional<Message> getById(Long id){
        return messages.stream().filter( msg -> msg.getId().equals(id)).findFirst();
    }

    public Message addMessage(Message msg){
        msg.setId(nextId++);
        messages.add(msg);
        return msg;
    }


}
