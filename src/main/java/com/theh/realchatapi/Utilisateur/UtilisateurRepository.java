package com.theh.realchatapi.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    List<Utilisateur> findAllByStatus(Status status);

    Utilisateur findByEmail(String email);
    Utilisateur findUserByEmail(String email);

    //Utilisateur findAllByNickName(String nickname);
}
