package com.UmbrellaCorp.UmbrellaCorporation;

import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;

@Service
public class LectorDatosCSV {

    private static final int THREAD_COUNT = 4;
    private static final int BATCH_SIZE = 1000;

    public List<String[]> leerCSVConcurrencia(String filePath) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        List<Future<List<String[]>>> futures = new ArrayList<>();

        // Leer el archivo CSV
        List<String> allLines = Files.readAllLines(Paths.get(filePath));
        List<String> dataLines = allLines.subList(1, allLines.size());  // Saltar cabecera

        // Dividir en bloques y procesar concurrentemente
        for (int i = 0; i < dataLines.size(); i += BATCH_SIZE) {
            List<String> batch = dataLines.subList(i, Math.min(i + BATCH_SIZE, dataLines.size()));
            futures.add(processBatch(batch, executor));
        }

        // Procesar los resultados
        List<String[]> finalData = new ArrayList<>();
        for (Future<List<String[]>> future : futures) {
            finalData.addAll(future.get());
        }

        executor.shutdown();
        return finalData;
    }

    private Future<List<String[]>> processBatch(List<String> batch, ExecutorService executor) {
        return executor.submit(() -> {
            List<String[]> processedBatch = new ArrayList<>();
            for (String line : batch) {
                String[] values = line.split(",");
                processedBatch.add(values);
            }
            return processedBatch;
        });
    }
}