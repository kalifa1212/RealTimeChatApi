package com.theh.realchatapi.Utilisateur;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SingIn {
    String nom;
    String prenom;
    String email;
    String motDePasse;
    String identifiant;
    Date dateDeNaissance; //LocalDate aaaa-mm-jj DateFormat 2018-05-11T12:05:10
}
