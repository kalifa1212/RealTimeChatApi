package com.theh.realchatapi.Groupe;

import com.theh.realchatapi.Message.Message;
import com.theh.realchatapi.Utilisateur.Utilisateur;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data @NoArgsConstructor @AllArgsConstructor
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;


//    private List<Utilisateur> membres;
//
//
//    private List<Message> messages;
}
