package com.pageobect.demo.Utilities;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Reports {

    private String targetDir;

    public void setTargetDir(String targetDir) {
        this.targetDir = targetDir;
    }

    private String getTargetDir() {
        return targetDir;
    }

    public void generateReports(){
        File reportOutputDirectory = new File(getTargetDir());
        List<String> jsonFiles = this.getAllJsonFilesUnderTarget(getTargetDir());

        Configuration configuration = new Configuration(reportOutputDirectory, "Demo");
        configuration.setParallelTesting(true);
        configuration.setRunWithJenkins(false);
        configuration.setBuildNumber("1.0");
        configuration.addClassifications("Platform", "Windows");
        configuration.addClassifications("Browser", "");
        configuration.addClassifications("Branch", "");
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }

    public void generateReports(String targetDir){
        setTargetDir(targetDir);
        generateReports();
    }

    private List<String> getAllJsonFilesUnderTarget(String folderLocation){
        List<String> jsonFiles = new ArrayList<>();
        File directory = new File(folderLocation);
        File[] files = directory.listFiles((file,name) -> name.endsWith(".json"));
        if(files != null && files.length > 0) {
            for (File f : files) {
                jsonFiles.add(folderLocation + "/" + f.getName());
            }
        }
        return jsonFiles;
    }

}
