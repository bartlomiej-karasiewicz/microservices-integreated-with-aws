package com.app.mailservice.domain.email;

public interface EmailSender {
    void sendReport(String mailAddress, String content);
}
