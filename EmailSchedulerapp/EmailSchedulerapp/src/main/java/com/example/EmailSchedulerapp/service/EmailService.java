package com.example.EmailSchedulerapp.service;

import com.example.EmailSchedulerapp.entity.EmailLog;
import com.example.EmailSchedulerapp.repository.EmailLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor  // Lombok - Generates a constructor for final fields
public class EmailService {

    private final EmailLogRepository emailLogRepository;
    private final JavaMailSender mailSender;

    public void sendEmail(String recipient, String message) {
        // Create email message
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(recipient);
        mailMessage.setSubject("Test Email");
        mailMessage.setText(message);

        // Send email
        mailSender.send(mailMessage);
        System.out.println("Email sent to: " + recipient);

        // Log the email in the database
        EmailLog emailLog = new EmailLog();
        emailLog.setRecipient(recipient);
        emailLog.setMessage(message);
        emailLog.setSentAt(LocalDateTime.now());

        emailLogRepository.save(emailLog);
    }
}

