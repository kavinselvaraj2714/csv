/*
package com.utils.csvToJson.controller;

import com.utils.csvToJson.model.CsvEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/csv")
public class CsvBufferController {
    private static final String CSV_FILE_PATH = "D:\\new.csv";  // Replace with your actual file path

    @GetMapping(value = "/convertToJson", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<CsvEntity> convertCsvToJson() {
        return readCsvFile();
    }

    private Flux<CsvEntity> readCsvFile() {
        Path path = Paths.get(CsvBufferController.CSV_FILE_PATH);

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            // Skip the header line
            List<String> lines = reader.lines().skip(1).toList();
            List<CsvEntity> csvEntities = lines.stream()
                    .map(line -> {
                        String[] values = line.split(",");
                        return new CsvEntity(values[0], values[1], values[2]);
                    })
                    .collect(Collectors.toList());

            return Flux.fromIterable(csvEntities);
        } catch (IOException e) {
            throw new RuntimeException("Error reading CSV file", e);
        }
    }
}

*/
