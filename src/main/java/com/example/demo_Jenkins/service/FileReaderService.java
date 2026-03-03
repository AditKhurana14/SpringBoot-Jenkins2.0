package com.example.demo_Jenkins.service;

import java.io.IOException;
import java.util.List;

public interface FileReaderService {
    List<String> readEmail(String filePath) throws IOException;
}
