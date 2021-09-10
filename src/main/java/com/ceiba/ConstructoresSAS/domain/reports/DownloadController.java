package com.ceiba.ConstructoresSAS.domain.reports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;


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

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/download1")
    public ResponseEntity<InputStreamResource> downloadTextFileExample1() throws FileNotFoundException {
        String fileName = "example1.txt";
        String fileContent = "Simple Solution \nDownload Example 1";

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
