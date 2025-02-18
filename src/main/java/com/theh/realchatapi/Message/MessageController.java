package com.theh.realchatapi.Message;

import com.theh.realchatapi.Utilisateur.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class MessageController {

    private final SimpMessagingTemplate messagingTemplate;
    private final MessageService messageService;
    private final UtilisateurRepository userRepository;

    @MessageMapping("/chat")
    public void processMessage(@Payload Message message) {
        Message savedMsg = messageService.save(message);
        messagingTemplate.convertAndSendToUser(
                userRepository.findById(message.getUserDestinataireId()).get().getIdentifiant(), "/queue/messages",
                new MessageNotification(
                        savedMsg.getId(),
                        savedMsg.getExpediteurId(),
                        savedMsg.getChatId(),
                        savedMsg.getUserDestinataireId(),
                        savedMsg.getContenu()

                )
        );
    }

    @GetMapping("/messages/{senderId}/{recepteurId}")
    public ResponseEntity<List<Message>> findChatMessages(@PathVariable Long senderId,
                                                          @PathVariable Long recepteurId) {
        return ResponseEntity
                .ok(messageService.findChatMessages(senderId, recepteurId));
    }
    @GetMapping("/chat/list/{userId}")
    public ResponseEntity<List<Message>> SpecificChat(@PathVariable Long userId) {
        int a=5,b=3;
        int c =a^b;
        log.error("c vaut {}",c);
        return ResponseEntity
                .ok(messageService.findChatList(userId));
    }
    @GetMapping("/chat/list/")
    public ResponseEntity<List<Message>> chatList() {
        int a=5,b=3;
        int c =a^b;
        log.error("c vaut {}",c);
        return ResponseEntity
                .ok(messageService.chatList());
    }
}
