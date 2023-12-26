package com.utils.csvToJson.Service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CsvService {

    public Mono<List<String>> loadAndConvertCsvToList(String filePath) {
        return Mono.fromCallable(() -> readCsvFile(filePath));
    }

    private List<String> readCsvFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);

        // Read all lines from the CSV file
        List<String> lines = Files.readAllLines(path);

        // Alternatively, if you want to skip the header line, you can use:
        // List<String> lines = Files.readAllLines(path).subList(1, Files.readAllLines(path).size());

        // Process and convert lines to a list
        return lines.stream()
                .map(line -> {
                    // Process each line as needed (e.g., split by comma)
                    // For simplicity, this example just returns the entire line
                    return line;
                })
                .collect(Collectors.toList());
    }
}