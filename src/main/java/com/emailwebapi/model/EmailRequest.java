package com.emailwebapi.model;

public class EmailRequest {

    private String from;
    private String to;
    private String subject;
    private String message;

    public EmailRequest(String from, String to, String subject, String message) {
        super();
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    public EmailRequest() {
        super();
    }
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "EmailRequest{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
