package com.theh.realchatapi.Message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value = "SELECT  m FROM  Message m WHERE  m.chatId=:chatId1 OR m.chatId=:chatId2  ORDER BY m.dateHeure DESC")
    List<Message> findAllMessages(@Param("chatId1")String chatId1,@Param("chatId2") String chatId2);

    List<Message> findAllByChatId(String chatId);
    List<Message> findByChatIdContaining(String chatId);
}