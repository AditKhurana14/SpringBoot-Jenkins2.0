package com.example.demo_Jenkins.runner;

import com.example.demo_Jenkins.service.EmailService;
import com.example.demo_Jenkins.service.FileReaderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class StartupRunner implements CommandLineRunner {

    private final EmailService emailService;

    private final FileReaderService fileReaderService;
    private final ConfigurableApplicationContext context;

    public StartupRunner(EmailService emailService, FileReaderService fileReaderService,
                         ConfigurableApplicationContext context) {
        this.emailService = emailService;
        this.fileReaderService = fileReaderService;
        this.context = context;
    }

    @Override
    public void run(String... args) throws IOException {

        if(args.length==0){
            System.out.println("File path required!");
            System.exit(1);
        }

       String filePath=args[0];

        List<String> emails = fileReaderService.readEmail(filePath);

        for (String email : emails) {
            emailService.sendEmail(
                    email,
                    "Test Subject",
                    "Hello from Spring Boot JAR"
            );
        }


        int exitCode = org.springframework.boot.SpringApplication.exit(context);
        System.exit(exitCode);
    }
}