package com.example.demo_Jenkins.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileReaderServiceImpl implements FileReaderService{

    @Override
    public List<String> readEmail(String filePath) throws IOException {
       return  Files.readAllLines(Paths.get(filePath))
               .stream()
               .filter(email->!email.isBlank())
               .toList();
    }
}
