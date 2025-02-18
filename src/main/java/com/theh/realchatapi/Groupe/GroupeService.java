package com.theh.realchatapi.Groupe;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupeService {

    private final GroupeRepository groupeRepository;

//    public Optional<String> getChatRoomId(
//            String senderId,
//            String recipientId,
//            boolean createNewRoomIfNotExists
//    ) {
//        return groupeRepository
//                .findBySenderIdAndRecipientId(senderId, recipientId)
//                .map(Groupe::getId)
//                .or(() -> {
//                    if(createNewRoomIfNotExists) {
//                       // var chatId = createChatId(senderId, recipientId);
//                        var chatId="sdf";
//                        return Optional.of(chatId);
//                    }
//
//                    return  Optional.empty();
//                });
//    }

//    private String createChatId(String senderId, String recipientId) {
//        var chatId = String.format("%s_%s", senderId, recipientId);
//
//        Groupe senderRecipient = Groupe
//                .builder()
//                .id(chatId)
//                .(senderId)
//                .recipientId(recipientId)
//                .build();
//
//        Groupe recipientSender = Groupe
//                .builder()
//                .chatId(chatId)
//                .senderId(recipientId)
//                .recipientId(senderId)
//                .build();
//
//        groupeRepository.save(senderRecipient);
//        groupeRepository.save(recipientSender);
//
//        return chatId;
//    }
}
