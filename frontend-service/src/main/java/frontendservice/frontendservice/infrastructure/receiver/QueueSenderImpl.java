package com.app.frontendservice.infrastructure.receiver;

import com.app.frontendservice.api.dto.ReceiverDto;
import com.app.frontendservice.domain.model.receiver.Receiver;
import com.app.frontendservice.domain.receiver.ReceiverMapperDto;
import com.app.frontendservice.domain.receiver.QueueSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
@Slf4j
public class QueueSenderImpl implements QueueSender {

    private final RestTemplate restTemplate;

    @Value("${second-service.address.queue}")
    private String serviceQueueUrl;

    @Override
    public void sendOnQueue(ReceiverDto receiverDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Receiver> entity = new HttpEntity<>(ReceiverMapperDto.mapper(receiverDto), headers);
        restTemplate.exchange(serviceQueueUrl, HttpMethod.POST, entity, Receiver.class);
    }
}
