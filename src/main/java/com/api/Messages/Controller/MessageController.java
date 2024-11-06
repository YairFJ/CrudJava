package com.api.Messages.Controller;


import com.api.Messages.Model.Message;
import com.api.Messages.Services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @GetMapping("/messages")
    public List<Message> getAllMessages(){
        return messageService.getAllMessages();
    }
    @GetMapping("/message/{id}")
    public ResponseEntity<Message>getMessageById(@PathVariable Long id) {

        Optional<Message> message = messageService.getById(id);
        return message.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping("/message")
    public ResponseEntity<Message> addMessage(@RequestBody Message message) {
        Message newMessage = messageService.addMessage(message);
        return
                ResponseEntity.status(HttpStatus.CREATED).body(newMessage);
    }

    @PutMapping("/message/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable Long id, @RequestBody Message updatedMessage) {
        Message message = messageService.updateMessage(id,updatedMessage);
        return message != null ? ResponseEntity.ok(message) :
                ResponseEntity.notFound().build();
    }
    @DeleteMapping("/message/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id){
        return messageService.deleteMessage(id) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}
