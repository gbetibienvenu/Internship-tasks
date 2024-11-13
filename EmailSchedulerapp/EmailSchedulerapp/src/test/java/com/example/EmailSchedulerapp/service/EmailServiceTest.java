package com.example.EmailSchedulerapp.service;

import com.example.EmailSchedulerapp.entity.EmailLog;
import com.example.EmailSchedulerapp.exception.EmailException;
import com.example.EmailSchedulerapp.repository.EmailLogRepository;
import com.example.EmailSchedulerapp.service.EmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EmailServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @Mock
    private EmailLogRepository emailLogRepository;

    @InjectMocks
    private EmailService emailService;

    private final String recipient = "test@example.com";
    private final String message = "Test Message";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSendEmailSuccess() {
        // Arrange
        doNothing().when(mailSender).send(any(SimpleMailMessage.class));
        EmailLog emailLog = new EmailLog();
        emailLog.setRecipient(recipient);
        emailLog.setMessage(message);
        emailLog.setSentAt(LocalDateTime.now());

        // Act
        emailService.sendEmail(recipient, message);

        // Assert
        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
        verify(emailLogRepository, times(1)).save(any(EmailLog.class));
    }

    @Test
    void testSendEmailFailure() {
        // Arrange: Simulate an exception thrown by JavaMailSender
        doThrow(new RuntimeException("Email send failed")).when(mailSender).send(any(SimpleMailMessage.class));

        // Act & Assert
        assertThrows(EmailException.class, () -> emailService.sendEmail(recipient, message));
    }
}

