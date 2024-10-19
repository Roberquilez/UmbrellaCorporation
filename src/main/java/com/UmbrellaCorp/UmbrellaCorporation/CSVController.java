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

    @GetMapping("/datos-csv")
    public List<String[]> procesarCSV(@RequestParam(required = false) String filePath) {
        String path = (filePath != null) ? filePath : "src/res/gifted_iq_data.csv"; // Usa la ruta por defecto si no se proporciona
        try {
            return lectorDatosCSV.leerCSVConcurrencia(path);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
