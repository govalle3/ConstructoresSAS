package com.ceiba.ConstructoresSAS.domain.reports.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;


import com.ceiba.ConstructoresSAS.domain.reports.service.FileExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DownloadController {

    @Autowired
    private FileExporter fileExporter;


    @RequestMapping("/download") // apunta a LOCAL localhost:8080/download
    public ResponseEntity<InputStreamResource> downloadTextFileExample1() throws FileNotFoundException {
        String fileName = "Reporte_Construccion.txt"; // TODO
        String fileContent = "Simple Solution \n Download Example 1"; // TODO

        // Create text file
        Path exportedPath = fileExporter.export(fileContent, fileName);

        // Download file with InputStreamResource
        File exportedFile = exportedPath.toFile();
        FileInputStream fileInputStream = new FileInputStream(exportedFile);
        InputStreamResource inputStreamResource = new InputStreamResource(fileInputStream);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
                .contentType(MediaType.TEXT_PLAIN)
                .contentLength(exportedFile.length())
                .body(inputStreamResource);
    }
}
