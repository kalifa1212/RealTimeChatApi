package com.theh.realchatapi.Utilisateur;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
@Data @NoArgsConstructor @AllArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String identifiant;
    private String prenom;
    private String email;
    private String motDePasse;
    private Status status;
    //@Temporal(TemporalType.DATE)
    private Date dateDeNaissance; // date format 2018-05-11T12:05:10
    private Date lastSeen; // date format 2018-05-11T12:05:10
    private String typecompte;
    private String imageUrl;
    private boolean isLocked;
    private boolean isUsing2FA;

//    private List<Utilisateur> amis;
//    @OneToMany
//    private List<Groupe> groupes;

}
