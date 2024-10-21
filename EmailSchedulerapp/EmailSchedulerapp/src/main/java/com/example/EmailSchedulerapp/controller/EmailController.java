package com.example.EmailSchedulerapp.controller;

import com.example.EmailSchedulerapp.service.EmailService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Setter(onMethod_ = @Autowired)  // Lombok - Setter injection
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestParam String recipient, @RequestParam String message) {
        emailService.sendEmail(recipient, message);
        return "Email sent successfully!";
    }
}
