package com.notificationcmd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// class for data transfer between publisher,broker and consumer
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MessageDto {

    private Integer notification_id;

}
