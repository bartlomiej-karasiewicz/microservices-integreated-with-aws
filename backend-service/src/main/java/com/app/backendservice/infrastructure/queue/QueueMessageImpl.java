package com.app.backendservice.infrastructure.queue;

import com.app.backendservice.domain.model.report.Report;
import com.app.backendservice.domain.queue.QueueMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueueMessageImpl implements QueueMessage {

    private final QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String endpointUri;

    @Override
    public void sendReportOnQueue(Report report) {
        queueMessagingTemplate.convertAndSend(endpointUri, report);
//        queueMessagingTemplate.send(endpointUri, MessageBuilder.withPayload(report).build());
    }
}
