package com.ceiba.ConstructoresSAS.domain.reports;

import java.nio.file.Path;

public interface FileExporter {

    Path export(String fileContent, String fileName);
}
