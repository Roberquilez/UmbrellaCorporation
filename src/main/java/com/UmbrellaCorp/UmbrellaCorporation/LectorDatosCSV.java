package com.UmbrellaCorp.UmbrellaCorporation;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.nio.file.*;

public class LectorDatosCSV {
    private static final int THREAD_COUNT = 4;  // Número de hilos
    private static final int BATCH_SIZE = 1000; // Cantidad de líneas por bloque

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        List<Future<List<String[]>>> futures = new ArrayList<>();

        // Leer el archivo entero
        List<String> allLines = Files.readAllLines(Paths.get("/res/gifted_iq_data.csv"));

        // Saltar la cabecera del CSV
        List<String> dataLines = allLines.subList(1, allLines.size());

        // Dividir el CSV en bloques
        for (int i = 0; i < dataLines.size(); i += BATCH_SIZE) {
            List<String> batch = dataLines.subList(i, Math.min(i + BATCH_SIZE, dataLines.size()));
            futures.add(processBatch(batch, executor));
        }

        // Procesar los resultados de cada hilo concurrente
        for (Future<List<String[]>> future : futures) {
            List<String[]> result = future.get();
            // Aquí puedes trabajar con los resultados de cada batch
            result.forEach(row -> System.out.println(Arrays.toString(row)));
        }

        executor.shutdown();
    }

    private static Future<List<String[]>> processBatch(List<String> batch, ExecutorService executor) {
        return executor.submit(() -> {
            List<String[]> processedBatch = new ArrayList<>();
            for (String line : batch) {
                String[] values = line.split(",");
                processedBatch.add(values);
            }
            return processedBatch;  // Devuelve el bloque procesado
        });
    }
}
