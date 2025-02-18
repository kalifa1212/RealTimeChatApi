package com.theh.realchatapi.Message;

import com.theh.realchatapi.Groupe.Groupe;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table
@Data @NoArgsConstructor @AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String chatId;
    private String contenu;
//    @Column(name="heure")
    private Date dateHeure ;
    private Long expediteurId;
    @OneToOne
    private Groupe groupeDestinataire;
    private Long userDestinataireId;

//    @DBRef
//    private Object destinataire;
}
