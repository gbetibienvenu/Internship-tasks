package com.example.EmailSchedulerapp.controller;

import com.example.EmailSchedulerapp.service.EmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(EmailController.class)
public class EmailControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmailService emailService;

    @BeforeEach
    void setUp() {
        Mockito.doNothing().when(emailService).sendEmail(Mockito.anyString(), Mockito.anyString());
    }

    @Test
    public void testSendEmail_Success() throws Exception {
        mockMvc.perform(post("/api/email/send")
                        .param("recipient", "test@example.com")
                        .param("message", "Hello, this is a test email!")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Email sent successfully!"));
    }

    @Test
    public void testSendEmail_InvalidRequest() throws Exception {
        mockMvc.perform(post("/api/email/send")
                        .param("recipient", "")  // Empty recipient to simulate invalid input
                        .param("message", "Test message")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());  // Adjust based on actual validation
    }
}

