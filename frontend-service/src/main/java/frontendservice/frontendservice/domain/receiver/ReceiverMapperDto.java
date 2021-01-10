package com.app.frontendservice.domain.receiver;

import com.app.frontendservice.api.dto.ReceiverDto;
import com.app.frontendservice.domain.model.receiver.Receiver;

public class ReceiverMapperDto {

    public static Receiver mapper(ReceiverDto receiverDto) {
        return Receiver.builder().mailAddress(receiverDto.getMailAddress()).build();
    }
}
