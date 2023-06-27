package app.models;

import app.service.FileReadService;
import app.service.FileWriteService;

public class AppModel {
    private FileReadService fileReadService;
    private FileWriteService fileWriteService;

    public AppModel(String fileName) {
        this.fileReadService = new FileReadService(fileName);
    }

    public AppModel(String fileName, String fileText) {
        this.fileWriteService = new FileWriteService(fileName, fileText);
    }

    public FileReadService getFileReadService() {
        return fileReadService;
    }

    public void setFileReadService(FileReadService fileReadService) {
        this.fileReadService = fileReadService;
    }

    public FileWriteService getFileWriteService() {
        return fileWriteService;
    }

    public void setFileWriteService(FileWriteService fileWriteService) {
        this.fileWriteService = fileWriteService;
    }
}
