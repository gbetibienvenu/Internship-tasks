//package com.BookShopFlexisaf.Project.config;
//
//import org.flywaydb.core.Flyway;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//
//import jakarta.annotation.PostConstruct;
//
//@Configuration
//public class FlywayConfig {
//
//    @Value("${spring.datasource.url}")
//    private String url;
//
//    @Value("${spring.datasource.username}")
//    private String user;
//
//    @Value("${spring.datasource.password}")
//    private String password;
//
//    @PostConstruct
//    public void migrate() {
//        Flyway.configure()
//                .dataSource(url, user, password)
//                .baselineOnMigrate(true)
//                .load()
//                .migrate();
//    }
//}