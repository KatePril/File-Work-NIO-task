package app.service;

import app.utils.Constants;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class FileWriteService extends FileService{
    private String fileText;

    public FileWriteService(String fileName, String fileText) {
        super(fileName);
        this.fileText = fileText;
    }

    public String writeFile() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(fileText.getBytes());
        byteBuffer.flip();

        try (AsynchronousFileChannel channel =
                AsynchronousFileChannel.open(getPath(fileName),
                        StandardOpenOption.WRITE)) {
            Future<Integer> bytes = channel.write(byteBuffer, 0);
            while (!bytes.isDone()) {
                System.out.println(Constants.WRITING_PROCESSING_MSG);
            }
            byteBuffer.clear();
            return Constants.SUCCESSFUL_OPERATION_MSG;
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    public String createFile() {
        Path path = getPath(fileName);
        File file = path.toFile();

        if (file.exists()) {
            return Constants.FILE_EXISTS_MSG;
        } else {
            try {
                file.createNewFile();
                return  Constants.FILE_CREATED_MSG;
            } catch (IOException e) {
                return e.getMessage();
            }
        }
    }
}
