package com.theh.realchatapi.Utilisateur;

import com.theh.realchatapi.Message.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@CrossOrigin
public class UtilisateurController {

    private final UtilisateurService utilisateurService;
    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/user/authenticate/ws")
    @PostMapping("/user/authenticate")
    //@SendTo("/user/public")
    public ResponseEntity<Utilisateur> Connexion(@RequestBody Login login) {
        Utilisateur utilisateur = utilisateurService.authentication(login.Email, login.passwd);
//        template.convertAndSend("/topic/public",new Notification(utilisateur.getId(),
//                utilisateur.getIdentifiant(), "ONLINE"));
        template.convertAndSend("/topic/public",utilisateur);
        return ResponseEntity.ok(utilisateur);
    }

    @PostMapping("/user/nouveau")
   // @SendTo("/user/public")
    public ResponseEntity<Utilisateur> addUser(@RequestBody SingIn user) {

        return ResponseEntity.ok(utilisateurService.saveUser(user));
    }

    @MessageMapping("/utilisateur.disconnectUser")
    //@SendTo("/user/public")
    public Utilisateur disconnectUser(
            @Payload Utilisateur utilisateur
    ) {
        Utilisateur user= utilisateurService.disconnect(utilisateur);
        this.template.convertAndSend("/topic/public",user);
        return user;
    }

    @GetMapping("/users")
    public ResponseEntity<List<Utilisateur>> findConnectedUsers() {
        return ResponseEntity.ok(utilisateurService.findConnectedUsers());
    }
    @GetMapping("/users/find/{id}")
    public ResponseEntity<Utilisateur> findUsers(@PathVariable("id") Long id) {
        return ResponseEntity.ok(utilisateurService.findUsers(id).get());
    }
}
