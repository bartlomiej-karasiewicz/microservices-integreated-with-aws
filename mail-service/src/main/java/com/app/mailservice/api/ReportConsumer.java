package com.app.mailservice.api;

import com.app.mailservice.domain.email.EmailSender;
import com.app.mailservice.domain.model.Report;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ReportConsumer {

    private final EmailSender emailSender;

    @SqsListener("${queue.name}")
    public void loadMessageFromSQS(Report report) {
        log.info("message from SQS " + report.reportContent());
        emailSender.sendReport(report.getMailAddress(), report.reportContent());
    }
}
