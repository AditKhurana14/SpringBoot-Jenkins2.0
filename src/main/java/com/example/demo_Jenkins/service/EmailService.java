package com.example.demo_Jenkins.service;

public interface EmailService {

    void sendEmail(String to, String subject, String body);
}
