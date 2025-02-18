package com.theh.realchatapi.Message;

import com.theh.realchatapi.Groupe.GroupeService;
import com.theh.realchatapi.Utilisateur.Utilisateur;
import com.theh.realchatapi.Utilisateur.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository repository;
    private final UtilisateurRepository utilisateurRepository;
    private final GroupeService chatRoomService;

    public Message save(Message message) {
        //TODO test des utilisateur
        Optional<Utilisateur> utilisateur1=utilisateurRepository.findById(message.getExpediteurId());
        Optional<Utilisateur> utilisateur2=utilisateurRepository.findById(message.getExpediteurId());
        if(utilisateur1.isEmpty()||utilisateur2.isEmpty()){
            throw new RuntimeException("l'un des identifiant unique est invalide");
        }
        // TODO creation de la clef unique
        message.setChatId(String.valueOf(message.getExpediteurId()^ message.getUserDestinataireId()));
        //message.setChatId("S"+message.getExpediteurId()+"_D"+ message.getUserDestinataireId());
        repository.save(message);
        return message;
    }
    public List<Message> findChatList(Long userId) {
        String chatid="S"+userId;
        List<Message> chatlist=repository.findByChatIdContaining(chatid);
        return chatlist;
    }
    public List<Message> findChatMessages(Long expediteurId, Long recepteurId) {

        String ChatId= String.valueOf(expediteurId^recepteurId);
        //List<Message> messages =repository.findAllMessages("S"+expediteurId+"_D"+recepteurId,"S"+recepteurId+"_D"+expediteurId);
        List<Message> messages=repository.findAllByChatId(ChatId);
        messages.sort(Comparator.comparing(Message::getDateHeure));
        return messages;
    }

    public List<Message> chatList() {
            return null;
    }
}
