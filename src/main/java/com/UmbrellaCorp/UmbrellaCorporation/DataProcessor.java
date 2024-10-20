package com.UmbrellaCorp.UmbrellaCorporation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataProcessor {
    private static final Logger logger = LoggerFactory.getLogger(DataProcessor.class);

    public void processData() {
        try {
            // Código de procesamiento de datos
            logger.info("Procesamiento de datos iniciado.");
            // Simulación de procesamiento
            Thread.sleep(1000);
            logger.info("Procesamiento de datos completado.");
        } catch (Exception e) {
            logger.error("Error durante el procesamiento de datos: ", e);
        }
    }
}
