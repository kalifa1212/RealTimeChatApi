package com.theh.realchatapi.Groupe;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {
    //Optional<Groupe> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
