package com.theh.realchatapi.Message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageNotification {
    private Long id;
    private Long senderId;
    private String chatId;
    private Long recipientId;
    private String content;
}
