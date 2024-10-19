package com.UmbrellaCorp.UmbrellaCorporation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class CSVController {

    @Autowired
    private LectorDatosCSV lectorDatosCSV;

    @GetMapping("/procesar-csv")
    public List<String[]> procesarCSV(@RequestParam String filePath) {
        try {
            return lectorDatosCSV.leerCSVConcurrencia(filePath);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
