package com.utils.csvToJson.controller;

import com.opencsv.CSVReader;
import com.utils.csvToJson.model.CsvEntity;
import lombok.SneakyThrows;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/csv")
public class CsvController {

    @PostMapping(value = "/convertToJson", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<CsvEntity> convertCsvToJson(FilePart filePart) {
        return filePart
                .content()
                .flatMap(dataBuffer -> readCsvFile(dataBuffer));
    }

    @SneakyThrows
    private Flux<CsvEntity> readCsvFile(DataBuffer dataBuffer) {
        // Convert DataBuffer to Reader
        Reader reader = new InputStreamReader(dataBuffer.asInputStream());

        // Parse CSV using OpenCSV
        CSVReader csvReader = new CSVReader(reader);

        // Convert CSV rows to CsvEntity objects
        List<CsvEntity> csvEntities = csvReader.readAll().stream()
                .skip(1) // Skip header
                .map(values -> new CsvEntity(values[0], values[1], values[2]))
                .collect(Collectors.toList());

        return Flux.fromIterable(csvEntities);
    }
}
