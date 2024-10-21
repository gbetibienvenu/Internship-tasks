package com.example.EmailSchedulerapp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Slf4j  // Lombok - For logging
public class SchedulerService {

    @Autowired  // Field-based injection
    private EmailService emailService;

    @Scheduled(cron = "0 0/1 * * * ?")  // Runs every minute
    public void scheduleEmail() {
        log.info("Scheduled task started...");
        emailService.sendEmail("test@example.com", "This is a scheduled email.");
    }
}
