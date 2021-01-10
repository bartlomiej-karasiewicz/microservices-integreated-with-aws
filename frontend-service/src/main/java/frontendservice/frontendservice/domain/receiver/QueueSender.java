package com.app.frontendservice.domain.receiver;

import com.app.frontendservice.api.dto.ReceiverDto;

public interface QueueSender {
    void sendOnQueue(ReceiverDto receiverDto);
}
