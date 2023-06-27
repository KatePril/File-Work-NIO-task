package app.service;

import app.utils.Constants;

import java.nio.file.Path;

public class FileService {
    protected String fileName;

    public FileService(String fileName) {
        this.fileName = fileName;
    }

    protected Path getPath(String fileName) {
        return Path.of(Constants.BASE_PATH + Constants.BASE_PATH_IN + fileName + ".txt");
    }
}
