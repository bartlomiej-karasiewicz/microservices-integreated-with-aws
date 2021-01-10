package com.app.backendservice.domain.queue;

import com.app.backendservice.domain.model.report.Report;

public interface QueueMessage {
    void sendReportOnQueue(Report report);
}
